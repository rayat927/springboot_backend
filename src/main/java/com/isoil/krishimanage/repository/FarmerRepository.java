package com.isoil.krishimanage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isoil.krishimanage.model.Farmer;

public interface FarmerRepository extends JpaRepository<Farmer, Long> {
    public Farmer findByUserId(Long userId);
    public List<Farmer> findByApproved(boolean approved);
}