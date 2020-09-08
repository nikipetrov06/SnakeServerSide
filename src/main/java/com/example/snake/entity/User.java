package com.example.snake.entity;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "lobby_id", referencedColumnName = "id")
    private Lobby lobby;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public Lobby getLobby() {
        return lobby;
    }

    public void setLobby(Lobby lobby) {
        this.lobby = lobby;
    }
}
