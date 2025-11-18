package com.app.ventas.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.models.Clientes;

@FeignClient(name = "farmacia-clientes-service")
public interface ClientesClienteRest {
    @GetMapping("/clientes")
    public List<Clientes> getAll();
    @GetMapping("/clientes/{id}")
    public Clientes detalleCliente(Long id);


}
