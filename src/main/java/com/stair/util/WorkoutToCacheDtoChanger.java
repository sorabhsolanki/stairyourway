package com.stair.util;

import com.stair.dto.cache.CacheDto;
import com.stair.persistent.entity.Workout;

/*
This is a static class responsible for changing the workout class object into
CacheDto class object.
 */
public class WorkoutToCacheDtoChanger {

    public static CacheDto convertToCacheDtoObject(Workout workout){
        return new CacheDto(workout.getEmail(), workout.getEmail(), workout.getFloorUpDirection(),
                workout.getFloorDownDirection(), workout.getTotalPoints());
    }
}
