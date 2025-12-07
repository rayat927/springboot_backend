package com.isoil.krishimanage.response;

import com.isoil.krishimanage.model.Adviser;

public class AdviserResponseDTO {
    private Long id;
    private String degree;
    private String experience;
    private String expertize;
    private String farmerNumber;
    private String orgName;
    private Long userId;
    private String username;
    private String email;
    private String phoneNumber;
    private boolean approved;
    private String profilePicture;
    private String userCode;

    // Default constructor
    public AdviserResponseDTO() {}

    // Constructor from Adviser entity
    public AdviserResponseDTO(Adviser adviser) {
        this.id = adviser.getId();
        this.degree = adviser.getDegree();
        this.experience = adviser.getExperience();
        this.expertize = adviser.getExpertize();
        this.farmerNumber = adviser.getFarmerNumber();
        this.orgName = adviser.getOrgName();
        this.userId = adviser.getUser() != null ? adviser.getUser().getId() : null;
        this.username = adviser.getUser() != null ? adviser.getUser().getName() : null;
        this.email = adviser.getUser() != null ? adviser.getUser().getEmail() : null;
        this.phoneNumber = adviser.getUser() != null ? adviser.getUser().getPhoneNumber() : null;
        this.approved = adviser.isApproved();
        this.profilePicture = adviser.getUser() != null ? adviser.getUser().getProfilePicture() : null;
        this.userCode = adviser.getUser() != null ? adviser.getUser().getUserCode() : null;
    }

    // Parameterized constructor

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getExpertize() {
        return expertize;
    }

    public void setExpertize(String expertize) {
        this.expertize = expertize;
    }

    public String getFarmerNumber() {
        return farmerNumber;
    }

    public void setFarmerNumber(String farmerNumber) {
        this.farmerNumber = farmerNumber;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}