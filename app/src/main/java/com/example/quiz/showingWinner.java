package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class showingWinner extends AppCompatActivity {
    private Intent get_win;
    private TextView win, move;
    private VideoView video;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showing_winner);

        win = (TextView) findViewById(R.id.textView4);
        move = (TextView) findViewById(R.id.moves);
        video = (VideoView) findViewById(R.id.videoView2);
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        get_win= getIntent();
        String get_value=get_win.getStringExtra("value");
        Log.i("value",get_value);
        int value=Integer.parseInt(get_value);

        if(value==0){
        String winner= get_win.getStringExtra("Winner");
        String moves= get_win.getStringExtra("moves");
        Log.i("Winner", winner);
        video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.congratulations);
        video.start();
        win.setText(winner+ " Won");
        move.setText("Win in "+moves+" moves");
        }

        else {String winner= get_win.getStringExtra("draw");
            Log.i("Winner", winner);
            video.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.draw_video);
            video.start();
            win.setText("Game ended in a draw !");

        }
    }

    public void restart(View view) {
        Intent restart= new Intent(this, playername.class);
        startActivity(restart);
    }

    @Override
    public void onBackPressed() {
        setContentView(R.layout.activity_playername);
    }
}