package com.consulteer.facebook.service;

import com.consulteer.facebook.dto.CommentDto;
import com.consulteer.facebook.entity.Comment;

public interface CommentService {

    CommentDto create(Long postId, Long userId, CommentDto comment);

//    void deleteComment(Long commentId);
//
//    Comment updateComment(Long id,Comment input);
//
//    int likeComment(long id);
}
