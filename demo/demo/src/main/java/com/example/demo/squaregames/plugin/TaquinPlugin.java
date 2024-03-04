package com.example.demo.squaregames.plugin;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class TaquinPlugin implements GamePlugin{

    private final TaquinGameFactory taquinGameFactory  = new TaquinGameFactory();

    @Autowired
    private MessageSource messageSource;

    @Value("${nbPalyer_taq}")
    private int nbPlayer;

    @Value("${boardSize_taq}")
    private int boardSize;

    public int getNbPlayer() {
        return nbPlayer;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public String getName(Locale locale) {
        return messageSource.getMessage("taq", null, locale);
    }

    @Override
    public String getIdForPlugin() {
        return taquinGameFactory.getGameFactoryId();
    }

    @Override
    public GameFactory getFactory(){
        return this.taquinGameFactory;
    }
}
