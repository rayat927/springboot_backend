package com.isoil.krishimanage.requests;

import org.springframework.web.multipart.MultipartFile;
import java.util.List;

public class TreatmentReplyRequest {
    private String message;
    private String repliedBy; // "FARMER" or "ADVISER"
    private Long repliedById;
    private Long diseaseReportId;
    private List<MultipartFile> images;

    // Constructors
    public TreatmentReplyRequest() {}

    public TreatmentReplyRequest(String message, String repliedBy, Long repliedById, Long diseaseReportId) {
        this.message = message;
        this.repliedBy = repliedBy;
        this.repliedById = repliedById;
        this.diseaseReportId = diseaseReportId;
    }

    // Getters and Setters
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

    public Long getDiseaseReportId() {
        return diseaseReportId;
    }

    public void setDiseaseReportId(Long diseaseReportId) {
        this.diseaseReportId = diseaseReportId;
    }

    public List<MultipartFile> getImages() {
        return images;
    }

    public void setImages(List<MultipartFile> images) {
        this.images = images;
    }
}
