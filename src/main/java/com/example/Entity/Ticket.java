package com.example.Entity;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "Ticket")
public class Ticket {

    public Ticket(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ticketid;


    @ManyToOne
    @JoinColumn(name = "eventid")
    private Event eventid;

    @ManyToOne
    @JoinColumn(name = "attenderid")
    private Users attenderid;

    @ColumnDefault(value = "0")
    private  boolean cancelled ;

    @ColumnDefault(value = "0")
    private boolean attended;

    public long getTicketid() {
        return ticketid;
    }

    public void setTicketid(long ticketid) {
        this.ticketid = ticketid;
    }

    public Event getEventid() {
        return eventid;
    }

    public void setEventid(Event eventid) {
        this.eventid = eventid;
    }

    public Users getAttenderid() {
        return attenderid;
    }

    public void setAttenderid(Users attenderid) {
        this.attenderid = attenderid;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}

