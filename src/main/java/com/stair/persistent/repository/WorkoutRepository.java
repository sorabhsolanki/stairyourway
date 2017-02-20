package com.stair.persistent.repository;

import com.stair.persistent.entity.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends MongoRepository<Workout, String>{
}
