package com.consulteer.facebook.controller;


import com.consulteer.facebook.entity.Replies;
import com.consulteer.facebook.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/replies")
public class RepliesController {
    @Autowired
    RepliesService repliesService;

    @PostMapping("comments/{commentId}/users/{userId}")
    public Replies createReply(@PathVariable("commentId") Long commentId, @PathVariable("userId")Long userId, @RequestBody Replies replies){
        return repliesService.createReply(commentId, userId, replies);
    }
}
