package com.example.demo.squaregames.plugin;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class TicTacToePlugin implements GamePlugin{

    private final TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();

    @Autowired
    private MessageSource messageSource;

    @Value("${nbPalyer_tic}")
    private int nbPlayer;

    @Value("${boardSize_tic}")
    private int boardSize;

    public int getNbPlayer() {
        return nbPlayer;
    }

    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public String getName(Locale locale) {
        return messageSource.getMessage("tic", null, locale);
    }

    @Override
    public String getIdForPlugin() {
        return ticTacToeGameFactory.getGameFactoryId();
    }

    @Override
    public GameFactory getFactory(){
        return this.ticTacToeGameFactory;
    }

}