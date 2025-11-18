package com.app.ventas.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.app.models.Productos;

@FeignClient(name = "farmacia-productos-service")
public interface ProductosClienteRest {

    @GetMapping("/productos")
    public List<Productos> getAll();
    @GetMapping("/productos/{id}")
    public Productos detalleProducto(@PathVariable Long id);

}
