package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.Comment;
import com.consulteer.facebook.entity.Post;
import com.consulteer.facebook.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthdate;
    private String email;
    private String password;

    private List<BasicPostDto> posts = new ArrayList<>(0);

    private List<BasicCommentDto> comments = new ArrayList<>(0);

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BasicPostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<BasicPostDto> posts) {
        this.posts = posts;
    }

    public List<BasicCommentDto> getComments() {
        return comments;
    }

    public void setComments(List<BasicCommentDto> comments) {
        this.comments = comments;
    }

    public static UserDto convertToUserDto(User user) {

        if (user != null) {

            UserDto userDto = new UserDto();

            userDto.setName(user.getName());
            userDto.setBirthdate(user.getBirthdate());
            userDto.setEmail(user.getEmail());
            userDto.setId(user.getId());
            userDto.setLastName(user.getLastName());
            userDto.setPassword(user.getPassword());

            if (user.getPosts() != null) {
               List<BasicPostDto> posts = user.getPosts()
                       .stream()
                       .map(c->BasicPostDto.convertToBasicDtoPost(c))
                       .collect(Collectors.toList());
               userDto.setPosts(posts);

            }
            if (user.getComments() != null) {
                List<BasicCommentDto> comments = user.getComments()
                        .stream()
                        .map(c -> BasicCommentDto.convertToBasicDtoComment(c))
                        .collect(Collectors.toList());
                userDto.setComments(comments);

            }
            return userDto;

        }

        return null;
    }

    public static User convertToEntity(UserDto userDto) {

        if (userDto != null) {

            User user = new User();

            user.setId(userDto.getId());
            user.setLastName(userDto.getLastName());
            user.setEmail(userDto.getEmail());
            user.setBirthdate(userDto.getBirthdate());
            user.setName(userDto.getName());
            user.setPassword(userDto.getPassword());

            if (userDto.getPosts() != null) {
                List<Post> posts = userDto.getPosts()
                        .stream()
                        .map(c -> BasicPostDto.convertToEntityPost(c))
                        .collect(Collectors.toList());
                user.setPosts(posts);

                }



            if (userDto.getComments() != null) {
                List<Comment> comments = userDto.getComments()
                        .stream()
                        .map(c -> BasicCommentDto.convertToEntityComment(c))
                        .collect(Collectors.toList());
                user.setComments(comments);

//                List<Comment> comments = userDto.getComments()
//                        .stream()
//                        .map(c -> BasicCommentDto.convertToEntityComment(c))
//                        .collect(Collectors.toList());
//                user.setComments(comments);

//                userDto.getComments()
//                        .forEach(c -> {
//                            user.getComments().add(BasicCommentDto.convertToEntityComment(c));
//                        });
            }


            return user;
        }
        return null;
    }
}
