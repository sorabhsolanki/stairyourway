package com.stair.handler.adapter;

import com.stair.jobqueue.JobQueue;
import com.stair.dto.WorkoutDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(Task.class);

    private final WorkoutDto workoutDto;
    private final JobQueue queue = JobQueue.getInstance();

    public Task(WorkoutDto workoutDto) {
        this.workoutDto = workoutDto;
    }

    @Override
    public void run() {
        try {
            queue.push(workoutDto);
            callback(workoutDto.toString());
        } catch (InterruptedException e) {
            LOG.warn(e.getMessage());
        }
    }

    private void callback(String msg){
        LOG.info("Pushing new workout to queue "+msg);
    }
}
