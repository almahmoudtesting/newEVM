package com.example.ServiceInterface;

import com.example.Entity.Review;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ReviewInterface {

    Iterable<Review> findAll();
    Optional<Review> findById(Long id);
    void AddReview(Review rv,Long id);
    void deleteById(Long id);
    void UpdateReview(Review urv);
}
