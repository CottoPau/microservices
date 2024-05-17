package com.demo.ticketapi.controller;

import com.demo.ticketapi.model.FlightDto;
import com.demo.ticketapi.model.Ticket;
import com.demo.ticketapi.service.FlightClient;
import com.demo.ticketapi.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    @Autowired
    private FlightClient flightClient;

    @GetMapping("")
    public List<Ticket> getAllTickets(){
        return ticketService.getAllTickets();
    }

    @GetMapping("/flights")
    public List<FlightDto> getAllFlights(){
        return flightClient.getAllFlights();
    }

    // @PostMapping("/add")
    //public Ticket addTickets(@RequestBody Ticket ticket){
    //   return ticketService.addTicket(ticket);
    //}

    @PostMapping("/add")
    public Ticket createTicket(@RequestBody Ticket ticket, @RequestParam Long flightId){
        return ticketService.saveTicket(ticket, flightId);
    }

    @GetMapping("/{id}")
    public Optional<Ticket> findTicketById(@PathVariable Long id){
        return ticketService.findTicketById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTicket(@PathVariable Long id){
        ticketService.deleteTicketById(id);
    }

    @PutMapping("/update")
    public Ticket updateTicket(@RequestBody Ticket ticket){
        ticketService.updateTicket(ticket);
        return ticket;
    }



}
