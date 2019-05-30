package com.consulteer.facebook.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "replies")
public class Replies extends Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "comment_id",nullable = false )
    private Comment comment;
    private LocalDateTime time;
    private int count;
    private String text;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
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
}
