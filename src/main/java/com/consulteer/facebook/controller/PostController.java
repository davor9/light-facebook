package com.consulteer.facebook.controller;


import com.consulteer.facebook.dto.PostDto;
import com.consulteer.facebook.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @PutMapping("/{postId}/users/{userId}/like")
    public Integer likePost(@PathVariable("postId") Long postId,@PathVariable("userId") long userId){
        return postService.likePost(postId,userId);
    }

    @PutMapping("/{id}")
    public PostDto updatePost(@PathVariable("id") Long id, @RequestBody PostDto post) {
        return postService.updatePost(id,post);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PostDto> deletePost(@PathVariable("id") Long id){
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.GONE);
    }

    @PutMapping("/{postId}/dislike")

    public Integer dislikePost(@PathVariable("postId") Long postId){return postService.dislikePost(postId);}
}
