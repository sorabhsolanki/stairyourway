package com.stair.persistent;


import com.stair.dto.WorkoutDto;
import com.stair.jobqueue.JobQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WorkoutRepository implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(WorkoutRepository.class);

    private final JobQueue queue = JobQueue.getInstance();

    @Override
    public void run() {
        while (true){
            try {
                WorkoutDto workoutDto = queue.pop();
                LOG.info("Poping new job from queue "+workoutDto.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
