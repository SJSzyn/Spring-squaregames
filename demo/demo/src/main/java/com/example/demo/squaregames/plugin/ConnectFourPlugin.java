package com.example.demo.squaregames.plugin;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class ConnectFourPlugin implements GamePlugin {

    private final ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();

    @Autowired
    private MessageSource messageSource;

    @Value("${nbPalyer_con}")
    private int nbPlayer;

    @Value("${boardSize_con}")
    private int boardSize;

    public int getNbPlayer() {
        return nbPlayer;
    }

    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public String getName(Locale locale){
        return messageSource.getMessage("con", null, locale);
    }

    @Override
    public String getIdForPlugin(){
        return connectFourGameFactory.getGameFactoryId();
    }

    @Override
    public GameFactory getFactory(){
        return this.connectFourGameFactory;
    }

}
