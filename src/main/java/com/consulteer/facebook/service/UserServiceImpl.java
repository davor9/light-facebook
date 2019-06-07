package com.consulteer.facebook.service;

import com.consulteer.facebook.dto.BasicPostDto;

import com.consulteer.facebook.dto.UserDto;
import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDto create(UserDto input) {
        if(!isValid(input)){
            return null;
        }

        String email = input.getEmail();
        UserDto userDto = UserDto.convertToUserDto(userRepository.findUserByEmail(email));
        if(userDto == null){

           return UserDto.convertToUserDto(userRepository.save(UserDto.convertToEntity(input)));
        }
        return null;
    }

    @Override
    public UserDto findOne(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        UserDto userDto = UserDto.convertToUserDto(user);
        return userDto;
    }

    @Override
    public List<BasicPostDto> findAllPostByUser(Long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            UserDto dtoUser= UserDto.convertToUserDto(user);

            return dtoUser.getPosts();
        }
        return null;
    }


    private boolean isValid(UserDto user){
        if(user == null || user.getEmail() == null || user.getEmail().isEmpty()
                || user.getPassword() == null || user.getPassword().isEmpty()){
            return false;
        }

        return true;
    }
}
