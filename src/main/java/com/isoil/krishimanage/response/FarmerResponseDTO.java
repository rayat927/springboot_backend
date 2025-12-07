package com.isoil.krishimanage.response;

import com.isoil.krishimanage.model.Farmer;

public class FarmerResponseDTO {
    private Long id;
    private String landArea;
    private String experience;
    private String latitude;
    private String longitude;
    private String groupName;
    private Long userId; // Only include ID, not the entire User object
    private String username;
    private String email;
    private String phoneNumber;
    private boolean approved;
    private String profilePicture;
    private String userCode;

    // Constructor from Farmer entity
    public FarmerResponseDTO(Farmer farmer) {
        this.id = farmer.getId();
        this.landArea = farmer.getLandArea();
        this.experience = farmer.getExperience();
        this.latitude = farmer.getLatitude();
        this.longitude = farmer.getLongitude();
        this.groupName = farmer.getGroup();
        this.userId = farmer.getUser() != null ? farmer.getUser().getId() : null;
        this.username = farmer.getUser() != null ? farmer.getUser().getName() : null;
        this.email = farmer.getUser() != null ? farmer.getUser().getEmail() : null;
        this.phoneNumber = farmer.getUser() != null ? farmer.getUser().getPhoneNumber() : null;
        this.approved = farmer.isApproved();
        this.profilePicture = farmer.getUser() != null ? farmer.getUser().getProfilePicture() : null;
        this.userCode = farmer.getUser() != null ? farmer.getUser().getUserCode() : null;
    }

    // getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public boolean isApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
    public String getProfilePicture() { return profilePicture; }
    public void setProfilePicture(String profilePicture) { this.profilePicture = profilePicture; }
    public String getUserCode() { return userCode; }
    public void setUserCode(String userCode) { this.userCode = userCode; }
}