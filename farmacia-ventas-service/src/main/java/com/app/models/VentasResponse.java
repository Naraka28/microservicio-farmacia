package com.app.models;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class VentasResponse {
    private Long id;
    private Clientes cliente;
    private Productos[] productos;
    private Date fechaVenta;
    private Time horaVenta;
    private Double total;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Time getHoraVenta() {
        return horaVenta;
    }

    public void setHoraVenta(Time horaVenta) {
        this.horaVenta = horaVenta;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(List<Productos> productos) {
        Double total = 0D;
        for (Productos producto : productos) {
            total += producto.getPrecio();
        }
        this.total = total;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Productos[] getProductos() {
        return productos;
    }

    public void setProductos(Productos[] productos) {
        this.productos = productos;
    }
}
