package com.example.ServiceInterface;

import com.example.Entity.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TicketInterface {

    Iterable<Ticket> findAll();
    Optional<Ticket> findById(Long id);
    void AddTicket(Ticket tckt,Long uid, Long eid);
    void CancelById(Long id);
    void UpdateTicket(Ticket utckt);
    List<Ticket> findByCancelledFalse();
     List<Ticket>findAllByattenderid(long id);


}
