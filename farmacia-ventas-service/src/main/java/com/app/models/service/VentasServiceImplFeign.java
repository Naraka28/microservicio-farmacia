package com.app.models.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Clientes;
import com.app.models.Productos;
import com.app.models.VentasResponse;
import com.app.models.dao.VentasDao;
import com.app.models.entity.Ventas;
import com.app.ventas.clientes.ClientesClienteRest;
import com.app.ventas.clientes.ProductosClienteRest;

@Service("serviceFeign")
public class VentasServiceImplFeign implements IVentasService{
    @Autowired
    private ClientesClienteRest clienteFeign;
    @Autowired
    private VentasDao ventasDao;
    @Autowired
    private ProductosClienteRest productosFeign;
    @Override
    public List<VentasResponse> findAll() {
        List<Ventas> ventas = (List<Ventas>) ventasDao.findAll();
        return mapVentasToResponse(ventas);
    }

    @Override
    public VentasResponse findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }
    @Override
    public VentasResponse create(Clientes cliente, Productos[] producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }
    @Override
    public List<VentasResponse> ventasHoy() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ventasHoy'");
    }
    @Override
    public Integer ventaCorte() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ventaCorte'");
    }
    @Override
    public Integer ventaProductoMasVendido() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ventaProductoMasVendido'");
    }

    private List<VentasResponse> mapVentasToResponse(List<Ventas> ventas){
        List<VentasResponse> response = new ArrayList<>();
        for (Ventas venta : ventas) {
            VentasResponse ventaResponse = new VentasResponse();
            ventaResponse.setId(venta.getId());

            Clientes cliente = clienteFeign.detalleCliente(venta.getIdCliente());
            ventaResponse.setCliente(cliente);

            List<Productos> productosList = new ArrayList<>();
            for (Long productoId : venta.getIdProductos()) {
                Productos producto = productosFeign.detalleProducto(productoId);
                productosList.add(producto);
            }
            ventaResponse.setProductos(productosList.toArray(new Productos[0]));
            ventaResponse.setFechaVenta(venta.getFechaVenta());
            ventaResponse.setHoraVenta(venta.getHoraVenta());
            ventaResponse.setTotal(productosList);
            response.add(ventaResponse);

        }
        return response;
    }




}
