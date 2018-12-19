package com.example.ServiceImplementation;

import com.example.Entity.Comment;
import com.example.Entity.Event;
import com.example.Entity.Users;
import com.example.Repository.CommentRepository;
import com.example.Repository.EventRepository;
import com.example.Repository.UserRepository;
import com.example.ServiceInterface.CommentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService implements CommentInterface {

   @Autowired
   private EventRepository eventRepository;
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private CommentRepository commentRepository;

    @Override
    public Iterable<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Optional<Comment> findById(Long id) {
        return commentRepository.findById(id) ;
    }

    @Override
    public void AddComment(Comment cmnt, Long uid, Long eid) {
        Users users= userRepository.findById(uid).get();
        Event event =eventRepository.findById(eid).get();
        LocalDateTime dateTime = LocalDateTime.now().minusMinutes(1);

        //if (dateTime.isAfter(cmnt.getCommentdate())) {
            cmnt.setAttenderid(userRepository.findById(uid).get());
            cmnt.setEventid(eventRepository.findById(eid).get());
            cmnt.setCommentdate(LocalDateTime.now());
            event.getComment().add(cmnt);
            commentRepository.save(cmnt);
        //}
    }

    @Override
    public void CancelComment(Long id) {
        Comment dcomment=commentRepository.findById(id).get();
        dcomment.setDeleted(true);
        commentRepository.save(dcomment);

    }

    @Override
    public void UpdateComment(Comment ucmnt) { commentRepository.save(ucmnt);
    }

    @Override
    public List<Comment> findByDeletedFalse() {
        return commentRepository.findByDeletedFalse();
    }

    @Override
    public List<Comment> findAllByAttenderid(long userid) {
        return commentRepository.findAllByAttenderid(userRepository.findById(userid).get());
    }
}
