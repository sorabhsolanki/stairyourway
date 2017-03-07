package com.stair.persistent.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Workout")
public class Workout {

    @Id
    private String email;

    private int floorUpDirection;

    private int floorDownDirection;

    private double totalPoints;

    public Workout(String email,
                   int floorUpDirection,
                   int floorDownDirection) {
        this.email = email;
        this.floorUpDirection = floorUpDirection;
        this.floorDownDirection = floorDownDirection;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFloorUpDirection() {
        return floorUpDirection;
    }

    public void setFloorUpDirection(int floorUpDirection) {
        this.floorUpDirection = floorUpDirection;
    }

    public int getFloorDownDirection() {
        return floorDownDirection;
    }

    public void setFloorDownDirection(int floorDownDirection) {
        this.floorDownDirection = floorDownDirection;
    }

    public double getTotalPoints() {
        return totalPoints;
    }
}
