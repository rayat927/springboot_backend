package com.isoil.krishimanage.response;

import java.util.Date;
import java.util.List;

public class DiseaseReportResponse  {
    private Long id;
    private String title;
    private String description;
    private String status;
    private Date reportDate;
    private String treatment;
    private String farmerName;
    private Long farmerId;
    private String adviserName;
    private Long adviserId;
    private List<String> imageUrls;
    private List<TreatmentReplyResponseDTO> treatmentReplies;

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

   

    public String getFarmerName() {
        return farmerName;
    }

    public void setFarmerName(String farmerName) {
        this.farmerName = farmerName;
    }

    public Long getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Long farmerId) {
        this.farmerId = farmerId;
    }

    public String getAdviserName() {
        return adviserName;
    }

    public void setAdviserName(String adviserName) {
        this.adviserName = adviserName;
    }

    public Long getAdviserId() {
        return adviserId;
    }

    public void setAdviserId(Long adviserId) {
        this.adviserId = adviserId;
    }

    
    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
    public List<TreatmentReplyResponseDTO> getTreatmentReplies() {
        return treatmentReplies;
    }
 public void setTreatmentReplies(List<TreatmentReplyResponseDTO> treatmentReplies) {
        this.treatmentReplies = treatmentReplies;
    }

}
