package com.stair.handler;

import com.stair.dto.WorkoutDto;
import com.stair.dto.cache.CacheDto;
import com.stair.handler.adapter.WorkoutAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WorkoutHandler {

    private static final Logger LOG = LoggerFactory.getLogger(WorkoutHandler.class);

    @Autowired
    private WorkoutAdapter workoutAdapter;

    public boolean submitWorkout(WorkoutDto workoutDto){
        return workoutAdapter.submitWorkout(workoutDto);
    }

    public List<CacheDto> extractTop10DailyWorkout(){
        return workoutAdapter.extractTop10DailyWorkout();
    }
}
