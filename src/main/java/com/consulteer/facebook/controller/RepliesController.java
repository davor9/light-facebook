package com.consulteer.facebook.controller;


import com.consulteer.facebook.dto.RepliesDto;

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
    public RepliesDto createReply(@PathVariable("commentId") Long commentId, @PathVariable("userId")Long userId, @RequestBody RepliesDto replies){
        return repliesService.createReply(commentId, userId, replies);
    }
}
