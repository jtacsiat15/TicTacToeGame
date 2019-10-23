package com.example.tictactoe;

public class RunGame {
    private String player1Name;
    private String player2Name;

    RunGame(String player1Name, String player2Name){
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
    public String getFirstTurn(String playerName){
        if(playerName.equals(player1Name))
            return player1Name + "'s turn";
        else
            return player2Name + "'s turn";
    }
    public String getNextTurn(String playerName){
        if(playerName.equals(player1Name))
            return player1Name + "'s turn";
        else
            return player2Name + "'s turn";
    }
    public String getTurn(String playerName){
        if(playerName.equals(player1Name))
            return player1Name + "'s turn";
        else
            return player2Name + "'s turn";
    }
}
