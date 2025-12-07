package com.isoil.krishimanage.service;

import com.isoil.krishimanage.model.DiseaseReport;
import com.isoil.krishimanage.model.TreatmentReply;
import com.isoil.krishimanage.model.ReplyImage;
import com.isoil.krishimanage.repository.DiseaseRepository;
import com.isoil.krishimanage.repository.TreatmentReplyRepository;
import com.isoil.krishimanage.requests.TreatmentReplyRequest;
import com.isoil.krishimanage.response.TreatmentReplyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TreatmentReplyService {

    @Autowired
    private TreatmentReplyRepository treatmentReplyRepository;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public TreatmentReplyResponseDTO createTreatmentReply(TreatmentReplyRequest request) {
        DiseaseReport diseaseReport = diseaseRepository.findById(request.getDiseaseReportId())
                .orElseThrow(() -> new RuntimeException("Disease report not found with id: " + request.getDiseaseReportId()));

        // Validate repliedBy and repliedById
        if (!"FARMER".equals(request.getRepliedBy()) && !"ADVISER".equals(request.getRepliedBy())) {
            throw new RuntimeException("repliedBy must be either 'FARMER' or 'ADVISER'");
        }

        TreatmentReply treatmentReply = new TreatmentReply();
        treatmentReply.setMessage(request.getMessage());
        treatmentReply.setRepliedBy(request.getRepliedBy());
        treatmentReply.setRepliedById(request.getRepliedById());
        treatmentReply.setDiseaseReport(diseaseReport);

        // Handle images
        if (request.getImages() != null && !request.getImages().isEmpty()) {
            for (MultipartFile file : request.getImages()) {
                String fileName = fileStorageService.storeFile(file);

                ReplyImage image = new ReplyImage();
                image.setFileName(fileName);
                image.setImageUrl("/api/uploads/" + fileName);
                image.setTreatmentReply(treatmentReply);
                treatmentReply.getImages().add(image);
            }
        }

        // Update disease report status based on who is replying
        if ("ADVISER".equals(request.getRepliedBy())) {
            diseaseReport.setStatus("ADVISER_RESPONDED");
        } else if ("FARMER".equals(request.getRepliedBy())) {
            diseaseReport.setStatus("FARMER_FOLLOWED_UP");
        }

        TreatmentReply savedReply = treatmentReplyRepository.save(treatmentReply);
        diseaseRepository.save(diseaseReport); // Save the updated status

        return new TreatmentReplyResponseDTO(savedReply);
    }

    public List<TreatmentReplyResponseDTO> getTreatmentRepliesByDiseaseReport(Long diseaseReportId) {
        List<TreatmentReply> replies = treatmentReplyRepository.findByDiseaseReportIdOrderByReplyDateAsc(diseaseReportId);
        return replies.stream()
                .map(TreatmentReplyResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<TreatmentReplyResponseDTO> getTreatmentRepliesByDiseaseReportAndReplier(Long diseaseReportId, String repliedBy) {
        List<TreatmentReply> replies = treatmentReplyRepository.findByDiseaseReportIdAndRepliedByOrderByReplyDateAsc(diseaseReportId, repliedBy);
        return replies.stream()
                .map(TreatmentReplyResponseDTO::new)
                .collect(Collectors.toList());
    }

    public TreatmentReplyResponseDTO getTreatmentReplyById(Long id) {
        TreatmentReply reply = treatmentReplyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treatment reply not found with id: " + id));
        return new TreatmentReplyResponseDTO(reply);
    }
}
