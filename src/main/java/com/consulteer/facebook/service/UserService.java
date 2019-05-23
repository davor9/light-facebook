package com.consulteer.facebook.service;

import com.consulteer.facebook.entity.User;

import java.util.Optional;


public interface UserService {

    User create(User user);

    Optional<User> findOne(Long id);

}
