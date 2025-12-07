package com.isoil.krishimanage.response;

import com.isoil.krishimanage.model.TreatmentReply;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TreatmentReplyResponseDTO {
    private Long id;
    private String message;
    private String repliedBy;
    private Long repliedById;
    private Date replyDate;
    private List<String> imageUrls;

    // Constructors
    public TreatmentReplyResponseDTO() {}

    public TreatmentReplyResponseDTO(TreatmentReply treatmentReply) {
        this.id = treatmentReply.getId();
        this.message = treatmentReply.getMessage();
        this.repliedBy = treatmentReply.getRepliedBy();
        this.repliedById = treatmentReply.getRepliedById();
        this.replyDate = treatmentReply.getReplyDate();
        this.imageUrls = treatmentReply.getImages().stream()
                .map(image -> image.getImageUrl())
                .collect(Collectors.toList());
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

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
