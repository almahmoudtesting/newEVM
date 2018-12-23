package com.example.Controller;

import com.example.Entity.Ticket;
import com.example.ServiceImplementation.TicketService;
import com.example.ServiceInterface.TicketInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping (value = "/api/Tickets")
@RestController
public class TicketController {

    @Autowired
    public TicketInterface ticketInterface;

    @RequestMapping (value = "/AllTickets", method = RequestMethod.GET)
    public Iterable<Ticket> getAllTickets(){ return ticketInterface.findAll(); }

    @RequestMapping(value = "/FindTickets/{id}")
    public Optional<Ticket> findByIdd(@PathVariable Long id){return ticketInterface.findById(id);}

    @GetMapping (value = "/AddTickets/{uid}/{eid}")
    public void AddTicket(@PathVariable Long uid,@PathVariable Long eid){
        ticketInterface.AddTicket(uid,eid);
    }

    @PutMapping (value = "/UpdateTicket")
    public void UpdateTicket(@RequestBody Ticket utckt){ticketInterface.UpdateTicket(utckt);}

    @PutMapping (value = "/CancelTicket/{id}")
    public void CancelById(@PathVariable Long id){ticketInterface.CancelById(id);}

    @GetMapping (value = "/BookedTickets")
    public List<Ticket> findByCancelledFalse(){return  ticketInterface.findByCancelledFalse();}

    @GetMapping (value = "/AttenderTickets/{userid}")
    public List<Ticket> findAllByAttenderid(@PathVariable long userid){return ticketInterface.findAllByattenderid(userid);}

}
