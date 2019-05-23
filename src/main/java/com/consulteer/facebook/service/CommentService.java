package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.Comment;

public interface CommentService {

    Comment create(Long postId,Long userId,Comment comment);

    void deleteComment(Long commentId);

    Comment updateComment(Long id,Comment input);

    int likeComment(long id);
}
