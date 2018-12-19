package com.example.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Event")
public class Event {

    public Event(){}

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long eventid;

    @Size(min=2, max=40 /*message="Name should have atleast 2 characters"*/)
    private String eventname;


    private LocalDate eventdate;

    private long eventcapacity;

    @ManyToOne(/*cascade = CascadeType.ALL*/)
    @JoinColumn(name = "organizerid")
    private Users organizerid;

    @OneToMany(mappedBy = "eventid")
    private List<Comment> comment;

    private String eventcity;

    @ColumnDefault("0")
    private long ecounter;

    @ColumnDefault(value = "0")
    private  boolean deleted;

    @ColumnDefault(value = "0")
    private boolean approved;

    public long getEventid() {
        return eventid;
    }

    public void setEventid(long eventid) {
        this.eventid = eventid;
    }

    public LocalDate getEventdate() {
        return eventdate;
    }

    public void setEventdate(LocalDate eventdate) {
        this.eventdate = eventdate;
    }

    public long getEventcapacity() {
        return eventcapacity;
    }

    public void setEventcapacity(long eventcapacity) {
        this.eventcapacity = eventcapacity;
    }

    public Users getOrganizerid() {
        return organizerid;
    }

    public void setOrganizerid(Users organizerid) {
        this.organizerid = organizerid;
    }

    public String getEventcity() {
        return eventcity;
    }

    public void setEventcity(String eventcity) {
        this.eventcity = eventcity;
    }

    public long getEcounter() {
        return ecounter;
    }

    public void setEcounter(long ecounter) {
        this.ecounter = ecounter;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public String getEventname() { return eventname; }

    public void setEventname(String eventname) { this.eventname = eventname; }

    public List<Comment> getComment() {
        return comment;
    }

    public void setComment(List<Comment> comment) {
        this.comment = comment;
    }
}
