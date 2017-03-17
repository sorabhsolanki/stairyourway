package com.stair;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stair.cache.WorkoutCache;
import com.stair.persistent.CacheFeederJob;
import com.stair.persistent.RepositoryFeederJob;
import com.stair.persistent.repository.WorkoutRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAutoConfiguration
@EnableMongoRepositories
@ComponentScan()
public class StairYourWay{

    private static final Logger LOG = LoggerFactory.getLogger(StairYourWay.class);

    @Autowired
    WorkoutRepository workoutRepository;

    @Autowired
    WorkoutCache workoutCache;

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonConverter.setObjectMapper(objectMapper);
        return jsonConverter;
    }

    @Bean
    public RepositoryFeederJob repositoryFeederJob() {
        RepositoryFeederJob job = new RepositoryFeederJob(workoutRepository);
        new Thread(job).start();
        return job;
    }

    @Bean
    public CacheFeederJob cacheFeederJob() {
        CacheFeederJob job = new CacheFeederJob(workoutRepository, workoutCache);
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(job, 0, 600, TimeUnit.SECONDS);
        return job;
    }

    public static void main(String[] args) {
        LOG.info("Booting up....");
        ApplicationContext applicationContext = SpringApplication.run(StairYourWay.class, args);
    }
}
