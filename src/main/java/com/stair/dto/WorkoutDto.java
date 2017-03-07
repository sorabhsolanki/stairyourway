package com.stair.dto;

import org.hibernate.validator.constraints.NotBlank;

public class WorkoutDto {

    @NotBlank
    private String email;

    private int floorUpDirection;

    private int floorDownDirection;

    public WorkoutDto() {
    }

    public WorkoutDto(String email, int floorUpDirection, int floorDownDirection) {
        this.email = email;
        this.floorUpDirection = floorUpDirection;
        this.floorDownDirection = floorDownDirection;
    }

    public String getEmail() {
        return email;
    }

    public int getFloorUpDirection() {
        return floorUpDirection;
    }

    public int getFloorDownDirection() {
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
