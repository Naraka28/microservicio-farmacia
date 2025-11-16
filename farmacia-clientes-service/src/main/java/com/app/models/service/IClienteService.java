package com.app.models.service;

import java.util.List;

import com.app.models.entity.Cliente;

public interface IClienteService {

    public List<Cliente> findAll();

    public Cliente findById(Long id);

    public Cliente create(Cliente cliente);
    
    public Cliente edit(Cliente cliente);
    
    public Cliente delete(Long id);
    
    public List<Cliente> findByName(String name);
    
    public List<Cliente> findByEdad(int edad);

}
