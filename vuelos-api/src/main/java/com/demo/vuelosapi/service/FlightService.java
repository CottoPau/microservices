package com.demo.vuelosapi.service;

import com.demo.vuelosapi.exceptions.ResourceNotFoundExceptions;
import com.demo.vuelosapi.model.Company;
import com.demo.vuelosapi.model.Dolar;
import com.demo.vuelosapi.model.Flight;
import com.demo.vuelosapi.model.FlightDto;
import com.demo.vuelosapi.repository.CompanyRepository;
import com.demo.vuelosapi.repository.VueloRepository;
import com.demo.vuelosapi.utils.FlightUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private VueloRepository vueloRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private FlightUtils flightUtils;


    public List<Flight> getAllFlights(){return vueloRepository.findAll();}

    public List<FlightDto> getAllFlight(){
        List<Flight> flightList=vueloRepository.findAll();
        double dolarPrice = getDolar();
        return flightUtils.flightMapper(flightList,dolarPrice);
    }

    public Flight saveFlight(Flight flight, Long companyId) {
        Company company = companyRepository.findById(companyId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("flight", "id", companyId));
        flight.setCompany(company);
        return vueloRepository.save(flight);

    }
    public Optional<Flight> findFlightById(Long id) {
        return vueloRepository.findById(id);
    }

    public void deleteFlightById(Long id) {
        vueloRepository.deleteById(id);

    }

    public Optional<Flight> updateFlight(Flight flight) {
        vueloRepository.save(flight);
        return vueloRepository.findById(flight.getId());
    }

    public List<Flight> getOffers (Integer offerPrice){
        List<Flight> flights= vueloRepository.findAll();
        return flightUtils.detectOffers(flights,offerPrice);

        /*IMPLEMENTACION DE PROGRAMACION FUNCIONAL
        return fligths.stream()
        .filter(flight-> fligth.getPrice()< offerPrice)
        .collect(Collectors.toList());
         */
    }


    private double getDolar() {
        Dolar dolar= flightUtils.fetchDolar();
        return dolar.getPromedio();
    }
}
