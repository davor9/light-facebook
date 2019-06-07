package com.consulteer.facebook.dto;


import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PostDto {
    private Long id;
    private String title = "Default";
    private String text;
    private int count;
    private LocalDateTime time;

    private BasicUserDto users = new BasicUserDto();

    private List<BasicCommentDto> comments = new ArrayList<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public BasicUserDto getUsers() {
        return users;
    }

    public void setUsers(BasicUserDto users) {
        this.users = users;
    }

    public List<BasicCommentDto> getComments() {
        return comments;
    }

    public void setComments(List<BasicCommentDto> comments) {
        this.comments = comments;
    }

    public static PostDto convertToDtoPost(Post post) {

        if (post != null) {
            PostDto postDto = new PostDto();
            postDto.setId(post.getId());
            postDto.setTitle(post.getTitle());
            postDto.setText(post.getText());
            postDto.setCount(post.getCount());
            postDto.setTime(post.getTime());

            if (post.getUsers() != null) {
                User t = post.getUsers();
                BasicUserDto d = BasicUserDto.convertToBasicDtoUser(t);
                postDto.setUsers(d);

            }

            if (post.getComments() != null) {
                List<BasicCommentDto> comments = post.getComments()
                        .stream()
                        .map(c-> BasicCommentDto.convertToBasicDtoComment(c))
                        .collect(Collectors.toList());
                   postDto.setComments(comments);
            }

            return postDto;
        }

        return null;
    }

    public static Post convertToEntityPost(PostDto postDto) {

        if (postDto != null) {
            Post post = new Post();
            post.setId(postDto.getId());
            post.setTitle(postDto.getTitle());
            post.setText(postDto.getText());
            post.setCount(postDto.getCount());
            post.setTime(postDto.getTime());

            if(postDto.getUsers() != null){
                BasicUserDto l = postDto.getUsers();
                User t = BasicUserDto.convertToEntityUser(l);
                post.setUsers(t);

            }
            if (postDto.getComments() != null) {
                List<Comment> comments = postDto.getComments()
                        .stream()
                        .map(c-> BasicCommentDto.convertToEntityComment(c))
                        .collect(Collectors.toList());
                post.setComments(comments);

            }



            return post;
        }
        return null;
    }
}
