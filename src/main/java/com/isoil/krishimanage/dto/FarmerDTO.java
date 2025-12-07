package com.isoil.krishimanage.dto;

public class FarmerDTO {
    private Long userId;
    private String landArea;
    private String experience;
    private String latitude;
    private String longitude;
    private String groupName;

    // getters and setters
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getLandArea() { return landArea; }
    public void setLandArea(String landArea) { this.landArea = landArea; }
    public String getExperience() { return experience; }
    public void setExperience(String experience) { this.experience = experience; }
    public String getLatitude() { return latitude; }
    public void setLatitude(String latitude) { this.latitude = latitude; }
    public String getLongitude() { return longitude; }
    public void setLongitude(String longitude) { this.longitude = longitude; }
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
}
