package com.demo.vuelosapi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String origen;
    private String destino;
    private String fechaHoraSalida;
    private String fechaHoraLlegada;
    private Double precio;
    private String frecuencia;

    public Flight(String origen, String destino, String fechaHoraSalida, String fechaHoraLlegada, Double precio, String frecuencia) {
        this.origen = origen;
        this.destino = destino;
        this.fechaHoraSalida = fechaHoraSalida;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.precio = precio;
        this.frecuencia = frecuencia;
    }
    @ManyToOne
    @JoinColumn(name="company-id")
    private Company company;
}
