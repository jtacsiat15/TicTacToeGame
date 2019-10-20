package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();
        //if(intent != null)

    }
    public void onButtonClick(View view){
        ImageView image = (ImageView) view;
        String player1Image = "basketball";
        String player2Image = "boxer";
        image.setImageResource(getResources().getIdentifier(player1Image, "drawable", getPackageName()));
    }


    public int selectTurn(){
        Random selectTurn = new Random();
        int chosenNum = selectTurn.nextInt();
        return chosenNum;
    }
}
