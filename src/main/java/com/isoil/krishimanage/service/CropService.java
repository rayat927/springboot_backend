package com.isoil.krishimanage.service;

import java.util.List;

import com.isoil.krishimanage.model.Crop;

public interface CropService {
    public Crop createCrop(Crop crop);
    public Crop updateCrop(Crop crop);
    public String deleteCrop(Long id);
    public Crop getCropById(Long id);
    public List<Crop> getAllCrops();
    public List<Crop> getCropsByLandId(String landId);
}
