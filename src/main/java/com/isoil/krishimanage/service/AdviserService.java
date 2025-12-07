package com.isoil.krishimanage.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.isoil.krishimanage.dto.AdviserRequestDTO;
import com.isoil.krishimanage.model.Adviser;
import com.isoil.krishimanage.model.User;
import com.isoil.krishimanage.repository.AdviserRepository;
import com.isoil.krishimanage.repository.UserRepository;
import com.isoil.krishimanage.response.AdviserResponseDTO;

@Service
public class AdviserService {
    private final AdviserRepository adviserRepository;
    private final UserRepository userRepository;

    public AdviserService(AdviserRepository adviserRepository, UserRepository userRepository) {
        this.adviserRepository = adviserRepository;
        this.userRepository = userRepository;
    }

    
    public AdviserResponseDTO createAdviser(AdviserRequestDTO adviserDTO) {
        User user = userRepository.findById(adviserDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + adviserDTO.getUserId()));
        
        Adviser adviser = new Adviser();
        adviser.setUser(user);
        adviser.setDegree(adviserDTO.getDegree());
        adviser.setExperience(adviserDTO.getExperience());
        adviser.setExpertize(adviserDTO.getExpertize());
        adviser.setFarmerNumber(adviserDTO.getFarmerNumber());
        adviser.setOrgName(adviserDTO.getOrgName());
        
        Adviser savedAdviser = adviserRepository.save(adviser);
        return new AdviserResponseDTO(savedAdviser);
    }

    
    public AdviserResponseDTO updateAdviser(Long id, AdviserRequestDTO adviserDTO) {
        Adviser existingAdviser = adviserRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Adviser not found with id: " + id));
        
        User user = userRepository.findById(adviserDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + adviserDTO.getUserId()));
        
        existingAdviser.setUser(user);
        existingAdviser.setDegree(adviserDTO.getDegree());
        existingAdviser.setExperience(adviserDTO.getExperience());
        existingAdviser.setExpertize(adviserDTO.getExpertize());
        existingAdviser.setFarmerNumber(adviserDTO.getFarmerNumber());
        existingAdviser.setOrgName(adviserDTO.getOrgName());
        
        Adviser updatedAdviser = adviserRepository.save(existingAdviser);
        return new AdviserResponseDTO(updatedAdviser);
    }

    
    public String deleteAdviser(Long id) {
        adviserRepository.deleteById(id);
        return "Adviser deleted successfully";
    }

    
    public AdviserResponseDTO getAdviser(Long id) {
        Adviser adviser = adviserRepository.findById(id).orElse(null);
        return adviser != null ? new AdviserResponseDTO(adviser) : null;
    }

    
    public List<AdviserResponseDTO> getAllAdvisers() {
        return adviserRepository.findAll()
                .stream()
                .map(AdviserResponseDTO::new)
                .collect(Collectors.toList());
    }

    public AdviserResponseDTO getAdviserByUserId(Long userId) {
        Adviser adviser = adviserRepository.findByUserId(userId);
        return adviser != null ? new AdviserResponseDTO(adviser) : null;
    }

    public String approveAdviser(Long adviserId) {
        Adviser adviser = adviserRepository.findById(adviserId).orElse(null);
        if (adviser != null) {
            adviser.setApproved(true);
            adviserRepository.save(adviser);
            return "Adviser approved successfully";
        } else {
            return "Adviser not found";
        }
    }

    public List<AdviserResponseDTO> getNotApprovedAdvisers() {
        return adviserRepository.findByApproved(false)
                .stream()
                .map(AdviserResponseDTO::new)
                .collect(Collectors.toList());
    }

    public List<AdviserResponseDTO> getApprovedAdvisers() {
        return adviserRepository.findByApproved(true)
                .stream()
                .map(AdviserResponseDTO::new)
                .collect(Collectors.toList());
    }
    
}
