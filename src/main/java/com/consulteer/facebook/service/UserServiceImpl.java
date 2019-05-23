package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.User;
import com.consulteer.facebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User create(User input) {
        if(!isValid(input)){
            return null;
        }

        String email = input.getEmail();
        User user = userRepository.findUserByEmail(email);
        if(user == null){
            return userRepository.save(input);
        }
        return null;
    }

    @Override
    public Optional<User> findOne(Long id) {
        return userRepository.findById(id);
    }

//    @Override
//    public List<Post> findAllPostByUser(Long userId) {
//        Optional<User> optionalUser = userRepository.findById(userId);
//        if(optionalUser.isPresent()){
//            User user = optionalUser.get();
//            return user.getPosts();
//        }
//        return null;
//    }


    private boolean isValid(User user){
        if(user == null || user.getEmail() == null || user.getEmail().isEmpty()
                || user.getPassword() == null || user.getPassword().isEmpty()){
            return false;
        }

        return true;
    }
}
