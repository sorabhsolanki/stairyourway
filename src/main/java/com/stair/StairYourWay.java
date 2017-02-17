package com.stair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan()
public class StairYourWay {

	private static final Logger LOG = LoggerFactory.getLogger(StairYourWay.class);

	public static void main(String[] args) {
        LOG.info("Booting up....");
        ApplicationContext applicationContext = SpringApplication.run(StairYourWay.class, args);
	}
}
