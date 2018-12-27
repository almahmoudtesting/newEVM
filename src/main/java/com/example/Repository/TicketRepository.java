package com.example.Repository;

import com.example.Entity.Ticket;
import com.example.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TicketRepository extends JpaRepository<Ticket,Long> {

List<Ticket> findByCancelledFalse();
// List<Ticket> findAllByAttenderid(Users users);
 List<Ticket> findByAttenderidUserid(Long id);

}
