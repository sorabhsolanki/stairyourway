package com.stair.dto.cache;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CacheDto implements Comparable<CacheDto>{

    // will act as unique key in cache
    private String email;

    private String name;
    
    private int floorUpDirection;

    private int floorDownDirection;

    private double totalPoints;

    @JsonIgnore
    private int index = -1;

    public CacheDto(String email, String name,
                    int floorUpDirection, int floorDownDirection, double totalPoints) {
        this.email = email;
        this.name = name;
        this.floorUpDirection = floorUpDirection;
        this.floorDownDirection = floorDownDirection;
        this.totalPoints = totalPoints;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public int getFloorUpDirection() {
        return floorUpDirection;
    }

    public int getFloorDownDirection() {
        return floorDownDirection;
    }

    public double getTotalPoints() {
        return totalPoints;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTotalPoints(double totalPoints) {
        this.totalPoints = totalPoints;
    }

    @Override
    public String toString() {
        return "CacheDto{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", floorUpDirection='" + floorUpDirection + '\'' +
                ", floorDownDirection='" + floorDownDirection + '\'' +
                ", totalPoints=" + totalPoints +
                ", index=" + index +
                '}';
    }

    @Override
    public int compareTo(CacheDto cacheDto) {
        int result = -1;
        if(this.getTotalPoints() < cacheDto.getTotalPoints())
            result = 1;
        return result;
    }
}
