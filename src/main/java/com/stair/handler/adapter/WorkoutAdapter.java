package com.stair.handler.adapter;

import com.stair.cache.WorkoutCache;
import com.stair.dto.WorkoutDto;
import com.stair.dto.cache.CacheDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class WorkoutAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(WorkoutAdapter.class);

    @Autowired
    private WorkoutCache workoutCache;

    public boolean submitWorkout(WorkoutDto workoutDto) {
        Thread t = new Thread(new Task(workoutDto));
        t.start();
        return true;
    }

    public List<CacheDto> extractTop10DailyWorkout() {
        LOG.info("extracting top 10 daily workout");
        List<CacheDto> cacheDtoList = Arrays.asList(workoutCache.extractTop10());

        Collections.sort(cacheDtoList, new Comparator<CacheDto>() {
            @Override
            public int compare(CacheDto o1, CacheDto o2) {
                if (o1 == null || o2 == null)
                    return 1;
                return o1.compareTo(o2);
            }
        });

        List<CacheDto> cacheDtoListWithoutNull = new ArrayList<>();
        for (CacheDto cacheDto : cacheDtoList){
            if(cacheDto != null)
                cacheDtoListWithoutNull.add(cacheDto);
        }

        return cacheDtoListWithoutNull;
    }
}
