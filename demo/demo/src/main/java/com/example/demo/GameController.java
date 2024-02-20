package com.example.demo;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class GameController {

    private static final List<String> games = new ArrayList<>();
    // GameFactory gameFactory;

    @Autowired
    private GameCatalog gameCatalog;

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params) {
//     String gameId = UUID.randomUUID().toString();
//    games.add(gameId);
//     return gameId;
            GameFactory gameFactory = gameCatalog.getFactoryById(params.getTypeGame());
            gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
            return new GameDTO(gameFactory.getGameFactoryId(), params.getPlayerCount(), params.getBoardSize());
    }

    @GetMapping("/games")
   public List<String> getAllGames() {
       return games;
   }

//   @GetMapping("/games/{gameId}")
//   public Object getGame(@PathVariable String gameId) {
//// TODO - actually get and return game with id 'gameId'
//        return  gameId;
//    }

}
