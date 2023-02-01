package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ticTacToe(View view) {
        Intent inte= new Intent(this, playername.class);
        startActivity(inte);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}