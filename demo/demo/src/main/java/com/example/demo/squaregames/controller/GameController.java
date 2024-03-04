package com.example.demo.squaregames.controller;


import com.example.demo.squaregames.dto.GameCreationParams;

import com.example.demo.squaregames.plugin.GamePlugin;
import com.example.demo.squaregames.service.GameService;
import com.example.demo.squaregames.dto.GameDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class GameController {

    // TODO Make POST GET PUT DELETE
    // Game creations
    @Autowired
    private GameService gameService;

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params) {
        return gameService.createGame(params);
    }

    @GetMapping("/games")
    public List<String> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable String gameId) {
        return gameService.getGame(gameId);
    }

    // ========================================================
    // = Plugin
    // ========================================================

    @Autowired
    private List<GamePlugin> gamePlugin;

    @GetMapping("/lang")
    public List<String> headerTest(@RequestHeader("Accept-Language") Locale locale){
        return gamePlugin.stream().map(e -> e.getName(locale)).toList();
    }

    @GetMapping("/games2")
    public Collection<GamePlugin> getListGamePlugin(){
        return gamePlugin;
    }

}
