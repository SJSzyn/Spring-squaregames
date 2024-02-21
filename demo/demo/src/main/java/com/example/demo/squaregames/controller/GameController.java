package com.example.demo.squaregames.controller;

import com.example.demo.squaregames.service.game_catalog.GameCatalog;
import com.example.demo.squaregames.controller.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class GameController {

    @Autowired
    private GameCatalog gameCatalog;
    Map<String, Game> list = new HashMap<>();

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params) {
        // TODO - Create a new game with 'gameID', 'gameType', 'playerCount' and 'boardSize'
        GameFactory gameFactory = gameCatalog.getFactoryById(params.getTypeGame());
        Game saveData = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
        list.put(saveData.getId().toString(), saveData);
        return new GameDTO(saveData.getId().toString(), params.getTypeGame(), params.getPlayerCount(), params.getBoardSize());
    }

    @GetMapping("/games")
    public List<String> getAllGames() {
        // TODO - Get all 'gameId' of games created
        return new ArrayList<>(list.keySet());
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId){
        // TODO - Get and return game with id 'gameId'
        Game game = list.get(gameId);
        return new GameDTO(game.getId().toString(), game.getFactoryId() ,game.getPlayerIds().size(), game.getBoardSize());
    }

}
