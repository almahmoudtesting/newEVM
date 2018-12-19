package com.example.ServiceInterface;

import com.example.Entity.Comment;
import com.example.Entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CommentInterface {

    Iterable<Comment> findAll();
    Optional<Comment> findById(Long id);
    void AddComment(Comment cmnt,Long uid,Long eid);
    void CancelComment(Long id);
    void UpdateComment( Comment ucmnt);
    List<Comment> findByDeletedFalse();
    List<Comment> findAllByAttenderid(long userid);

}
