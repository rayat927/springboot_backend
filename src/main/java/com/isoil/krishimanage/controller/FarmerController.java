package com.isoil.krishimanage.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isoil.krishimanage.dto.FarmerDTO;
import com.isoil.krishimanage.model.Farmer;
import com.isoil.krishimanage.response.AdviserResponseDTO;
import com.isoil.krishimanage.response.FarmerResponseDTO;
import com.isoil.krishimanage.service.FarmerService;

@RestController
@RequestMapping("/farmer")
public class FarmerController {
    FarmerService farmerService;

    public FarmerController(FarmerService farmerService) {
        this.farmerService = farmerService;
    }
    
    @GetMapping("/")
    public List<FarmerResponseDTO> IgetAllFarmer() {
       return farmerService.getAllFarmers();
    }

    @GetMapping("/{id}")
    public Farmer getFarmerById(@PathVariable Long id) {
       return  farmerService.getFarmer(id);
        
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<FarmerResponseDTO> getFarmerByUserId(@PathVariable Long userId) {
        FarmerResponseDTO farmer = farmerService.getFarmerByUserId(userId);
        if (farmer != null) {
            return ResponseEntity.ok(farmer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public FarmerResponseDTO createFarmer(@RequestBody FarmerDTO farmerDTO) {
        return farmerService.createFarmer(farmerDTO);
        
    }

    @PutMapping("/")
    public String updateFarmer(Farmer farmer) {
        farmerService.updateFarmer(farmer);
        return "Farmer updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteFarmer(@PathVariable Long id) {
        farmerService.deleteFarmer(id);
        return "Farmer deleted successfully";
    }

    @PutMapping("/approve/{id}")
    public String approveFarmer(@PathVariable Long id) {
        return farmerService.approveFarmer(id);
    }


    @GetMapping("/not_approved")
    public List<FarmerResponseDTO> getNotApprovedFarmer() {
        return farmerService.getNotApprovedFarmer();
    }

    @GetMapping("/approved")
    public List<FarmerResponseDTO> getApprovedFarmer() {
        return farmerService.getApprovedFarmer();
    }
    
}
