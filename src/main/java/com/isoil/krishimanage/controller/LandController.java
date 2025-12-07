package com.isoil.krishimanage.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.isoil.krishimanage.service.LandService;
import com.isoil.krishimanage.model.Land;


@RestController
@RequestMapping("/land")
public class LandController {
    LandService landService;

    public LandController(LandService landService) {
        this.landService = landService;
    }

    @GetMapping("/")
    public Land[] getAllLands() {
        return landService.getAllLands();
    }

    @GetMapping("/{id}")
    public Land getLandById(@PathVariable Long id) {
        return landService.getLandById(id);
    }

    @PostMapping("/")
    public String createLand(@RequestBody Land land) {
         landService.createLand(land);
         return "Land created successfully";
    }

    @PutMapping("/")
    public String updateLand(@RequestBody Land land) {
         landService.updateLand(land);
         return "Land updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteLand(@PathVariable Long id) {
        return landService.deleteLand(id);
    }

}
