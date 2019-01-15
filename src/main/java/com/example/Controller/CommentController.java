package com.example.Controller;


import com.example.Entity.Comment;
import com.example.Entity.Ticket;
import com.example.ServiceInterface.CommentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/api/Comments")
@RestController
public class CommentController {

    @Autowired
    public CommentInterface commentInterface;

    @RequestMapping (value = "/AllComments", method = RequestMethod.GET)
    public Iterable<Comment> getAllComments(){ return commentInterface.findAll(); }

    @RequestMapping(value = "/FindComments/{id}")
    public Optional<Comment> findByIdd(@PathVariable Long id){return commentInterface.findById(id);}

    @PostMapping (value = "/AddComment/{uid}/{eid}")
    public  void  AddComment (@RequestBody Comment comment , @PathVariable Long uid, @PathVariable Long eid){
        commentInterface.AddComment(comment,uid,eid);

    }
    @PutMapping(value = "/UpdateComment/{id}")
    public void UpdateComment (@RequestBody Comment ucmnt){commentInterface.UpdateComment(ucmnt);}

    @GetMapping (value = "/DeleteComment/{id}")
    public void CancelComment (@PathVariable long id){commentInterface.CancelComment(id);}

    @GetMapping (value = "/PostedComments")
    public List<Comment> findByDeletedFalse(){return  commentInterface.findByDeletedFalse();}

    @GetMapping (value = "/AttenderComments/{userid}")
    public List<Comment> findAllByAttenderid(@PathVariable long userid){return commentInterface.findAllByAttenderid(userid);}
}
