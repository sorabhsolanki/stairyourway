package com.stair.persistent.repository;

import com.stair.persistent.entity.Login;
import com.stair.persistent.entity.Workout;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends MongoRepository<Workout, String> {

    @Query("{'email':?0}")
    Workout getWorkoutForUser(String email);
}
