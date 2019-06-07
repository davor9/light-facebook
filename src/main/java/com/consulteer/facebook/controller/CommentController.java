package com.consulteer.facebook.controller;


import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

//    @PostMapping("/posts/{postId}/users/{userId}")
//    public Comment createComment(@PathVariable ("postId") Long postId,@PathVariable("userId") Long userId, @RequestBody Comment comment){
//        return commentService.create(postId,userId,comment);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Comment> deleteComment(@PathVariable("id") Long id){
//        commentService.deleteComment(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @PutMapping("/{id}")
//    public Comment updateComment (@PathVariable("id") Long id,@RequestBody Comment input){
//        return commentService.updateComment(id,input);
//
//    }
//
//    @PostMapping("/{id}")
//    public int likeComment(@PathVariable("id") long id){
//        return commentService.likeComment(id);
//    }
}
