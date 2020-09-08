package com.example.snake.controller;

import com.example.snake.entity.User;
import com.example.snake.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public User getUser(@RequestParam String username) {
        return userService.getUser(username);
    }

    @PutMapping("/update")
    public User updateUser(@RequestParam Long id, @RequestParam int highscore) {
        return userService.updateUser(id, highscore);
    }

}
