package com.example.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "Comment")
public class Comment {

    public Comment() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentid;

    private String comment;

    @ManyToOne
    @JoinColumn(name = "eventid")
    @JsonIgnore
    private Event eventid;

    @ManyToOne
    @JoinColumn(name = "attenderid")
    private Users attenderid;

    private LocalDateTime commentdate;

    @ColumnDefault("0")
    private boolean deleted;

    public Users getAttenderid() {
        return attenderid;
    }

    public void setAttenderid(Users attenderid) {
        this.attenderid = attenderid;
    }

    public long getCommentid() {
        return commentid;
    }

    public void setCommentid(long commentid) {
        this.commentid = commentid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Event getEventid() {
        return eventid;
    }

    public void setEventid(Event eventid) {
        this.eventid = eventid;
    }

    public LocalDateTime getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(LocalDateTime commentdate) {
        this.commentdate = commentdate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
