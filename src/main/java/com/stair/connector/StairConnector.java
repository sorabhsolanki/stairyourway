package com.stair.connector;

import com.stair.dto.WorkoutDto;
import com.stair.dto.cache.CacheDto;
import com.stair.handler.WorkoutHandler;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stairyourway")
public class StairConnector {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(StairConnector.class);

    @Autowired
    private WorkoutHandler workoutHandler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get() {
        return new ResponseEntity("Running", HttpStatus.OK);
    }

    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public ResponseEntity submitWorkout(@RequestBody @Valid WorkoutDto workoutDto) {
        workoutHandler.submitWorkout(workoutDto);
        return new ResponseEntity("Workout submitted", HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "/getTopLinks", method = RequestMethod.GET)
    public ResponseEntity<List<CacheDto>> getTop10DailyWorkout(){
        List<CacheDto> cacheDtos = workoutHandler.extractTop10DailyWorkout();
        return new ResponseEntity(cacheDtos, HttpStatus.OK);
    }

}
