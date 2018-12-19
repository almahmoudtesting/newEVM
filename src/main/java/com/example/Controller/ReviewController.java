package com.example.Controller;

import com.example.Entity.Review;
import com.example.ServiceImplementation.ReviewService;
import com.example.ServiceInterface.ReviewInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RequestMapping(value = "/api/Reviews")
@RestController
public class ReviewController {

    @Autowired
    public ReviewInterface reviewInterface;

    @RequestMapping(value = "/AllReviews", method = RequestMethod.GET)
    public Iterable<Review> getAllReviews(){ return reviewInterface.findAll(); }

    @RequestMapping(value = "/FindReviews/{id}")
    public Optional<Review> findByIdd(@PathVariable Long id){return reviewInterface.findById(id);}

    @PostMapping (value = "/AddReviews/{id}")
    public void AddReview( @RequestBody Review rv, @PathVariable Long id){
        reviewInterface.AddReview(rv,id);
    }

    @PutMapping(value = "/UpdateReviews")
    public void UpdateReview (@RequestBody Review urv){reviewInterface.UpdateReview(urv);}

    @PutMapping (value = "/DeleteReview/{id}")
    public void DeleteReview (@PathVariable Long id){reviewInterface.deleteById(id);}
}
