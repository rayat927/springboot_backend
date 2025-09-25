package com.isoil.krishimanage.service.impl;
import org.springframework.stereotype.Service;

import com.isoil.krishimanage.model.Land;
import com.isoil.krishimanage.service.LandService;
import com.isoil.krishimanage.repository.LandRepository;

@Service
public class LandServiceImpl implements LandService {
    LandRepository landRepository;

    public LandServiceImpl(LandRepository landRepository) {
        this.landRepository = landRepository;
    }
    
    @Override
    public Land createLand(Land land) {
         landRepository.save(land);
            return "Land created successfully";
    }

    @Override
    public Land updateLand(Land land) {
        landRepository.save(land);
            return "Land updated successfully";
    }

    @Override
    public Land deleteLand(Long id) {
        landRepository.deleteById(id);
            return "Land deleted successfully";
    }

    @Override
    public Land getLandById(Long id) {
        return landRepository.findById(id).orElse(null);
    }

    @Override
    public Land[] getAllLands() {
        return landRepository.findAll().toArray(new Land[0]);
    }

    
}
