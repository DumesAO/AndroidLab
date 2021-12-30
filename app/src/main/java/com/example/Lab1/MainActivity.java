package com.example.Lab1;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;

import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button playBtn;
    Button pauseBtn;
    Button stopBtn;
    VideoView player;
    int currentPlaying=R.raw.video;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player = findViewById(R.id.player);
        Uri uri=Uri.parse( "android.resource://" + getPackageName() + "/" + currentPlaying);
        player.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        player.setMediaController(mediaController);

        mediaController.setMediaPlayer(player);


        playBtn = findViewById(R.id.playBtn);
        pauseBtn = findViewById(R.id.pauseBtn);
        stopBtn = findViewById(R.id.stopBtn);
        pauseBtn.setEnabled(false);
        stopBtn.setEnabled(false);
    }
    private void stopPlaying(){
        pauseBtn.setEnabled(false);
        stopBtn.setEnabled(false);
        player.pause();
        player.seekTo(0);
        playBtn.setEnabled(true);
    }


    public void play(View view){

        if(player.isPlaying()){
            player.resume();
        } else {
            player.start();
        }
        playBtn.setEnabled(false);
        pauseBtn.setEnabled(true);
        stopBtn.setEnabled(true);
    }
    public void pause(View view){

        player.pause();
        playBtn.setEnabled(true);
        pauseBtn.setEnabled(false);
        stopBtn.setEnabled(true);
    }
    public void stop(View view){
        stopPlaying();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (player.isPlaying()) {
            stopPlaying();
        }
    }

    public void change(View view) {
        currentPlaying= currentPlaying == R.raw.video ? R.raw.audio : R.raw.video;
        Uri uri=Uri.parse( "android.resource://" + getPackageName() + "/" + currentPlaying);
        player.setVideoURI(uri);
    }
}
