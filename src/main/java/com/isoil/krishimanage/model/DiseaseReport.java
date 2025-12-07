package com.isoil.krishimanage.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "disease_reports")
public class DiseaseReport {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    // private Long farmerId;
    // private Long adviserId;
    private Date reportDate;
    private String treatment;
    private String status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "adviser_id")
    private Adviser adviser;
    @OneToMany(mappedBy = "diseaseReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReportImage> images = new ArrayList<>();

    @OneToMany(mappedBy = "diseaseReport", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TreatmentReply> treatmentReplies = new ArrayList<>();

    
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

    public Farmer getFarmer() {
        return farmer;
    }
    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }
    public Adviser getAdviser() {
        return adviser;
    }
    public void setAdviser(Adviser adviser) {
        this.adviser = adviser;
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }



    public List<ReportImage> getImages() {
        return images;
    }
    public void setImages(List<ReportImage> images) {
        this.images = images;
    }

    public List<TreatmentReply> getTreatmentReplies() {
    return treatmentReplies;
}

public void setTreatmentReplies(List<TreatmentReply> treatmentReplies) {
    this.treatmentReplies = treatmentReplies;
}

    

}
