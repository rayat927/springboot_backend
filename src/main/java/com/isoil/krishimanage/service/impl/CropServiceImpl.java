package com.isoil.krishimanage.service.impl;

import org.springframework.stereotype.Service;
import com.isoil.krishimanage.model.Crop;
import com.isoil.krishimanage.service.CropService;
import com.isoil.krishimanage.repository.CropRepository;
import java.util.List;

@Service
public class CropServiceImpl implements CropService {
    private final CropRepository cropRepository;

    public CropServiceImpl(CropRepository cropRepository) {
        this.cropRepository = cropRepository;
    }

    @Override
    public List<Crop> getAllCrops() {
        return cropRepository.findAll();
    }

    @Override
    public Crop getCropById(Long id) {
        return cropRepository.findById(id).orElse(null);
    }

    @Override
    public Crop createCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public Crop updateCrop(Crop crop) {
        return cropRepository.save(crop);
    }

    @Override
    public String deleteCrop(Long id) {
        cropRepository.deleteById(id);
        return "Crop deleted successfully";
    }

    @Override
    public List<Crop> getCropsByLandId(String landId) {
        return cropRepository.findByLandId(landId);
    }
}
