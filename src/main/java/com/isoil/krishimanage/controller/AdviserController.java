package com.isoil.krishimanage.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isoil.krishimanage.dto.AdviserRequestDTO;
import com.isoil.krishimanage.model.Adviser;
import com.isoil.krishimanage.response.AdviserResponseDTO;
import com.isoil.krishimanage.service.AdviserService;

@RestController
@RequestMapping("/adviser")
public class AdviserController {
    AdviserService adviserService;

    public AdviserController(AdviserService adviserService) {
        this.adviserService = adviserService;
    }

    @GetMapping("/")
    public ResponseEntity<List<AdviserResponseDTO>> getAllAdvisers() {
        List<AdviserResponseDTO> advisers = adviserService.getAllAdvisers();
        return ResponseEntity.ok(advisers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdviserResponseDTO> getAdviserById(@PathVariable Long id) {
        AdviserResponseDTO adviser = adviserService.getAdviser(id);
        if (adviser != null) {
            return ResponseEntity.ok(adviser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

      @PostMapping("/")
    public ResponseEntity<AdviserResponseDTO> createAdviser(@RequestBody AdviserRequestDTO adviserDTO) {
        try {
            AdviserResponseDTO createdAdviser = adviserService.createAdviser(adviserDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdAdviser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdviserResponseDTO> updateAdviser(@PathVariable Long id, @RequestBody AdviserRequestDTO adviserDTO) {
        try {
            AdviserResponseDTO updatedAdviser = adviserService.updateAdviser(id, adviserDTO);
            return ResponseEntity.ok(updatedAdviser);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<AdviserResponseDTO> getAdviserByUserId(@PathVariable Long userId) {
        AdviserResponseDTO adviser = adviserService.getAdviserByUserId(userId);
        if (adviser != null) {
            return ResponseEntity.ok(adviser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAdviser(@PathVariable Long id) {
        try {
            adviserService.deleteAdviser(id);
            return ResponseEntity.ok("Adviser deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/approve/{id}")
    public String approveAdviser(@PathVariable Long id) {
        return adviserService.approveAdviser(id);
    }

    @GetMapping("/not_approved")
    public List<AdviserResponseDTO> getNotApprovedAdvisers() {
        return adviserService.getNotApprovedAdvisers();
    }

    @GetMapping("/approved")
    public List<AdviserResponseDTO> getApprovedAdvisers() {
        return adviserService.getApprovedAdvisers();
    }

    
}
