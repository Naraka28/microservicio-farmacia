package com.app.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.entity.Producto;
import com.app.models.service.IProductoService;

@RestController
public class ProductoController {
	
	@Autowired
	private Environment env;
	
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/productos")
	public List<Producto> getAll(@RequestParam(required = false) String nombre){
    if (nombre != null && !nombre.isEmpty()) {
        return productoService.findByName(nombre);
    }
    return productoService.findAll().stream().map(producto-> {
    	producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return producto;
	}).collect(Collectors.toList());
	}
	
	@GetMapping("/productos/{id}")
	public Producto detalleProducto(@PathVariable Long id) {
		Producto producto = productoService.findBy(id);
		producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return producto;
	}

    @PostMapping("/productos")
    public Producto crearCliente(@RequestBody Producto producto) {
        return productoService.create(producto);
    }
    @PutMapping("/productos")
    public Producto ediCliente(@RequestBody Producto producto) {
    	return productoService.edit(producto);
    }
    @DeleteMapping("/productos/{id}")
    public Producto delete(@PathVariable Long id) {
    	return productoService.delete(id);   
    	}
	
	
	
	
	

}
