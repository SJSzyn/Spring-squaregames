package com.example.demo.squaregames.service;

import com.example.demo.squaregames.controller.GameCreationParams;
import com.example.demo.squaregames.controller.dto.GameDTO;
import com.example.demo.squaregames.service.game_catalog.GameCatalog;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private GameCatalog gameCatalog;

    private final Map<String, Game> list = new HashMap<>();

    @Override
    public GameDTO createGame(GameCreationParams params) {
        GameFactory gameFactory = gameCatalog.getFactoryById(params.typeGame());
        Game saveData = gameFactory.createGame(params.playerCount(), params.boardSize());
        list.put(saveData.getId().toString(), saveData);
        return new GameDTO(saveData.getId().toString(), params.typeGame(), params.playerCount(), params.boardSize());
    }

    @Override
    public List<String> getAllGames() {
        return new ArrayList<>(list.keySet());
    }

    @Override
    public GameDTO getGame(String gameId) {
        Game game = list.get(gameId);
        if (game == null) {
            System.out.println("Error");
        }
        return new GameDTO(game.getId().toString(), game.getFactoryId(), game.getPlayerIds().size(), game.getBoardSize());
    }

}