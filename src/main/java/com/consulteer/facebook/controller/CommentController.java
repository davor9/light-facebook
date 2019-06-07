package com.consulteer.facebook.controller;


import com.consulteer.facebook.dto.CommentDto;

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

    @PostMapping("/posts/{postId}/users/{userId}")
    public CommentDto createComment(@PathVariable ("postId") Long postId, @PathVariable("userId") Long userId, @RequestBody CommentDto comment){
        return commentService.create(postId,userId,comment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommentDto> deleteComment(@PathVariable("id") Long id){
        commentService.deleteComment(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public CommentDto updateComment (@PathVariable("id") Long id,@RequestBody CommentDto input){
        return commentService.updateComment(id,input);

    }

    @PostMapping("/{id}")
    public int likeComment(@PathVariable("id") long id){
        return commentService.likeComment(id);
    }
}
