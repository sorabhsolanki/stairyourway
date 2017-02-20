package com.stair.handler.adapter;

import com.stair.cache.WorkoutCache;
import com.stair.dto.WorkoutDto;
import com.stair.dto.cache.CacheDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkoutAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(WorkoutAdapter.class);

    @Autowired
    private WorkoutCache workoutCache;

    public boolean submitWorkout(WorkoutDto workoutDto){
        Thread t = new Thread(new Task(workoutDto));
        t.start();
        return true;
    }

    public List<CacheDto> extractTop10DailyWorkout(){
        LOG.info("extracting top 10 daily workout");
        List<CacheDto> cacheDtos = new ArrayList<>();
        CacheDto cacheDto;
        while((cacheDto = workoutCache.extractMax()) != null){
            cacheDtos.add(cacheDto);
        }
        return cacheDtos;
    }
}
