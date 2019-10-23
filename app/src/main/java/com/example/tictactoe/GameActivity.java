package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    String player1Name = "";
    String player2Name = "";
    int turnCount = 0;
    TicTacToeBoard gameBoard = new TicTacToeBoard(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String TAG = "inoncreate";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ImageView image = (ImageView) findViewById(R.id.playerImage);
        Intent intent = getIntent();
        player1Name = intent.getStringExtra("player1");
        player2Name = intent.getStringExtra("player2");
        TextView playerTurnText = (TextView) findViewById(R.id.playerDisplay);
        onPlayAgainOnClickFunction();
        quitButtonClicked();
        Log.d(TAG, "player1name :" + player1Name + " player2Name: " + player2Name);
        image.setImageResource(R.drawable.basketball);
        playerTurnText.setText(player1Name + " turn");
    }

    /**
     * controls all the image views
     * when an image view is clicked it will change that image view with the corresponding player image
     * also checks to see if a move is valid
     *
     * @param view
     */
    public void onButtonClick(View view) {
        String TAG = "inOnButtonClick";
        Log.d(TAG, "initial turn count " + turnCount);
        ImageView image = (ImageView) view;
        TextView playerTurnText = (TextView) findViewById(R.id.playerDisplay);
        ImageView playerDisplay = (ImageView)findViewById(R.id.playerImage);
        Button playAgainButton = (Button)findViewById(R.id.playAgainButton);
        String imageCoordinates = image.getTag().toString();

        //gets the coordinates of a imageView when clicked by using tags
        int rowCor = Integer.parseInt(String.valueOf(imageCoordinates.charAt(0)));
        int columnCor = Integer.parseInt(String.valueOf(imageCoordinates.charAt(1)));
        Coordinates coordinates = new Coordinates(rowCor, columnCor);
        Log.d(TAG, "tag: " + imageCoordinates + " imagexcor: " + rowCor + " imageycor: " + columnCor);
        //player1 functions
        //sets players functions
        if(turnCount % 2 == 0){
            Log.d(TAG, "in player 1 move " + gameBoard.isValidMove(coordinates));
            if (gameBoard.isValidMove(coordinates)) {
                gameBoard.makeMove(coordinates, 'X');
                image.setImageResource(R.drawable.basketball);
                playerDisplay.setImageResource(R.drawable.boxer);
                playerTurnText.setText(player2Name + " turn");
                if(gameBoard.isWinner('X')){
                    playerDisplay.setImageResource(R.drawable.basketball);
                    playerTurnText.setText(player1Name + " is the winner");
                    playAgainButton.setVisibility(View.VISIBLE);
                    disableButtons();
                }
                turnCount++;
            } else {
                Toast toast = Toast.makeText(GameActivity.this, "not a valid move click another place", Toast.LENGTH_SHORT);
                Log.d(TAG, "in valid move check(player1)");
                toast.show();
            }
        }
        //player2 functions
        //sets players functions
        if(turnCount % 2 == 1){
            Log.d(TAG, "in player 2 move " + gameBoard.isValidMove(coordinates));
            if(gameBoard.isValidMove(coordinates)){
                gameBoard.makeMove(coordinates, 'O');
                image.setImageResource(R.drawable.boxer);
                playerTurnText.setText(player1Name + " turn");
                playerDisplay.setImageResource(R.drawable.basketball);
                if(gameBoard.isWinner('O')){
                    playerDisplay.setImageResource(R.drawable.boxer);
                    playerTurnText.setText(player2Name + " is the winner");
                    playAgainButton.setVisibility(View.VISIBLE);
                    disableButtons();
                }
                turnCount++;
            } else {
                Toast toast = Toast.makeText(GameActivity.this, "not a valid move click another place", Toast.LENGTH_SHORT);
                Log.d(TAG, "in valid move check(player2)");
                toast.show();
            }
        }
        if(gameBoard.isTie(turnCount)){
            playerTurnText.setText("It appears that the game has scratched, please select if you want to play again or quit");
            disableButtons();
            playAgainButton.setVisibility(View.VISIBLE);
        }
        Log.d(TAG,"turncount: " + turnCount);
    }

    public void disableButtons(){
        ImageView image1 = (ImageView)findViewById(R.id.button1);
        ImageView image2 = (ImageView)findViewById(R.id.button2);
        ImageView image3 = (ImageView)findViewById(R.id.button3);
        ImageView image4 = (ImageView)findViewById(R.id.button4);
        ImageView image5 = (ImageView)findViewById(R.id.button5);
        ImageView image6 = (ImageView)findViewById(R.id.button6);
        ImageView image7 = (ImageView)findViewById(R.id.button7);
        ImageView image8 = (ImageView)findViewById(R.id.button8);
        ImageView image9 = (ImageView)findViewById(R.id.button9);
        image1.setEnabled(false);
        image2.setEnabled(false);
        image3.setEnabled(false);
        image4.setEnabled(false);
        image5.setEnabled(false);
        image6.setEnabled(false);
        image7.setEnabled(false);
        image8.setEnabled(false);
        image9.setEnabled(false);
    }

    public void onPlayAgainOnClickFunction(){
        final String TAG = "in clicked";
        final Button playAgainButton = (Button)findViewById(R.id.playAgainButton);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "in play click");
                playAgainClicked();
                gameBoard.clearBoard(3);
                turnCount = 0;
                TextView playerTurnText = (TextView) findViewById(R.id.playerDisplay);
                Log.d(TAG, "player1name :" + player1Name + " player2Name: " + player2Name);
            }
        });
    }

    public void playAgainClicked(){
        ImageView image1 = (ImageView)findViewById(R.id.button1);
        ImageView image2 = (ImageView)findViewById(R.id.button2);
        ImageView image3 = (ImageView)findViewById(R.id.button3);
        ImageView image4 = (ImageView)findViewById(R.id.button4);
        ImageView image5 = (ImageView)findViewById(R.id.button5);
        ImageView image6 = (ImageView)findViewById(R.id.button6);
        ImageView image7 = (ImageView)findViewById(R.id.button7);
        ImageView image8 = (ImageView)findViewById(R.id.button8);
        ImageView image9 = (ImageView)findViewById(R.id.button9);
        image1.setImageDrawable(null);
        image2.setImageDrawable(null);
        image3.setImageDrawable(null);
        image4.setImageDrawable(null);
        image5.setImageDrawable(null);
        image6.setImageDrawable(null);
        image7.setImageDrawable(null);
        image8.setImageDrawable(null);
        image9.setImageDrawable(null);
        image1.setEnabled(true);
        image2.setEnabled(true);
        image3.setEnabled(true);
        image4.setEnabled(true);
        image5.setEnabled(true);
        image6.setEnabled(true);
        image7.setEnabled(true);
        image8.setEnabled(true);
        image9.setEnabled(true);
    }

    public void quitButtonClicked(){
        Button quitButton  = (Button)findViewById(R.id.quitButton);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameActivity.this.finish();
            }
        });
    }

}
