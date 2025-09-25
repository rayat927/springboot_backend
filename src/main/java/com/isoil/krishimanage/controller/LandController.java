package com.isoil.krishimanage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.isoil.krishimanage.service.LandService;
import com.isoil.krishimanage.model.Land;
i

@RestController
@RequestMapping("/land")
public class LandController {
    LandService landService;

    public LandController(LandService landService) {
        this.landService = landService;
    }

    
}
