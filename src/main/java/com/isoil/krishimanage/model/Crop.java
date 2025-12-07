package com.isoil.krishimanage.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "crops")
public class Crop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "crop_type")
    private String cropType;
    
    @Column(name = "variety")
    private String variety;
    
    @Column(name = "quantity")
    private Double quantity;
    
    @Column(name = "season")
    private String season;
    
    @Column(name = "soil_type")
    private String soilType;
    
    @Column(name = "land_type")
    private String landType;
    
    @Column(name = "status")
    private String status;
    
    @Column(name = "production_date")
    private LocalDate productionDate;
    
    @Column(name = "notes", length = 1000)
    private String notes;
    
    @Column(name = "planting_date")
    private LocalDate plantingDate;
    
    @Column(name = "harvest_date")
    private LocalDate harvestDate;
    
    @Column(name = "land_id")
    private String landId;
    
    @Column(name = "crop_progress")
    private Double cropProgress;

    @Column(name = "crop_category")
    private String cropCategory;

    // Constructors
    public Crop() {}

    public Crop(String name, String cropType, String variety, Double quantity, 
                String season, String soilType, String landType, String status, 
                LocalDate productionDate, String notes, String cropCategory) {
        this.name = name;
        this.cropType = cropType;
        this.variety = variety;
        this.quantity = quantity;
        this.season = season;
        this.soilType = soilType;
        this.landType = landType;
        this.status = status;
        this.productionDate = productionDate;
        this.notes = notes;
        this.cropCategory = cropCategory;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCropType() { return cropType; }
    public void setCropType(String cropType) { this.cropType = cropType; }

    public String getVariety() { return variety; }
    public void setVariety(String variety) { this.variety = variety; }

    public Double getQuantity() { return quantity; }
    public void setQuantity(Double quantity) { this.quantity = quantity; }

    public String getSeason() { return season; }
    public void setSeason(String season) { this.season = season; }

    public String getSoilType() { return soilType; }
    public void setSoilType(String soilType) { this.soilType = soilType; }

    public String getLandType() { return landType; }
    public void setLandType(String landType) { this.landType = landType; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getProductionDate() { return productionDate; }
    public void setProductionDate(LocalDate productionDate) { this.productionDate = productionDate; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }

    public LocalDate getPlantingDate() { return plantingDate; }
    public void setPlantingDate(LocalDate plantingDate) { this.plantingDate = plantingDate; }

    public LocalDate getHarvestDate() { return harvestDate; }
    public void setHarvestDate(LocalDate harvestDate) { this.harvestDate = harvestDate; }

    public String getLandId() { return landId; }
    public void setLandId(String landId) { this.landId = landId; }

    public Double getCropProgress() { return cropProgress; }
    public void setCropProgress(Double cropProgress) { this.cropProgress = cropProgress; }

    public String getCropCategory() { return cropCategory; }
    public void setCropCategory(String cropCategory) { this.cropCategory = cropCategory; }
}
