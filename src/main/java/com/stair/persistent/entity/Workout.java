package com.stair.persistent.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Workout")
public class Workout {

    @Id
    private String email;

    private String floorUpDirection;

    private String floorDownDirection;

    private double totalPoints;

    public Workout(String email,
                   String floorUpDirection,
                   String floorDownDirection) {
        this.email = email;
        this.floorUpDirection = floorUpDirection;
        this.floorDownDirection = floorDownDirection;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }
}
