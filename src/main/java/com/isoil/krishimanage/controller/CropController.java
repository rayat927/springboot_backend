package com.isoil.krishimanage.controller;

import org.springframework.web.bind.annotation.*;
import com.isoil.krishimanage.service.CropService;
import com.isoil.krishimanage.model.Crop;
import java.util.List;

@RestController
@RequestMapping("/crop")
@CrossOrigin(origins = "*") // Allow Flutter app to connect
public class CropController {
    private final CropService cropService;

    public CropController(CropService cropService) {
        this.cropService = cropService;
    }

    @GetMapping
    public List<Crop> getAllCrops() {
        return cropService.getAllCrops();
    }

    @GetMapping("/{id}")
    public Crop getCropById(@PathVariable Long id) {
        return cropService.getCropById(id);
    }

    @GetMapping("/land/{landId}")
    public List<Crop> getCropsByLandId(@PathVariable String landId) {
        return cropService.getCropsByLandId(landId);
    }

    @PostMapping
    public Crop createCrop(@RequestBody Crop crop) {
        return cropService.createCrop(crop);
    }

    @PutMapping("/{id}")
    public Crop updateCrop(@PathVariable Long id, @RequestBody Crop crop) {
        crop.setId(id);
        return cropService.updateCrop(crop);
    }

    @DeleteMapping("/{id}")
    public void deleteCrop(@PathVariable Long id) {
        cropService.deleteCrop(id);
    }
}
