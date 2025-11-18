package com.app.models.service;

import java.util.List;

import com.app.models.Clientes;
import com.app.models.Productos;
import com.app.models.VentasResponse;

public interface IVentasService {

    public List<VentasResponse> findAll();

    public VentasResponse findById(Long id);

    public VentasResponse create(Clientes cliente, Productos[] producto);

    public List<VentasResponse> ventasHoy();

    public Integer ventaCorte();

    public Integer ventaProductoMasVendido();



}
