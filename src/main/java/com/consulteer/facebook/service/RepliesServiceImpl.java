package com.consulteer.facebook.service;

import com.consulteer.facebook.dto.*;
import com.consulteer.facebook.entity.Comment;

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
    public RepliesDto createReply(Long commentId, Long userId, RepliesDto replies) {
        Optional<Comment> optionalComment=commentRepository.findById(commentId);
        Optional <User> optionalUser = userRepository.findById(userId);
        if(optionalComment.isPresent() && optionalUser.isPresent()){
            BasicCommentDto comment = BasicCommentDto.convertToBasicDtoComment(commentRepository.getOne(commentId));
            BasicUserDto user = BasicUserDto.convertToBasicDtoUser(userRepository.getOne(userId)) ;

            replies.setUsers(user);
            replies.setComments(comment);
            replies.setTime(LocalDateTime.now());
            return RepliesDto.convertToDtoReplies(repliesRepository.save(RepliesDto.convertToEntityReplies(replies)));

        }
        return null;
    }
}
