package com.example.Repository;

import com.example.Entity.Comment;
import com.example.Entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment,Long > {

    List<Comment> findByDeletedFalse();
    List<Comment> findAllByAttenderid(Users users);
}
