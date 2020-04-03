package com.app.app.services;

import com.app.app.entities.User;
import com.app.app.repository.UserRepository;
import com.app.app.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    public User login(String email, String password){
        List<User> userS = userRepository.findAll();
        for(User u: userS) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                System.out.println("Birthday: " + u.getBirthday());
                return u;
            }
        }
        return null;
    }


    @Override
    public List<User> getAllUsers() {
        List<User> result = userRepository.findAll();
        return result;
    }

    @Override
    public User saveUser(User user) {
        User savedUser = this.userRepository.save(user);
        return savedUser;

    }

    @Override
    @Transactional
    public User updateUser(Long id, User user) {

        Optional<User> optionalUser = userRepository.findById(id);
        User result = optionalUser.orElse(user);
        return result;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
