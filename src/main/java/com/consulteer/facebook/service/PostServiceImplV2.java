package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImplV2 extends PostServiceImpl implements PostServiceV2 {

    @Autowired
    private PostRepository postRepository;

//    @Override
//    public Post createPost(Post post) {
//        System.out.println("Hello from v2");
//        return postRepository.save(post);
//    }

    @Override
    public Post update(Post post) {
        return null;
    }
}
