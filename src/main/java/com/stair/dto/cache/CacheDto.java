package com.stair.dto.cache;

public class CacheDto {

    // will act as unique key in cache
    private String email;

    private String name;
    
    private String floorUpDirection;

    private String floorDownDirection;

    private String totalPoints;

    private int index = -1;

    public CacheDto(String email, String name,
                    String floorUpDirection, String floorDownDirection, String totalPoints) {
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

    public String getFloorUpDirection() {
        return floorUpDirection;
    }

    public String getFloorDownDirection() {
        return floorDownDirection;
    }

    public String getTotalPoints() {
        return totalPoints;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
