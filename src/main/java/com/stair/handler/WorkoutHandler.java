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

    private final String HEADER = "<div class=\"single-service\">\n" +
            "<div class=\"wow scaleIn\" data-wow-duration=\"500ms\" data-wow-delay=\"300ms\">";

    private final String IMG_TAG = "<img src=\"resources/images/home/icon1.png\" alt=\"\">";
    private final String END_DIV = "</div>";
    private final String START_H2 = "<h2>";
    private final String END_H2 = "</h2>";

    @Autowired
    private WorkoutAdapter workoutAdapter;

    public boolean submitWorkout(WorkoutDto workoutDto){
        return workoutAdapter.submitWorkout(workoutDto);
    }

    public String extractTop10DailyWorkout(){
        List<CacheDto> cacheDtos =  workoutAdapter.extractTop10DailyWorkout();
        StringBuilder stringBuilder = new StringBuilder();

        for(CacheDto cacheDto : cacheDtos){
            stringBuilder.append(HEADER);
            stringBuilder.append(IMG_TAG);
            stringBuilder.append(END_DIV);
            stringBuilder.append(START_H2);
            stringBuilder.append(cacheDto.getName());
            stringBuilder.append(END_H2);
            stringBuilder.append(END_DIV);
        }

        return stringBuilder.toString();
    }
}
