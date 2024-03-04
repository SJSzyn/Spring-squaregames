package com.example.demo.squaregames.plugin;

import fr.le_campus_numerique.square_games.engine.GameFactory;

import java.util.Locale;

public interface GamePlugin {

    String getName(Locale locale);
    String getIdForPlugin();

    GameFactory getFactory();
    int getNbPlayer();
    int getBoardSize();
}
