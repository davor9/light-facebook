package com.consulteer.facebook.service;


import com.consulteer.facebook.dto.BasicPostDto;
import com.consulteer.facebook.dto.UserDto;



import java.util.List;



public interface UserService {

    UserDto create(UserDto userDto);

    UserDto findOne(Long id);

    List<BasicPostDto> findAllPostByUser(Long userId);
}
