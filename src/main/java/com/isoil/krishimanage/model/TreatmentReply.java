package com.isoil.krishimanage.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "treatment_replies")
public class TreatmentReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String message;

    @Column(nullable = false)
    private String repliedBy; // "FARMER" or "ADVISER"

    @Column(nullable = false)
    private Long repliedById; // ID of farmer or adviser

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date replyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disease_report_id", nullable = false)
    private DiseaseReport diseaseReport;

    @OneToMany(mappedBy = "treatmentReply", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReplyImage> images = new ArrayList<>();

    // Constructors
    public TreatmentReply() {
        this.replyDate = new Date();
    }

    public TreatmentReply(String message, String repliedBy, Long repliedById, DiseaseReport diseaseReport) {
        this();
        this.message = message;
        this.repliedBy = repliedBy;
        this.repliedById = repliedById;
        this.diseaseReport = diseaseReport;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRepliedBy() {
        return repliedBy;
    }

    public void setRepliedBy(String repliedBy) {
        this.repliedBy = repliedBy;
    }

    public Long getRepliedById() {
        return repliedById;
    }

    public void setRepliedById(Long repliedById) {
        this.repliedById = repliedById;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public DiseaseReport getDiseaseReport() {
        return diseaseReport;
    }

    public void setDiseaseReport(DiseaseReport diseaseReport) {
        this.diseaseReport = diseaseReport;
    }

    public List<ReplyImage> getImages() {
        return images;
    }

    public void setImages(List<ReplyImage> images) {
        this.images = images;
    }
}
