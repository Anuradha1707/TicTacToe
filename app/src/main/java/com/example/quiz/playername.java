package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class playername extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playername);
    }

    public void startGame(View view) {
        Intent SGame= new Intent(this,TicTacToe.class);
        EditText play1= (EditText) findViewById(R.id.player1);
        String player1 =play1.getText().toString();
        EditText play2= (EditText) findViewById(R.id.player2);
        String player2 =play2.getText().toString();
        Log.i("player",player2);
        SGame.putExtra("Player1",player1);
        SGame.putExtra("Player2",player2);
        startActivity(SGame);
    }

    @Override
    public void onBackPressed() {
        setContentView(R.layout.activity_main);
    }
}