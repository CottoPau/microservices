package com.demo.vuelosapi.utils;

import com.demo.vuelosapi.model.Dolar;
import com.demo.vuelosapi.model.Flight;
import com.demo.vuelosapi.model.FlightDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

@Component
public class FlightUtils {

    @Value("${dollar.card-url}")
    private String URL_DOLLAR_CARD;

    public List<Flight> detectOffers(List <Flight> flights, Integer offerPrice){
        List<Flight> offers= new ArrayList<>();
        for(Flight flight: flights){
            if(flight.getPrecio() <offerPrice){
                offers.add(flight);
            }
        }
        return offers;
    }

    /*public FlightDto flightMapper(Flight flight, double dolarPrice){
        return new FlightDto(flight.getId(),flight.getOrigen(),
                flight.getDestino(), flight.getFrecuencia(), flight.getFechaHoraSalida(),
                flight.getFechaHoraLlegada(), flight.getPrecio()*dolarPrice);
    }*/

    public List<FlightDto> flightMapper(List<Flight> flightList, double dolarPrice){
        List<FlightDto> flightDtos = new ArrayList<>();
        for(Flight flight : flightList){
            flightDtos.add(new FlightDto(flight.getId(), flight.getOrigen(), flight.getDestino(),
                    flight.getFechaHoraSalida(), flight.getFechaHoraLlegada(), flight.getFrecuencia(),
                    dolarPrice* flight.getPrecio()));
        }

        return flightDtos;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public Dolar fetchDolar(){
        RestTemplate restTemplate= restTemplate();
        return restTemplate.getForObject( URL_DOLLAR_CARD, Dolar.class);
    }

}
