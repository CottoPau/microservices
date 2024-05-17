package com.demo.ticketapi.service;

import com.demo.ticketapi.model.FlightDto;
import com.demo.ticketapi.model.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    @Autowired
    FlightClient flightClient;

    private final List<Ticket> tickets= new ArrayList<>();

    public List<Ticket> getAllTickets(){
        return tickets;
    }

    //public Ticket addTicket(Ticket addedTicket){
    //  tickets.add(addedTicket);
    //return addedTicket;
    //}
    public Ticket saveTicket(Ticket addedTicket, Long flightId) {
        FlightDto flight = flightClient.getFlight(flightId);
        tickets.add(addedTicket);
        addedTicket.setFlight(flight);
        return addedTicket;


    }
    public Optional <Ticket> findTicketById(Long id) {
        Optional<Ticket> ticket1 = tickets.stream()
                .filter(ticket -> ticket.getId().equals(id))
                .findFirst();
        return ticket1;
    }

    public void deleteTicketById(Long id) {
        tickets.removeIf(ticket -> ticket.getId().equals(id));

    }

    public List<Ticket> updateTicket(Ticket updateTicket) {
        List<Ticket> tickets1 = tickets.stream()
                .map(ticket -> {
                    if (ticket.getId().equals(updateTicket.getId())) {
                        ticket.setFlight(updateTicket.getFlight());
                        ticket.setPassengerEmail((updateTicket.getPassengerEmail()));
                        ticket.setPassengerName(updateTicket.getPassengerName());
                        ticket.setPassengerPassport(updateTicket.getPassengerPassport());
                    }
                    return ticket;
                })
                .collect(Collectors.toList());
        return tickets1;


    }



}
