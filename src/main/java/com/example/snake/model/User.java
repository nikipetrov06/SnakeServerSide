package com.example.snake.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "highscore")
    private int highScore;

    public User() {
    }

    public User(Long id, String username, int highScore) {
        this.id = id;
        this.username = username;
        this.highScore = highScore;
    }

    public User(String username, int highScore) {
        this.username = username;
        this.highScore = highScore;
    }
}
