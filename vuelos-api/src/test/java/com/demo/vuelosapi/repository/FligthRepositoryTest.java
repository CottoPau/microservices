package com.demo.vuelosapi.repository;

import com.demo.vuelosapi.model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FligthRepositoryTest {


    @Autowired
    private VueloRepository vueloRepository;

    private Flight flight;

    @BeforeEach
    void setUp(){
        flight = new Flight("GIG","EZE","08.00","11.00", 200.00,"diario");
    }

    @Test
    void saveFligthTest(){
        //configuracion previa en el set up
        //Llamar a la funcionalidad
        Flight flightBD = vueloRepository.save(flight);
        //verificar salida o comportamiento
        assertThat(flightBD).isNotNull();
        assertThat(flightBD.getId()).isGreaterThan(0);
    }

    @Test
    void findFlightById(){
        vueloRepository.save(flight);
        Flight flightBD = vueloRepository.findById(flight.getId()).get();
        assertThat(flightBD).isNotNull();
    }

    @Test
    void flightFindAllTest(){

        Flight flight2 = new Flight("ROM","AER","10.00","11.00", 200.00,"diario");
        vueloRepository.save(flight);
        vueloRepository.save(flight2);

        List<Flight> flightListPrueba = vueloRepository.findAll();
        assertThat(flightListPrueba).isNotNull();
        assertThat(flightListPrueba.size()).isEqualTo(2);
    }

    @Test
    void fligthDeleteById(){
        vueloRepository.save(flight);
        vueloRepository.deleteById(flight.getId());
        Optional<Flight> deleteFligth = vueloRepository.findById(flight.getId());
        assertThat(deleteFligth).isEmpty();
    }

    @Test
    void flightUpdate(){
        vueloRepository.save(flight);
        Flight flightBD = vueloRepository.findById(flight.getId()).get();

        flightBD.setOrigen("BCN");
        flightBD.setDestino("LHR");

        Flight updateFligth = vueloRepository.save(flightBD);
        assertThat(updateFligth.getOrigen()).isEqualTo("BCN");
        assertThat(updateFligth.getDestino()).isEqualTo("LHR");


    }


}