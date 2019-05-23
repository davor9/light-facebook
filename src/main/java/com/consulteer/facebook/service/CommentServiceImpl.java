package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.repository.CommentRepository;
import com.consulteer.facebook.repository.PostRepository;
import com.consulteer.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Comment create(Long postId,Long userId, Comment input) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        Optional <User> optionalUser=userRepository.findById(userId);
        if (optionalPost.isPresent()&&optionalUser.isPresent()) {
            Post post = optionalPost.get();
            User user=optionalUser.get();
            input.setUser(user);
            input.setPost(post);
            input.setTime(LocalDateTime.now());
            return commentRepository.save(input);

        }
        return null;
    }
}
