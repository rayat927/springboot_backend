package com.isoil.krishimanage.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.isoil.krishimanage.dto.FarmerDTO;
import com.isoil.krishimanage.model.Farmer;
import com.isoil.krishimanage.model.User;
import com.isoil.krishimanage.repository.FarmerRepository;
import com.isoil.krishimanage.repository.UserRepository;
import com.isoil.krishimanage.response.FarmerResponseDTO;
import com.isoil.krishimanage.service.FarmerService;

@Service
public class FarmerServiceImpl implements FarmerService {
    private final FarmerRepository farmerRepository;
    private final UserRepository userRepository; // You'll need this

    public FarmerServiceImpl(FarmerRepository farmerRepository, UserRepository userRepository) {
        this.farmerRepository = farmerRepository;
        this.userRepository = userRepository;
    }

    @Override
    public FarmerResponseDTO createFarmer(FarmerDTO farmerDTO) {
        User user = userRepository.findById(farmerDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        Farmer farmer = new Farmer();
        farmer.setUser(user);
        farmer.setLandArea(farmerDTO.getLandArea());
        farmer.setExperience(farmerDTO.getExperience());
        farmer.setLatitude(farmerDTO.getLatitude());
        farmer.setLongitude(farmerDTO.getLongitude());
        farmer.setGroup(farmerDTO.getGroupName());
        
        Farmer newFarmer = farmerRepository.save(farmer);
        return new FarmerResponseDTO(newFarmer);
    }

    @Override
    public String updateFarmer(Farmer farmer) {
        farmerRepository.save(farmer);
        return "Farmer updated successfully";
    }

    @Override
    public String deleteFarmer(Long id) {
        farmerRepository.deleteById(id);
        return "Farmer deleted successfully";
    }

    @Override
    public Farmer getFarmer(Long id) {
        return farmerRepository.findById(id).orElse(null);
    }

    @Override
    public List<FarmerResponseDTO> getAllFarmers() {
        return ((List<Farmer>) farmerRepository.findAll())
                .stream()
                .map(FarmerResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public FarmerResponseDTO getFarmerByUserId(Long userId) {
        Farmer farmer = farmerRepository.findByUserId(userId);
    if (farmer != null) {
        return new FarmerResponseDTO(farmer);
    } else {
        return null; // or throw an exception
    }
    }

    @Override
    public String approveFarmer(Long id) {
        Farmer farmer = farmerRepository.findById(id).orElse(null);
        if (farmer != null) {
            farmer.setApproved(true);
            farmerRepository.save(farmer);
            return "Farmer approved successfully";
        } else {
            return "Farmer not found";
        }
    }

    @Override
    public List<FarmerResponseDTO> getNotApprovedFarmer() {
        return ((List<Farmer>) farmerRepository.findByApproved(false))
                .stream()
                .map(FarmerResponseDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<FarmerResponseDTO> getApprovedFarmer() {
        return ((List<Farmer>) farmerRepository.findByApproved(true))
                .stream()
                .map(FarmerResponseDTO::new)
                .collect(Collectors.toList());
    }

    
    
}
