package com.consulteer.facebook.dto;




import com.consulteer.facebook.entity.Replies;

import java.time.LocalDateTime;

public class BasicRepliesDto {

    private Long id;
    private LocalDateTime time;
    private int count;
    private String text;

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

    public static BasicRepliesDto convertToBasicDtoReplies(Replies replies){
        if(replies != null) {
            BasicRepliesDto basicRepliesDto = new BasicRepliesDto();

            basicRepliesDto.setCount(replies.getCount());
            basicRepliesDto.setId(replies.getId());
            basicRepliesDto.setText(replies.getText());
            basicRepliesDto.setTime(replies.getTime());

            return basicRepliesDto;
        }
        return null;
    }

    public static Replies convertToEntityReplies(BasicRepliesDto basicRepliesDto){
        if(basicRepliesDto != null){
            Replies replies = new Replies();

            replies.setCount(basicRepliesDto.getCount());
            replies.setTime(basicRepliesDto.getTime());
            replies.setId(basicRepliesDto.getId());
            replies.setText(basicRepliesDto.getText());

            return replies;
        }
        return null;
    }
}
