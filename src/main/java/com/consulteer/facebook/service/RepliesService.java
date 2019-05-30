package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.Replies;

public interface RepliesService {

    Replies createReply(Long commentId,Long userId,Replies replies);

}
