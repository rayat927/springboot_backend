package com.isoil.krishimanage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isoil.krishimanage.model.Crop;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {
    List<Crop> findByLandId(String landId);
    List<Crop> findByCropType(String cropType);
    List<Crop> findBySeason(String season);
}   

