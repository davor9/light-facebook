package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.Post;


import java.time.LocalDateTime;


public class BasicPostDto {
    private Long id;
    private String title = "Default";
    private String text;
    private int count;
    private LocalDateTime time;

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

    public static BasicPostDto convertToBasicDtoPost(Post post) {

        if (post != null) {
            BasicPostDto basicPostDto = new BasicPostDto();
            basicPostDto.setId(post.getId());
            basicPostDto.setTitle(post.getTitle());
            basicPostDto.setText(post.getText());
            basicPostDto.setCount(post.getCount());
            basicPostDto.setTime(post.getTime());

            return basicPostDto;
        }

        return null;
    }

    public static Post convertToEntityPost(BasicPostDto basicPostDto) {

        if (basicPostDto.getId() != null) {
            Post post = new Post();
            post.setId(basicPostDto.getId());
            post.setTitle(basicPostDto.getTitle());
            post.setText(basicPostDto.getText());
            post.setCount(basicPostDto.getCount());
            post.setTime(basicPostDto.getTime());


            return post;
        }
        return null;
    }
}
