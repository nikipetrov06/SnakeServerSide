package com.example.snake.entity;

import javax.persistence.*;

@Entity
@Table(name = "lobby")
public class Lobby {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "free_places")
    private int freePlaces;

    @OneToOne(mappedBy = "lobby")
    private User user;

    public Lobby() {
        this.freePlaces = 1;
    }

    public Lobby(User user) {
        super();
        this.id = null;
        this.user = user;
    }

    public Lobby(Long id, User user) {
        super();
        this.id = id;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
    public int getFreePlaces() {
        return freePlaces;
    }

    public void setFreePlaces(int freePlaces) {
        this.freePlaces = freePlaces;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
