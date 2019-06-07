package com.consulteer.facebook.dto;

import com.consulteer.facebook.entity.User;

import java.time.LocalDate;

public class BasicUserDto  {
    private  Long id;
    private String name;
    private   String lastName;
    private LocalDate birthdate;
    private  String email;
    private   String password;

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

    public static BasicUserDto convertToBasicDtoUser(User user){

        if(user!=null){
            BasicUserDto basicUserDto=new BasicUserDto();
            basicUserDto.setName(user.getName());
            basicUserDto.setBirthdate(user.getBirthdate());
            basicUserDto.setEmail(user.getEmail());
            basicUserDto.setId(user.getId());
            basicUserDto.setLastName(user.getLastName());
            basicUserDto.setPassword(user.getPassword());

            return basicUserDto;
        }

        return null;
    }

    public static User convertToEntityUser(BasicUserDto basicUserDto){

        if(basicUserDto.getId()!=null){
            User user=new User();
            user.setId(basicUserDto.getId());
            user.setLastName(basicUserDto.getLastName());
            user.setEmail(basicUserDto.getEmail());
            user.setBirthdate(basicUserDto.getBirthdate());
            user.setName(basicUserDto.getName());
            user.setPassword(basicUserDto.getPassword());

            return user;
        }
        return null;
    }

}
