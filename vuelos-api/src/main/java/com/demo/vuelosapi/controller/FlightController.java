package com.demo.vuelosapi.controller;

import com.demo.vuelosapi.model.Flight;
import com.demo.vuelosapi.model.FlightDto;
import com.demo.vuelosapi.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {


    @Autowired
    FlightService flightService;

    @CrossOrigin

    @GetMapping("")
    public List<FlightDto> getAllFlight(){
        return flightService.getAllFlight();
    }

    @GetMapping("/flight")
    public List<Flight> getALLFlights(){
        return flightService.getAllFlights();
    }


    @PostMapping("/add")
    public Flight createflight(@RequestBody Flight flight, @RequestParam Long companyId){
        return flightService.saveFlight(flight, companyId);
    }

    @GetMapping("/{id}")
    public Optional<Flight> findVuelo(@PathVariable Long id){
        return flightService.findFlightById(id);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlight(@PathVariable Long id){
        flightService.deleteFlightById(id);
    }


    @PutMapping("/update")
    public Flight updateFlight(@RequestBody Flight flight){
        flightService.updateFlight(flight);
        return flight;
    }



}
