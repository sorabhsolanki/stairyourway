package com.stair.cache;

import com.stair.dto.cache.CacheDto;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.UUID;


/*
Test class for testing the workout cache.

Will be inserting various cacheDto, and will check the top 10.
*/
public class WorkoutCacheTest {

    private final CacheDto[] dtos = new CacheDto[15];
    private final WorkoutCache objUnderTest = new WorkoutCache();

    @Before
    public void setup(){
        for(int i = 0; i < dtos.length; i++){
            dtos[i] = new CacheDto(UUID.randomUUID().toString(), null, null, null, i);
        }
    }

    @Test
    public void insertAndExtractTest(){
        for(int i = 0; i < dtos.length; i++){
            objUnderTest.insert(dtos[i]);
        }

        /*for(int i = 0; i < 10; i++) {
            System.out.println(objUnderTest.extractMax().getTotalPoints());
        }*/

        for (CacheDto cacheDto : objUnderTest.extractTop10()) {
            System.out.println(cacheDto.getTotalPoints());
        }
    }


}