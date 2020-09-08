package com.example.snake.service;

import com.example.snake.entity.Lobby;
import com.example.snake.entity.User;
import com.example.snake.repository.LobbyRepository;
import com.example.snake.repository.UserRepository;
import exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LobbyService {

    private final UserRepository userRepository;
    private final LobbyRepository lobbyRepository;

    @Autowired
    public LobbyService(UserRepository userRepository, LobbyRepository lobbyRepository) {
        this.userRepository = userRepository;
        this.lobbyRepository = lobbyRepository;
    }

    public Lobby createLobby(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        user.setLobby(new Lobby(user));
        userRepository.save(user);
        return user.getLobby();
    }

    public Lobby joinLobby(Long lobbyId, Long userId) {
        Lobby lobby = lobbyRepository.findById(lobbyId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();
        if (lobby.getFreePlaces() > 0 && user.getLobby() == null) {
            lobby.setFreePlaces(lobby.getFreePlaces() - 1);
            user.setLobby(lobby);
            userRepository.save(user);
        } else {
            throw new BadRequestException("Either the lobby is full or user already has lobby");
        }
        return lobby;
    }
}
