package com.app.models.service;

import java.util.List;

import com.app.models.entity.Producto;

public interface IProductoService {
    public List<Producto> findAll();
	public Producto findBy(Long id);

    public Producto create(Producto cliente);
    
    public Producto edit(Producto cliente);
    
    public Producto delete(Long id);
    
    public List<Producto> findByName(String name);
}
