package com.demo.vuelosapi.model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class FlightTest {

    private static Flight flight;

    @Test

    public void setAndGetOriginTest() {
        String testedOrigin = "COR";
        flight.setOrigen(testedOrigin);
        System.out.println("Se le asigna el siguiente origen:" + testedOrigin);
        Assertions.assertEquals(flight.getOrigen(), testedOrigin);
    }

    @BeforeAll
    public static void setUp() {
        System.out.println("Se crea un vuelo");
        flight = new Flight();
    }
}