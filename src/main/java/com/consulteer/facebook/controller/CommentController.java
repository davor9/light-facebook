package com.consulteer.facebook.controller;


import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")

public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}/{userId}/comments")
    public Comment createComment(@PathVariable ("postId") Long postId,Long userId, @RequestBody Comment comment){
        return commentService.create(postId,userId,comment);
    }
}
