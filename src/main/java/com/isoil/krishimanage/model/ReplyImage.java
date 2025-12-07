package com.isoil.krishimanage.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reply_images")
public class ReplyImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fileName;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_reply_id", nullable = false)
    private TreatmentReply treatmentReply;

    // Constructors
    public ReplyImage() {}

    public ReplyImage(String fileName, String imageUrl, TreatmentReply treatmentReply) {
        this.fileName = fileName;
        this.imageUrl = imageUrl;
        this.treatmentReply = treatmentReply;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public TreatmentReply getTreatmentReply() {
        return treatmentReply;
    }

    public void setTreatmentReply(TreatmentReply treatmentReply) {
        this.treatmentReply = treatmentReply;
    }
}
