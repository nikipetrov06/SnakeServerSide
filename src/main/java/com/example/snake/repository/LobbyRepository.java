package com.example.snake.repository;

import com.example.snake.entity.Lobby;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LobbyRepository extends JpaRepository<Lobby, Long> {
}
