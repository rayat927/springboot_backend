package com.isoil.krishimanage.service;

import java.util.List;

import com.isoil.krishimanage.dto.FarmerDTO;
import com.isoil.krishimanage.model.Farmer;
import com.isoil.krishimanage.response.FarmerResponseDTO;

public interface FarmerService {
    public FarmerResponseDTO createFarmer(FarmerDTO farmerDTO);
    public String updateFarmer(Farmer farmer);
    public String deleteFarmer(Long id);
    public Farmer getFarmer(Long id);
    public FarmerResponseDTO getFarmerByUserId(Long userId);
    public List<FarmerResponseDTO> getAllFarmers();
    public String approveFarmer(Long id);
    public List<FarmerResponseDTO> getNotApprovedFarmer();
    public List<FarmerResponseDTO> getApprovedFarmer();
}
