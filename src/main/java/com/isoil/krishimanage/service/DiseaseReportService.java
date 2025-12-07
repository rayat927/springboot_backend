package com.isoil.krishimanage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.transaction.Transactional;

import com.isoil.krishimanage.model.Adviser;
import com.isoil.krishimanage.model.DiseaseReport;
import com.isoil.krishimanage.model.Farmer;
import com.isoil.krishimanage.model.ReportImage;
import com.isoil.krishimanage.repository.AdviserRepository;
import com.isoil.krishimanage.repository.DiseaseRepository;
import com.isoil.krishimanage.repository.FarmerRepository;
import com.isoil.krishimanage.requests.DiseaseReportRequest;

@Service
@Transactional
public class DiseaseReportService {
    private DiseaseRepository diseaseReportRepository;

    @Autowired
    private FarmerRepository farmerRepository;

    @Autowired
    private AdviserRepository adviserRepository;

    @Autowired
    private FileStorageService fileStorageService;

    public DiseaseReportService(DiseaseRepository diseaseReportRepository) {
        this.diseaseReportRepository = diseaseReportRepository;
    }

    public DiseaseReport createDiseaseReport(DiseaseReportRequest diseaseReportRequest) {
        Farmer farmer = farmerRepository.findById(diseaseReportRequest.getFarmerId())
                .orElseThrow(() -> new RuntimeException("Farmer not found"));

        Adviser adviser = adviserRepository.findById(diseaseReportRequest.getAdviserId())
                .orElseThrow(() -> new RuntimeException("Adviser not found"));
        
        DiseaseReport report = new DiseaseReport();
        report.setTitle(diseaseReportRequest.getTitle());
        report.setDescription(diseaseReportRequest.getDescription());
        report.setFarmer(farmer);
        report.setAdviser(adviser);
        report.setReportDate(new java.util.Date());
        report.setStatus("PENDING");

        if(diseaseReportRequest.getImages() != null){
            for(MultipartFile file: diseaseReportRequest.getImages()){
                String fileName = fileStorageService.storeFile(file);

                ReportImage image = new ReportImage();
                image.setFileName(fileName);
                image.setImageUrl("/api/uploads/" + fileName);
                image.setDiseaseReport(report);
                report.getImages().add(image);
            }
        }

        return diseaseReportRepository.save(report);
        
    }

    public DiseaseReport updateTreatment(Long reportId, String treatment){
        DiseaseReport report = diseaseReportRepository.findById(reportId)
        .orElseThrow(() -> new RuntimeException("Disease report not found with id: " + reportId));
        report.setTreatment(treatment);
        
        return diseaseReportRepository.save(report);
    }

    public List<DiseaseReport> getAllDiseaseReports() {
        return diseaseReportRepository.findAll();
    } 

    public List<DiseaseReport> getDiseaseReportsByFarmerId(Long farmerId) {
        return diseaseReportRepository.findByFarmerId(farmerId);
    }

    public List<DiseaseReport> getDiseaseReportsByAdviserId(Long adviserId) {
        return diseaseReportRepository.findByAdviserId(adviserId);
    }

    public DiseaseReport getDiseaseReportById(Long id) {
        return diseaseReportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disease report not found with id: " + id));
    }


}
