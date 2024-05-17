package com.demo.vuelosapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FlightDto {

    private Long id;
    private String origen;
    private String destino;
    private String fechaHoraSalida;
    private String fechaHoraLlegada;
    private String frecuencia;
    private Double convertedPrice;


}
