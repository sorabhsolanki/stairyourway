package com.stair.persistent.repository;

import com.stair.persistent.entity.Login;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends MongoRepository<Login, String>{

    @Query("{$and: [{'email':?0},{'password':?1}]}")
    Login checkIfUserExist(String email, String password);
}
