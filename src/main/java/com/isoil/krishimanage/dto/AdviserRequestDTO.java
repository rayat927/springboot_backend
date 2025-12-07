package com.isoil.krishimanage.dto;

public class AdviserRequestDTO {
    private Long userId;
    private String degree;
    private String experience;
    private String expertize;
    private String farmerNumber;
    private String orgName;

    // Default constructor
    public AdviserRequestDTO() {}

    // Parameterized constructor
    public AdviserRequestDTO(Long userId, String degree, String experience, String expertize, String farmerNumber, String orgName) {
        this.userId = userId;
        this.degree = degree;
        this.experience = experience;
        this.expertize = expertize;
        this.farmerNumber = farmerNumber;
        this.orgName = orgName;
    }

    // Getters and setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
