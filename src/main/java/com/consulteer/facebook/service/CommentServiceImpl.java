package com.consulteer.facebook.service;

import com.consulteer.facebook.dto.*;

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
    public CommentDto create(Long postId, Long userId, CommentDto input) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        Optional <User> optionalUser=userRepository.findById(userId);
        if (optionalPost.isPresent()&&optionalUser.isPresent()) {
            Post post =optionalPost.get();
            User user =optionalUser.get();
            input.setUser(BasicUserDto.convertToBasicDtoUser(user));
            input.setPosts(BasicPostDto.convertToBasicDtoPost(post));
            input.setTime(LocalDateTime.now());
            return CommentDto.convertToDtoComment(commentRepository.save(CommentDto.convertToEntityComment(input))) ;

        }
        return null;
    }

//    @Override
//    public void deleteComment(Long commentId) {
//        Optional <Comment> optionalComment=commentRepository.findById(commentId);
//        Comment found = optionalComment.get();
//        commentRepository.delete(found);
//
//    }
//
//    @Override
//    public Comment updateComment(Long id, Comment input) {
//        Optional<Comment> optionalComment=commentRepository.findById(id);
//        if(optionalComment.isPresent()){
//            Comment found=optionalComment.get();
//            found.setText(input.getText());
//
//            return commentRepository.save(found);
//        }
//        return null;
//    }
//
//    @Override
//    public int likeComment(long id) {
//        Optional <Comment> optionalComment=commentRepository.findById(id);
//        if(optionalComment.isPresent()){
//            Comment found=optionalComment.get();
//            int count=found.getCount();
//            count++;
//            found.setCount(count);
//            commentRepository.save(found);
//            return count;
//
//        }
//        return 0;
//    }


}
