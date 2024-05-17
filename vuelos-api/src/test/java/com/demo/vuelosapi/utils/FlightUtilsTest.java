package com.demo.vuelosapi.utils;


import static org.junit.jupiter.api.Assertions.*;

import com.demo.vuelosapi.model.Dolar;
import com.demo.vuelosapi.model.Flight;
import com.demo.vuelosapi.model.FlightDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class FlightUtilsTest {

    @Autowired
    FlightUtils flightUtils;

    /*@BeforeEach
    public  void setUp(){
        List<Flight> flightList;
        List<FlightDto> flightDtoList;*/



    @Test
    void flightMapper() {
        double dolarPrice = 1015;
        List<Flight> flightList= new ArrayList<>();
        List<FlightDto> flightDtoList = new ArrayList<>();

        Flight flight = new Flight();
        flight.setId(1L);
        flight.setOrigen("MDZ");
        flight.setDestino("AER");
        flight.setFrecuencia("3 veces");
        flight.setFechaHoraSalida("01-05-24");
        flight.setFechaHoraLlegada("02-05-24");
        flight.setPrecio(100.0);

        flightList.add(flight);

        flightDtoList= flightUtils.flightMapper(flightList, dolarPrice);

        FlightDto flightDto = flightDtoList.get(0);

        assertEquals(flight.getPrecio()*dolarPrice, flightDto.getConvertedPrice());

    }

    @Test
    void fetchDolarTest() {
        //Genero el contexto
        Dolar dummyDolar= new Dolar();

        FlightUtils mockedFlightUtilis = mock(FlightUtils.class);
        when(mockedFlightUtilis.fetchDolar()).thenReturn(dummyDolar);
        dummyDolar.setVenta(100.0);
        dummyDolar.setCompra(130.0);
        //faltan los demas seter

        //Llamo a funcionalidad
        Dolar dolar = mockedFlightUtilis.fetchDolar();

        //Verifico las salidas
        assertEquals(115, dolar.getPromedio());


    }
}