package com.example.snake.service;

import com.example.snake.model.User;
import com.example.snake.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUser(String username) {
        User user = userRepository.findByUsername(username).orElse(null);
        if (user == null) {
            User s = new User(username, 0);
            user = userRepository.save(s);
        }
        return user;
    }
}
