package com.stair.handler.adapter;

import com.stair.dto.WorkoutDto;
import org.springframework.stereotype.Component;

@Component
public class WorkoutAdapter {

    public boolean submitWorkout(WorkoutDto workoutDto){
        Thread t = new Thread(new Task(workoutDto));
        t.start();
        return true;
    }
}
