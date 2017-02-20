package com.stair.dto;

import javax.validation.constraints.NotNull;

public class WorkoutDto {

    @NotNull
    private String email;

    private String floorUpDirection;

    private String floorDownDirection;

    public WorkoutDto() {
    }

    public WorkoutDto(String email, String floorUpDirection, String floorDownDirection) {
        this.email = email;
        this.floorUpDirection = floorUpDirection;
        this.floorDownDirection = floorDownDirection;
    }

    public String getEmail() {
        return email;
    }

    public String getFloorUpDirection() {
        return floorUpDirection;
    }

    public String getFloorDownDirection() {
        return floorDownDirection;
    }

    @Override
    public String toString() {
        return "WorkoutDto{" +
                "email='" + email + '\'' +
                ", floorUpDirection='" + floorUpDirection + '\'' +
                ", floorDownDirection='" + floorDownDirection + '\'' +
                '}';
    }
}
