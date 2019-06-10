package com.consulteer.facebook.service;

import com.consulteer.facebook.dto.RepliesDto;

public interface RepliesService {

    RepliesDto createReply(Long commentId, Long userId, RepliesDto replies);

    RepliesDto updateReply(Long replyId,RepliesDto replies);

    void deleteReply(Long replyId);

    Integer likeReply(Long replyId);

    Integer dislikeReply(Long replyId);

}
