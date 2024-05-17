package com.demo.vuelosapi.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data

public class Dolar {

    private String moneda;
    private String casa;
    private String nombre;
    private Double compra;
    private Double venta;
    private LocalDateTime fechaActualizacion;

    public Double getPromedio() {
        return (getCompra()+getVenta()/2);
    }
}
