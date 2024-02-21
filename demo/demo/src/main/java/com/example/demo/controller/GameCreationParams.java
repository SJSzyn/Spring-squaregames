package com.example.demo.controller;

import fr.le_campus_numerique.square_games.engine.GameFactory;

public class GameCreationParams {
    private String typeGame;
    private int playerCount;
    private int boardSize;


    public String getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(String typeGame) {
        this.typeGame = typeGame;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}