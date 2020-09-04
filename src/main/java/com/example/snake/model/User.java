package com.example.snake.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    private Long id;
    private String username;
    private int currentScore;
    private int highScore;

    public User() {
    }

    public User(Long id, String username, int currentScore, int highScore) {
        this.id = id;
        this.username = username;
        this.currentScore = currentScore;
        this.highScore = highScore;
    }

    public User(String username, int currentScore, int highScore) {
        this.id = null;
        this.username = username;
        this.currentScore = currentScore;
        this.highScore = highScore;
    }
}
