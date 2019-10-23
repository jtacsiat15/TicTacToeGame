package com.example.tictactoe;

/**
 * Coordinate class
 *
 * CPSC 312 - 02
 * Programming Assignment #2
 * No sources to site
 *
 * @author Jalen Tacsiat
 * @version v!.0 9/16/19
 */
public class Coordinates {
    private int row;
    private int column;

    /**
     * dvc
     */
    public Coordinates(){
        this.row = 0;
        this.row = 0;
    }

    /**
     * evc
     * @param paramRow row user enters
     * @param paramColumn column enters
     */
    public Coordinates(int paramRow, int paramColumn){
        this.row = paramRow;
        this.column = paramColumn;
    }

    /**
     * sets the row
     * @param row row user enters
     */
    public void setRow(int row){
        this.row = row;
    }

    /**
     * sets column
     * @param column column user enters
     */
    public void setColumn(int column){
        this.column = column;
    }

    /**
     *
     * @return row
     */
    public int getRow(){
        return row;
    }

    /**
     *
     * @return column
     */
    public int getColumn(){
        return column;
    }

    /**
     *
     * @return
     */

    /**
     *
     * @return string of coordinates
     */
    public String toString(){
        return "(" + this.row + ", " + this.column + ")";
    }
}
