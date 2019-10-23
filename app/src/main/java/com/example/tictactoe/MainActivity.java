package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText player1Name = (EditText)findViewById(R.id.player1Name);
        final EditText player2Name = (EditText)findViewById(R.id.player2Name);
        Button playButton =(Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                    Intent intent = new Intent(MainActivity.this, GameActivity.class);
                        String playerOneName = player1Name.getText().toString();
                        String playerTwoName = player2Name.getText().toString();
                        if(playerOneName.equals("") && playerTwoName.equals("")){
                            Toast toast = Toast.makeText(MainActivity.this, "Please enter a name for player 1 and 2", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else if(playerOneName.equals(""))
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "Please enter a name for player 1", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else if(playerTwoName.equals(""))
                        {
                            Toast toast = Toast.makeText(MainActivity.this, "Please enter a name for player 2", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else if(player1Name.equals(player2Name)){
                            Toast toast = Toast.makeText(MainActivity.this, "Player 1 and 2 names must be different", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                        else {
                            intent.putExtra("player1", playerOneName);
                            intent.putExtra("player2", playerTwoName);
                            startActivity(intent);
                        }
                }
        });
    }
}
