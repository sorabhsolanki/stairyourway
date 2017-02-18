package com.stair.dto;

import javax.validation.constraints.NotNull;

public class WorkoutDto {


    @NotNull
    private String email;
    @NotNull
    private String numberOfFloors;
    @NotNull
    private String stairDirection;


    public WorkoutDto() {
    }

    public WorkoutDto(String email,
                      String numberOfFloors,
                      String stairDirection) {
        this.email = email;
        this.numberOfFloors = numberOfFloors;
        this.stairDirection = stairDirection;
    }

    public String getEmail() {
        return email;
    }

    public String getNumberOfFloors() {
        return numberOfFloors;
    }

    public String getStairDirection() {
        return stairDirection;
    }

    @Override
    public String toString() {
        return "WorkoutDto{" +
                "email='" + email + '\'' +
                ", numberOfFloors='" + numberOfFloors + '\'' +
                ", stairDirection='" + stairDirection + '\'' +
                '}';
    }
}
