package com.consulteer.facebook.controller;


import com.consulteer.facebook.dto.RepliesDto;

import com.consulteer.facebook.service.RepliesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/{replyId}")
    public RepliesDto updateReply(@PathVariable("replyId") Long replyId,@RequestBody RepliesDto repliesDto){
        return repliesService.updateReply(replyId,repliesDto);
    }

    @DeleteMapping("/{replyId}")
    public ResponseEntity<RepliesDto> deleteReply(@PathVariable("replyId") Long replyId){
        repliesService.deleteReply(replyId);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PostMapping("/{replyId}")
    public Integer likeReply(@PathVariable("replyId") Long replyId){
        return repliesService.likeReply(replyId);
    }

    @PutMapping("/{replyId}/dislike")
    public Integer dislikeReply(@PathVariable("replyId") Long replyId){return repliesService.dislikeReply(replyId);}

}
