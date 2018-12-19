package com.example.ServiceImplementation;

import com.example.Entity.Event;
import com.example.Entity.Ticket;
import com.example.Entity.Users;
import com.example.Repository.EventRepository;
import com.example.Repository.TicketRepository;
import com.example.Repository.UserRepository;
import com.example.ServiceInterface.TicketInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService implements TicketInterface {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  EventRepository eventRepository;

    public Iterable<Ticket> findAll() { return  ticketRepository.findAll(); }

    public Optional<Ticket> findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public void AddTicket(Ticket tckt,Long uid , Long eid ) {


        Users users= userRepository.findById(uid).get();
        Event event =eventRepository.findById(eid).get();
        event.setEventcapacity(event.getEventcapacity());

        LocalDate d = LocalDate.now().minusDays(1);

        if (event.getEcounter() < event.getEventcapacity() && event.isApproved() && d.isBefore(event.getEventdate()))
             {

            tckt.setAttenderid(userRepository.findById(uid).get());
            tckt.setEventid(eventRepository.findById(eid).get());
            event.setEcounter(1+event.getEcounter());
        ticketRepository.save(tckt);}
    }

    @Override
    public void CancelById(Long id) {
       ticketRepository.findById(id).get().setCancelled(true);
       Event event= ticketRepository.findById(id).get().getEventid();
       event.setEcounter(event.getEcounter()-1);
       ticketRepository.save(findById(id).get());

    }


    @Override
    public void UpdateTicket(Ticket utckt) {
        ticketRepository.save(utckt);
    }

    @Override
    public List<Ticket> findByCancelledFalse() {

       return ticketRepository.findByCancelledFalse();


    }

    @Override
    public List<Ticket> findAllByattenderid(long userid) {
         return ticketRepository.findAllByAttenderid(userRepository.findById(userid).get());
    }


}

