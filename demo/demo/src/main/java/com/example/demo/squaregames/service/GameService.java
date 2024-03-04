package com.example.demo.squaregames.service;

import com.example.demo.squaregames.dto.GameCreationParams;
import com.example.demo.squaregames.dto.GameDTO;

import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface GameService {

    GameDTO createGame(@RequestBody GameCreationParams params);
    List<String> getAllGames();
    GameDTO getGame(String gameId);

}