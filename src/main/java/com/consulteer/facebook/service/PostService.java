package com.consulteer.facebook.service;

import com.consulteer.facebook.dto.PostDto;

import com.consulteer.facebook.entity.Post;
import org.springframework.data.domain.Page;



public interface PostService {

    int likePost(PostDto post);

    int likePost(long postId,long userId);

    int dislikePost(long postId);

    PostDto create(Long userId, PostDto postDto);

    Page<Post> findAllPageable(Long userId, int page, int size, boolean sort);

    PostDto updatePost(long postId,PostDto post);

    void deletePost(long commentId);

}
