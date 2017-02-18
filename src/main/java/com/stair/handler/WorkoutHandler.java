package com.stair.handler;

import com.stair.dto.WorkoutDto;
import com.stair.handler.adapter.WorkoutAdapter;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WorkoutHandler {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(WorkoutHandler.class);

    @Autowired
    private WorkoutAdapter workoutAdapter;

    public boolean submitWorkout(WorkoutDto workoutDto){
        return workoutAdapter.submitWorkout(workoutDto);
    }
}
