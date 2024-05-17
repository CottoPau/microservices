package com.demo.ticketapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Ticket {

    private Long id;
    private FlightDto flight;
    private String passengerName;
    private String passengerEmail;
    private String passengerPassport;


}
