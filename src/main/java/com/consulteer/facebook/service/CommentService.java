package com.consulteer.facebook.service;

import com.consulteer.facebook.dto.CommentDto;


public interface CommentService {

    CommentDto create(Long postId, Long userId, CommentDto comment);

    void deleteComment(Long commentId);

    CommentDto updateComment(Long id,CommentDto input);

    int likeComment(long id);
}
