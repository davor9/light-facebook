package com.consulteer.facebook.dto;


import com.consulteer.facebook.entity.Comment;


import java.time.LocalDateTime;

public class BasicCommentDto {
    private Long id;
    private String text;
    private int count;
    private LocalDateTime time;

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

    public static BasicCommentDto convertToBasicDtoComment(Comment comment) {

        if (comment != null) {
            BasicCommentDto basicCommentDto = new BasicCommentDto();
            basicCommentDto.setCount(comment.getCount());
            basicCommentDto.setText(comment.getText());
            basicCommentDto.setTime(comment.getTime());
            basicCommentDto.setId(comment.getId());


            return basicCommentDto;
        }

        return null;
    }

    public static Comment convertToEntityComment(BasicCommentDto basicCommentDto) {

        if (basicCommentDto.getId() != null) {
            Comment comment = new Comment();
            comment.setId(basicCommentDto.getId());
            comment.setText(basicCommentDto.getText());
            comment.setCount(basicCommentDto.getCount());
            comment.setTime(basicCommentDto.getTime());

            return comment;
        }
        return null;
    }
}
