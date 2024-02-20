package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class GameController {

    private static final List<String> games = new ArrayList<>();

    @PostMapping("/games")
    public String createGame(@RequestBody GameCreationParams params) {
        String gameId = UUID.randomUUID().toString();
        games.add(gameId);
        return gameId;
    }

    @GetMapping("/games")
    public List<String> getAllGames() {
        return games;
    }

}
