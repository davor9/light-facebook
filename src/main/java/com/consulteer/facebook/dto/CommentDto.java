package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.Replies;
import com.consulteer.facebook.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentDto {

    private Long id;
    private String text;
    private int count;
    private LocalDateTime time;

    private BasicUserDto users = new BasicUserDto();

    private List<BasicRepliesDto> replies = new ArrayList<>(0);

    private BasicPostDto posts = new BasicPostDto();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public BasicUserDto getUser() {
        return users;
    }

    public void setUser(BasicUserDto users) {
        this.users = users;
    }

    public List<BasicRepliesDto> getReplies() {
        return replies;
    }

    public void setReplies(List<BasicRepliesDto> replies) {
        this.replies = replies;
    }

    public BasicPostDto getPosts() {
        return posts;
    }

    public void setPosts(BasicPostDto posts) {
        this.posts = posts;
    }

    public static  CommentDto convertToDtoComment(Comment comment){
        if(comment != null){
            CommentDto commentDto = new CommentDto();

            commentDto.setId(comment.getId());
            commentDto.setCount(comment.getCount());
            commentDto.setText(comment.getText());
            commentDto.setTime(comment.getTime());

            if(comment.getUser() != null){
                User t = comment.getUser();
                BasicUserDto d = BasicUserDto.convertToBasicDtoUser(t);
                commentDto.setUser(d);
            }

            if(comment.getReplies() != null){
               List<BasicRepliesDto> replies = comment.getReplies()
                       .stream()
                       .map(c-> BasicRepliesDto.convertToBasicDtoReplies(c))
                       .collect(Collectors.toList());
               commentDto.setReplies(replies);

            }

            if(comment.getPost() != null){
                Post p = comment.getPost();
                BasicPostDto r = BasicPostDto.convertToBasicDtoPost(p);
                commentDto.setPosts(r);

            }
            return commentDto;
        }

        return null;
    }

    public static Comment convertToEntityComment(CommentDto commentDto){
        if(commentDto != null){
            Comment comment = new Comment();

            comment.setCount(commentDto.getCount());
            comment.setText(commentDto.getText());
            comment.setId(commentDto.getId());
            comment.setTime(commentDto.getTime());

            if(commentDto.getUser() != null){
                BasicUserDto t = commentDto.getUser();
                User k = BasicUserDto.convertToEntityUser(t);
                comment.setUser(k);

            }

            if(commentDto.getReplies() != null){
                List<Replies> replies = commentDto.getReplies()
                        .stream()
                        .map(c-> BasicRepliesDto.convertToEntityReplies(c))
                        .collect(Collectors.toList());
                comment.setReplies(replies);
            }

            if(commentDto.getPosts() != null){
                BasicPostDto j = commentDto.getPosts();
                Post g = BasicPostDto.convertToEntityPost(j);
                comment.setPost(g);
            }
            return comment;
        }
        return null;

    }


}
