package com.isoil.krishimanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.isoil.krishimanage.model.DiseaseReport;

public interface DiseaseRepository extends JpaRepository<DiseaseReport, Long> {
    List<DiseaseReport> findByFarmerId(Long farmerId);
    List<DiseaseReport> findByAdviserId(Long adviserId);
    
}
