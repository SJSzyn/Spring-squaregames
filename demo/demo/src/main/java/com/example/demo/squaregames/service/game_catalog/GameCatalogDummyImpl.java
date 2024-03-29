package com.example.demo.squaregames.service.game_catalog;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class GameCatalogDummyImpl implements GameCatalog {

    TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
    ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();
    TaquinGameFactory taquinGameFactory  = new TaquinGameFactory();

    @Override
    public Collection<String> getGameIdentifiers() {
        return List.of(ticTacToeGameFactory.getGameFactoryId());
    }

    @Override
    public GameFactory getFactoryById(String id) {
        return switch (id) {
            case "connectfour" -> connectFourGameFactory;
            case "taquin" -> taquinGameFactory;
            default -> ticTacToeGameFactory;
        };
    }

}