package com.example.Entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table (name = "Review")
public class Review {
    public Review(){};


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long reviewid;

    private String reviewcomment;

    @ManyToOne
    @JoinColumn(name="ticketid")
    private Ticket ticketid;

    @ColumnDefault("0")
    private  boolean deleted;

    public long getReviewid() {
        return reviewid;
    }

    public void setReviewid(long reviewid) {
        this.reviewid = reviewid;
    }

    public String getReviewcomment() {
        return reviewcomment;
    }

    public void setReviewcomment(String reviewcomment) {
        this.reviewcomment = reviewcomment;
    }

    public Ticket getTicketid() {
        return ticketid;
    }

    public void setTicketid(Ticket ticketid) {
        this.ticketid = ticketid;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
