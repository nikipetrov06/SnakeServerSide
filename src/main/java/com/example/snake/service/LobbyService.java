package com.example.snake.service;

import com.example.snake.entity.Lobby;
import com.example.snake.entity.User;
import com.example.snake.repository.UserRepository;
import exception.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class LobbyService {

    private final UserRepository userRepository;

    private final List<Lobby> lobbyList;

    @Autowired
    public LobbyService(UserRepository userRepository) {
        this.userRepository = userRepository;
        lobbyList = new ArrayList<>();
    }

    public Lobby createLobby(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        Lobby lobby = new Lobby();
        lobbyList.add(lobby);
        lobby.setIndex(lobbyList.indexOf(lobby));
        lobby.getUsers().add(user);
        System.out.println(lobbyList.size());
        return lobby;
    }

    public Lobby joinLobby(int lobbyId, Long userId) {
        Lobby lobby = lobbyList.get(lobbyId);
        User user = userRepository.findById(userId).orElseThrow();
        if (lobby.getFreePlaces() > 0) {
            lobby.setFreePlaces(lobby.getFreePlaces() - 1);
            lobby.getUsers().add(user);
        } else {
            throw new BadRequestException("Either the lobby is full or user already has lobby");
        }
        return lobby;
    }

    public List<Lobby> getAllLobbies() {
        return lobbyList;
    }

    public Lobby removeLobby(int index) {
        Lobby lobby = lobbyList.get(index);
        lobbyList.remove(index);
        System.out.println(lobbyList.size());
        return lobby;
    }
}
