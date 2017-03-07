package com.stair.dto.cache;

public class CacheDto implements Comparable<CacheDto>{

    // will act as unique key in cache
    private String email;

    private String name;
    
    private String floorUpDirection;

    private String floorDownDirection;

    private int totalPoints;

    private int index = -1;

    public CacheDto(String email, String name,
                    String floorUpDirection, String floorDownDirection, int totalPoints) {
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

    public int getTotalPoints() {
        return totalPoints;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setTotalPoints(int totalPoints) {
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
