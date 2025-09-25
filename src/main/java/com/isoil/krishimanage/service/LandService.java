package com.isoil.krishimanage.service;

import com.isoil.krishimanage.model.Land;

public interface LandService {
    public String createLand(Land land);
    public String updateLand(Land land);
    public String deleteLand(Long id);
    public Land getLandById(Long id);
    public Land[] getAllLands();
}
