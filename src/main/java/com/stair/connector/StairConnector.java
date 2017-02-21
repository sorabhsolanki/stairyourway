package com.stair.connector;

import com.stair.dto.LoginDto;
import com.stair.dto.WorkoutDto;
import com.stair.dto.cache.CacheDto;
import com.stair.handler.LoginHandler;
import com.stair.handler.WorkoutHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/stairyourway")
public class StairConnector {

    private static final Logger LOG = LoggerFactory.getLogger(StairConnector.class);

    @Autowired
    private WorkoutHandler workoutHandler;

    @Autowired
    private LoginHandler loginHandler;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get() {
        return new ResponseEntity("Running", HttpStatus.OK);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity login(HttpServletRequest request, @RequestBody @Valid LoginDto loginDto) {
        LOG.info("Request came for login");
        HttpSession session = loginHandler.authenticate(request, loginDto);

        if(session == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Cookie", "JSESSIONID=" + session.getId());

        return new ResponseEntity(requestHeaders, HttpStatus.OK);
    }

    @RequestMapping(value = "/workout", method = RequestMethod.POST)
    public ResponseEntity submitWorkout(HttpServletRequest request,
                                        @RequestBody @Valid WorkoutDto workoutDto) {
        if(loginHandler.authorizeUser(request)){
            workoutHandler.submitWorkout(workoutDto);
            return new ResponseEntity("Workout submitted", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity("Please login first", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/getTopLinks", method = RequestMethod.GET)
    public ResponseEntity<List<CacheDto>> getTop10DailyWorkout(){
        List<CacheDto> cacheDtos = workoutHandler.extractTop10DailyWorkout();
        return new ResponseEntity(cacheDtos, HttpStatus.OK);
    }

}
