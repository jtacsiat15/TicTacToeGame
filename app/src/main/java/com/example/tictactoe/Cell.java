package com.example.tictactoe;

/**
 * Cell class
 * CPSC 312 -02
 * Programming Assignment #2
 * No sources to site
 *
 * @author Jalen Tacsiat
 * @version v!.0 9/16/19
 */
public class Cell {
    private char symbol;
    private Coordinates coordinates = new Coordinates();

    /**
     * sets the symbol with the player symbol
     * @param symbol player symbol
     */
    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    /**
     *
     * @return character of the player symbol
     */
    public char getSymbol(){
        return symbol;
    }

    /**
     * sets symbol to '-'
     * dvc for cell
     */
    public  Cell(){
        this.symbol = '-';
    }

    /**
     * sets symbol using paramSymbol
     * evc for cell
     * @param paramSymbol player cell
     */
    public Cell(char paramSymbol){
        this.symbol = paramSymbol;
    }

    /**
     *
     * @return String cell
     */
    public String toString(){
        return this.symbol + "";
    }
}
