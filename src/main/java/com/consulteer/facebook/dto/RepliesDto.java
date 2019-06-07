package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.entity.Replies;
import com.consulteer.facebook.entity.User;

import java.time.LocalDateTime;

public class RepliesDto {

    private Long id;
    private LocalDateTime time;
    private int count;
    private String text;

    private BasicUserDto users;
    private BasicCommentDto comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public BasicUserDto getUsers() {
        return users;
    }

    public void setUsers(BasicUserDto users) {
        this.users = users;
    }

    public BasicCommentDto getComments() {
        return comments;
    }

    public void setComments(BasicCommentDto comments) {
        this.comments = comments;
    }

    public static RepliesDto convertToDtoReplies(Replies replies){
        if(replies != null){

            RepliesDto repliesDto = new RepliesDto();

            repliesDto.setTime(replies.getTime());
            repliesDto.setCount(replies.getCount());
            repliesDto.setId(repliesDto.getId());
            repliesDto.setText(replies.getText());

            if(replies.getComment() != null){
                Comment c = replies.getComment();
                BasicCommentDto k = BasicCommentDto.convertToBasicDtoComment(c);
                repliesDto.setComments(k);

            }
            if(replies.getUser() != null){
                User j = replies.getUser();
                BasicUserDto u = BasicUserDto.convertToBasicDtoUser(j);
                repliesDto.setUsers(u);
            }

            return repliesDto;
        }

        return null;
    }

    public static Replies convertToEntityReplies(RepliesDto repliesDto){
        if(repliesDto != null){

            Replies replies = new Replies();

            replies.setText(repliesDto.getText());
            replies.setId(repliesDto.getId());
            replies.setTime(repliesDto.getTime());
            replies.setCount(replies.getCount());

            if(repliesDto.getComments() != null){
                BasicCommentDto t= repliesDto.getComments();
                Comment l = BasicCommentDto.convertToEntityComment(t);
                replies.setComment(l);
            }

            if(repliesDto.getUsers() != null){
                BasicUserDto f = repliesDto.getUsers();
                User w = BasicUserDto.convertToEntityUser(f);
                replies.setUser(w);
            }
            return replies;
        }
        return null;
    }
}
