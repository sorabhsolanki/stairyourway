package com.stair.connector;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stairyourway")
public class StairConnector {

    private static final Logger LOG = org.slf4j.LoggerFactory.getLogger(StairConnector.class);

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity get(){
        return new ResponseEntity("Running", HttpStatus.OK);
    }

}
