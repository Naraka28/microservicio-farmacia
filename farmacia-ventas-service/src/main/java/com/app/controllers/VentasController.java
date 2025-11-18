package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.VentasResponse;
import com.app.models.service.IVentasService;

@RestController
public class VentasController {

    @Autowired
    @Qualifier("serviceFeign")
    private IVentasService ventaService;

    @GetMapping("/ventas")
    public List<VentasResponse> findAll(){
        return ventaService.findAll();
    }
}
