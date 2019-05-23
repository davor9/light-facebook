package com.consulteer.facebook.controller;

import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.service.PostService;
import com.consulteer.facebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @PostMapping
    public User create(@RequestBody User user){
        return userService.create(user);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<User> findOne(@PathVariable("userId") Long id){
        Optional<User> optionalUser = userService.findOne(id);
        if(optionalUser.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }

        return new ResponseEntity<>(optionalUser.get(),HttpStatus.OK);
    }

    @PostMapping("/{userId}/posts")
    public ResponseEntity<Post> addPost(@PathVariable("userId") Long userId, @RequestBody Post post){
        Post result = postService.create(userId, post);
        if(result != null){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/{userId}/posts")
    public ResponseEntity<Page<Post>> findAll(@PathVariable("userId") Long userId, @RequestParam("page") int page,
                                        @RequestParam("size") int size, @RequestParam("sort") boolean sort, @RequestParam("year") Long year){
        Page<Post> result = postService.findAllPageable(userId, page, size, sort);

        return ResponseEntity.ok(result);
    }

}
