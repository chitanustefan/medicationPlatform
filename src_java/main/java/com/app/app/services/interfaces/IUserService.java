package com.app.app.services.interfaces;

import com.app.app.entities.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();
    User saveUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
