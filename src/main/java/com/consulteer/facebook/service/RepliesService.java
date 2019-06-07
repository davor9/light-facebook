package com.consulteer.facebook.service;

import com.consulteer.facebook.dto.RepliesDto;

public interface RepliesService {

    RepliesDto createReply(Long commentId, Long userId, RepliesDto replies);

}
