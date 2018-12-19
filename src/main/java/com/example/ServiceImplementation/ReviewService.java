package com.example.ServiceImplementation;

import com.example.Entity.Review;
import com.example.Entity.Ticket;
import com.example.Repository.EventRepository;
import com.example.Repository.ReviewRepository;
import com.example.Repository.TicketRepository;
import com.example.Repository.UserRepository;
import com.example.ServiceInterface.ReviewInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewService implements ReviewInterface {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private TicketRepository ticketRepository;

    public Iterable<Review> findAll() {return reviewRepository.findAll();}


    public Optional<Review> findById(Long id) { return reviewRepository.findById(id);
    }

    @Override
    public void AddReview(Review rv,Long id)
    {
        Ticket ticket = ticketRepository.findById(id).get();
        if (ticket.isAttended()){
        rv.setTicketid(ticketRepository.findById(id).get());

        reviewRepository.save(rv);}
    }

    @Override
    public void deleteById(Long id) {
        Review dreview=reviewRepository.findById(id).get();
        dreview.setDeleted(true);
        reviewRepository.save(dreview);

    }

    @Override
    public void UpdateReview(Review urv) {
        reviewRepository.save(urv);
    }

}
