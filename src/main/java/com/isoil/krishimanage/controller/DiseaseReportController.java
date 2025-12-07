package com.isoil.krishimanage.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isoil.krishimanage.model.DiseaseReport;
import com.isoil.krishimanage.model.ReportImage;
import com.isoil.krishimanage.requests.DiseaseReportRequest;
import com.isoil.krishimanage.requests.TreatmentReplyRequest;
import com.isoil.krishimanage.requests.TreatmentRequest;
import com.isoil.krishimanage.response.DiseaseReportResponse;
import com.isoil.krishimanage.response.TreatmentReplyResponseDTO;
import com.isoil.krishimanage.service.DiseaseReportService;
import com.isoil.krishimanage.service.TreatmentReplyService;

@RestController
@RequestMapping("/disease_report")
public class DiseaseReportController {
    
    @Autowired 
    private DiseaseReportService diseaseReportService;

     @Autowired
    private TreatmentReplyService treatmentReplyService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createDiseaseReport(@ModelAttribute DiseaseReportRequest request) {
        try {
            DiseaseReport report = diseaseReportService.createDiseaseReport(request);
            return ResponseEntity.ok(mapToResponse(report));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    
    @PutMapping("/{reportId}/treatment")
    public ResponseEntity<?> updateTreatment(@PathVariable Long reportId, 
                                           @RequestBody TreatmentRequest request) {
        try {
            DiseaseReport report = diseaseReportService.updateTreatment(reportId, request.getTreatment());
            return ResponseEntity.ok(mapToResponse(report));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }
    
    @GetMapping("/adviser/{adviserId}")
    public ResponseEntity<List<DiseaseReportResponse>> getAdviserReports(@PathVariable Long adviserId) {
        List<DiseaseReport> reports = diseaseReportService.getDiseaseReportsByAdviserId(adviserId);
        List<DiseaseReportResponse> response = reports.stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/farmer/{farmerId}")
    public ResponseEntity<List<DiseaseReportResponse>> getFarmerReports(@PathVariable Long farmerId) {
        List<DiseaseReport> reports = diseaseReportService.getDiseaseReportsByFarmerId(farmerId);
        List<DiseaseReportResponse> response = reports.stream()
            .map(this::mapToResponse)
            .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{reportId}")
    public ResponseEntity<?> getReportById(@PathVariable Long reportId) {
        try {
            DiseaseReport report = diseaseReportService.getDiseaseReportById(reportId);
            return ResponseEntity.ok(mapToResponse(report));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

     @PostMapping(value = "/{reportId}/replies", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createTreatmentReply(
            @PathVariable Long reportId,
            @ModelAttribute TreatmentReplyRequest request) {
        try {
            // Set the disease report ID from path variable
            request.setDiseaseReportId(reportId);
            TreatmentReplyResponseDTO response = treatmentReplyService.createTreatmentReply(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{reportId}/replies")
    public ResponseEntity<?> getTreatmentReplies(@PathVariable Long reportId) {
        try {
            List<TreatmentReplyResponseDTO> replies = treatmentReplyService.getTreatmentRepliesByDiseaseReport(reportId);
            return ResponseEntity.ok(replies);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{reportId}/replies/{repliedBy}")
    public ResponseEntity<?> getTreatmentRepliesByReplier(
            @PathVariable Long reportId, 
            @PathVariable String repliedBy) {
        try {
            List<TreatmentReplyResponseDTO> replies = treatmentReplyService
                    .getTreatmentRepliesByDiseaseReportAndReplier(reportId, repliedBy.toUpperCase());
            return ResponseEntity.ok(replies);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }

    @GetMapping("/{reportId}/with-replies")
    public ResponseEntity<?> getReportWithReplies(@PathVariable Long reportId) {
        try {
            DiseaseReport report = diseaseReportService.getDiseaseReportById(reportId);
            DiseaseReportResponse response = mapToResponseWithReplies(report);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
        }
    }



     private DiseaseReportResponse mapToResponse(DiseaseReport report) {
        DiseaseReportResponse response = new DiseaseReportResponse();
        response.setId(report.getId());
        response.setTitle(report.getTitle());
        response.setDescription(report.getDescription());
        response.setStatus(report.getStatus());
        response.setReportDate(report.getReportDate());
        response.setTreatment(report.getTreatment());
        response.setFarmerName(report.getFarmer().getUser().getName());
        response.setFarmerId(report.getFarmer().getId());
        response.setAdviserName(report.getAdviser().getUser().getName());
        response.setAdviserId(report.getAdviser().getId());
        
        List<String> imageUrls = report.getImages().stream()
            .map(ReportImage::getImageUrl)
            .collect(Collectors.toList());
        response.setImageUrls(imageUrls);
        
        return response;
    }

     private DiseaseReportResponse mapToResponseWithReplies(DiseaseReport report) {
        DiseaseReportResponse response = mapToResponse(report);
        
        // Add treatment replies to the response
        List<TreatmentReplyResponseDTO> replies = treatmentReplyService
                .getTreatmentRepliesByDiseaseReport(report.getId());
        response.setTreatmentReplies(replies);
        
        return response;
    }
}
