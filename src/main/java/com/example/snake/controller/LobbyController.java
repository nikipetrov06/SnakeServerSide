package com.example.snake.controller;


import com.example.snake.entity.Lobby;
import com.example.snake.service.LobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LobbyController {

    private final LobbyService lobbyService;

    @Autowired
    public LobbyController(LobbyService lobbyService) {
        this.lobbyService = lobbyService;
    }

    @PostMapping("/create")
    public Lobby createLobby(@RequestParam Long userId) {
        return lobbyService.createLobby(userId);
    }

    @PutMapping("/join")
    public Lobby joinLobby(@RequestParam int lobbyId, @RequestParam Long userId) {
        return lobbyService.joinLobby(lobbyId, userId);
    }

    @GetMapping("/lobbies")
    public List<Lobby> getAllLobies() {
        return lobbyService.getAllLobbies();
    }

    @DeleteMapping("/remove")
    public Lobby removeLobby(@RequestParam int index) {
        return lobbyService.removeLobby(index);
    }
}
