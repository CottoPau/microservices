package com.demo.ticketapi.service;
import com.demo.ticketapi.model.FlightDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@FeignClient(name = "flight-service")
public interface FlightClient {

    @GetMapping("/flights")
    List<FlightDto> getAllFlights();

    @GetMapping("/flights/{id}")
    FlightDto getFlight(@PathVariable ("id") Long id);



}
