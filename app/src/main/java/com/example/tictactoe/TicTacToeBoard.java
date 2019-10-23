package com.example.tictactoe;

/**
 * This is the TicTacBoard class it contains a constructor to create the grid for the tictactoeboard
 * also contains method to see if moves are valid,
 * method to set cell in board
 * and methods to see if there is a winner or tie
 * CPSC 312 -02
 * Programming Assignment #2
 * No sources to site
 *
 * @author Jalen Tacsiat
 * @version v!.0 9/16/19
 */

public class TicTacToeBoard {
    private int N = 0;
    private Cell[][] grid ;

    /**
     * creates the board
     *
     * @param userSize
     */
    public TicTacToeBoard(int userSize){
        N = userSize;
        grid = new Cell[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                grid[i][j] = new Cell('-');
            }
        }
    }

    /**
     * resets the board
     * @param userSize
     */
    public void clearBoard(int userSize){
        N = userSize;
        grid = new Cell[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                grid[i][j] = new Cell('-');
            }
        }
    }


    /**
     * appends a string
     * @return a string that contains the grid
     */
    public String toString(){
        String appendString = "  ";
        int rowLabel = 0;
        int columnLabel = 0;
        for(int i = 0; i < N; i++){
            appendString += " " + columnLabel++ ;
        }
        appendString += "\n";
        for(int i = 0; i < N; i++){
            appendString += rowLabel++ + " ";
            for (int j = 0; j < N; j++){
                appendString += " " + grid[i][j].toString();
                //appendString += columnLabel++;
            }
            appendString += '\n';
        }
        return appendString;
    }

    /**
     * checks to see if the users move is valid
     * @param coordinates coordinates that the user selects
     * @return true or false based on if the users move is valid or not
     */

    public Boolean isValidMove(Coordinates coordinates){
        if (grid[coordinates.getRow()][coordinates.getColumn()].getSymbol() == 'O'||
                grid[coordinates.getRow()][coordinates.getColumn()].getSymbol() == 'X'){
            return false;
        }
        else
            return true;
    }

    /**
     * sets the cell in the grid to the users coordinates
     * @param coordinates users coordinates to make move
     * @param playerSymbol used to set the cell in the grid to the users coordinates
     */
    public void makeMove(Coordinates coordinates, char playerSymbol){
            grid[coordinates.getRow()][coordinates.getColumn()].setSymbol(playerSymbol);
    }

    /**
     * checks to see if there is a winner
     * @param playerSymbol symbol of the player whose turn it is
     * @return true or false if a player wins
     */
    public Boolean isWinner(char playerSymbol){
        if(isHorizontal(playerSymbol))
            return true;
        else if(isVertical(playerSymbol))
            return true;
        else if(isDiagonal(playerSymbol))
            return true;
        else
        return false;
    }

    /**
     * checks of see if a player has all their symbols in a column
     * @param playerSymbol symbol of the player whose turn it is
     * @return true or false based on if all their symbols are in a column
     */
    public Boolean isVertical(char playerSymbol){
        for(int i = 0; i < N; i++){
            int numMatchingCell = 0;
            for(int j = 0; j < N; j++){
                if(grid[j][i].getSymbol() == playerSymbol){
                    numMatchingCell++;
                }
                if(numMatchingCell == N){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * checks to see if a player has all their symbols in a row
     * @param playerSymbol symbol of a player whose turn it is
     * @return true or based on if a player has all their symbols in a row
     */
    public Boolean isHorizontal(char playerSymbol){ ;
        for(int i = 0; i < N; i++){
            int matchingCell = 0;
            for(int j = 0; j < N; j++){
                if(grid[i][j].getSymbol() == playerSymbol){
                    matchingCell++;
                }
                if(matchingCell == N){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * checks to see if a user has all their symbols in a diagonal form
     * @param playerSymbol symbol of the player whose turn it is
     * @return true or false based on if a user has all their symbols in a diagonal form
     */
    public  Boolean isDiagonal(char playerSymbol){
        int numMatchingCells = 0;
        for(int i = 0; i < N; i++){
            if(grid[i][i].getSymbol() == playerSymbol){
                numMatchingCells++;
            }
            if(numMatchingCells == N){
                return true;
            }
        }
        numMatchingCells = 0;
        for(int i = N - 1; i > -1; i--) {
            if (grid[(N - 1) - i][i].getSymbol() == playerSymbol) {
                numMatchingCells++;
            }
            if(numMatchingCells == N){
                return true;
            }
        }
        return false;
    }

    /**
     * checks to see if their is a tie or scratch
     * @param turns number of turns taken
     *
     * @return true or false based on if there is a tie
     */
    public Boolean isTie(int turns/*int turnSelector*/) {
        /*if(turnSelector == 1) {
            if (turns == (N * N)) {
                return true;
            }
            return false;
        }*/
        if(turns == (N*N)){
            return true;
        }
        return false;
    }
}
