package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    Button btnPlay,btnPause,btnStop;
    boolean isPlaying=false;

    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay=findViewById(R.id.btn_play);
        btnPause=findViewById(R.id.btn_pause);
        btnStop=findViewById(R.id.btn_stop);

        player=MediaPlayer.create(MainActivity.this,R.raw.audio);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying){
                    player.start();
                    isPlaying=true;
                }
            }
        });
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying){
                    player.pause();
                    isPlaying=false;
                }
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPlaying) {
                    player.stop();
                    isPlaying = false;


                    try {
                        player.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }


                }
            }
        });
    }
}