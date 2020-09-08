package com.example.snake.controller;


import com.example.snake.entity.Lobby;
import com.example.snake.service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LobbyController {

    private final LobbyService lobbyService;

    @Autowired
    public LobbyController(LobbyService lobbyService) {
        this.lobbyService = lobbyService;
    }

    public Lobby createLobby(@RequestParam Long userId) {
        return lobbyService.createLobby(userId);
    }

    public Lobby joinLobby(@RequestParam Long lobbyId, @RequestParam Long userId) {
        return lobbyService.joinLobby(lobbyId, userId);
    }
}
