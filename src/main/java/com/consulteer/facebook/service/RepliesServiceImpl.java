package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.entity.Replies;
import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.repository.CommentRepository;
import com.consulteer.facebook.repository.RepliesRepository;
import com.consulteer.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class RepliesServiceImpl implements  RepliesService{
    @Autowired
    RepliesRepository repliesRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Replies createReply(Long commentId,Long userId,Replies replies) {
        Optional<Comment> optionalComment=commentRepository.findById(commentId);
        Optional <User> optionalUser=userRepository.findById(userId);
        if(optionalComment.isPresent() && optionalUser.isPresent()){
            Comment comment=commentRepository.getOne(commentId);
            User user=userRepository.getOne(userId);

            replies.setUser(user);
            replies.setComment(comment);
            replies.setTime(LocalDateTime.now());
            return repliesRepository.save(replies);

        }
        return null;
    }
}
