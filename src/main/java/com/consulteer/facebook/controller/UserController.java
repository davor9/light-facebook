package com.consulteer.facebook.controller;

import com.consulteer.facebook.dto.PostDto;
import com.consulteer.facebook.dto.UserDto;

import com.consulteer.facebook.service.PostService;
import com.consulteer.facebook.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @PostMapping
    public UserDto create(@RequestBody UserDto userDto){
        return userService.create(userDto);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<UserDto> findOne(@PathVariable("userId") Long id){
        UserDto optionalUser = userService.findOne(id);
        if(optionalUser == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }

        return new ResponseEntity<>(optionalUser,HttpStatus.OK);
    }

    @PostMapping("/{userId}/posts")
    public ResponseEntity<PostDto> addPost(@PathVariable("userId") Long userId, @RequestBody PostDto post){
        PostDto result = postService.create(userId, post);
        if(result != null){
            return ResponseEntity.ok(result);
        }
        return ResponseEntity.badRequest().build();
    }

//    @GetMapping("/{userId}/posts")
//    public ResponseEntity<Page<PostDto>> findAll(@PathVariable("userId") Long userId, @RequestParam("page") int page,
//                                        @RequestParam("size") int size, @RequestParam("sort") boolean sort, @RequestParam("year") Long year){
//        Page<PostDto> result = postService.findAllPageable(userId, page, size, sort);
//
//        return ResponseEntity.ok(result);
//    }

}
