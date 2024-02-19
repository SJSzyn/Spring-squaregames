package com.example.demo;

import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class GameCatalogDummyImpl implements GameCatalog {

    private TicTacToeGameFactory ticTacToeGameFactory;

    public GameCatalogDummyImpl() {
        this.ticTacToeGameFactory = new TicTacToeGameFactory();
        // Any additional setup can be done here
    }

    @Override
    public List<String> getGameIdentifiers() {
        // Return a dummy list of identifiers or use the TicTacToeGameFactory instance as needed
        return Arrays.asList("TicTacToe"); // Example identifiers
    }
}
