package com.stair.persistent;

import com.stair.cache.WorkoutCache;
import com.stair.persistent.entity.Workout;
import com.stair.persistent.repository.WorkoutRepository;
import com.stair.util.WorkoutToCacheDtoChanger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.rmi.runtime.Log;

import java.util.List;

/*
The class is responsible for reading DB and feed the cache.
This job runs after every 5 sec.
 */
public class CacheFeederJob implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(CacheFeederJob.class);

    private WorkoutCache workoutCache;
    private WorkoutRepository workoutRepository;

    public CacheFeederJob(WorkoutRepository workoutRepository, WorkoutCache workoutCache) {
        this.workoutRepository = workoutRepository;
        this.workoutCache = workoutCache;
    }

    @Override
    public void run() {
        LOG.info("Running CacheFeederJob");
        List<Workout> workouts = workoutRepository.findAll();
        for (Workout workout : workouts) {
            LOG.info("======================================" + workout.getEmail());
            workoutCache.insert(WorkoutToCacheDtoChanger.convertToCacheDtoObject(workout));
        }

    }
}
