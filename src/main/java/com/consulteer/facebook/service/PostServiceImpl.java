package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.repository.PostRepository;
import com.consulteer.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Primary
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

//    @Override
//    public Post createPost(Post post) {
//        post.setTime(LocalDateTime.now());
//        return postRepository.save(post);
//    }

    @Override
    public int likePost(Post post) {
        int count = post.getCount();
        count++;
        post.setCount(count);
        postRepository.save(post);
        return count;
    }

    @Override
    public int likePost(long postId) {
        Post post = postRepository.getOne(postId);
        if (post != null) {
            return likePost(post);
        }
        return 0;
    }

    @Override
    public Post create(Long userId, Post post) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            post.setUser(user);
            post.setTime(LocalDateTime.now());
            return postRepository.save(post);
        }
        return null;
    }

    @Override
    public Page<Post> findAllPageable(Long userId, int page, int size, boolean sort) {
        Optional<User> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            if (sort) {
                return postRepository.findAllByUserSorted(optionalUser.get(), PageRequest.of(page, size));
            }

            return postRepository.findAllByUser(optionalUser.get(), PageRequest.of(page, size));
        }
        return new PageImpl<>(Collections.emptyList());
    }

    @Override
    public Post updatePost(long postId, Post post) {
        Post found = postRepository.getOne(postId);
        if (found != null) {
            found.setText(post.getText());
            found.setTitle(post.getTitle());

            return postRepository.save(found);

        }
        return null;

    }

    @Override
    public void deletePost(long postId) {
        Post found= postRepository.getOne(postId);
        postRepository.delete(found);

    }

//    @Override
//    public List<Post> findAllByUser(Long userId) {
//        User user = userRepository.getOne(userId);
//        if(user != null) {
//            return postRepository.findAllByUser(user);
//        }
//
//        return null;
//    }

//    @Override
//    public Post updatePost(Post post) {
//        return null;
//    }
}
