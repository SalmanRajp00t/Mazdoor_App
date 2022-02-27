package com.example.loginform;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

public class Audio_player extends AppCompatActivity {
    TextView playerposition,playerduration;
    SeekBar seekBar;
    ImageView btplay,btrew,btpause,btff;

    MediaPlayer mediaPlayer;
    Handler handler=new Handler();
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio_player);
    getSupportActionBar().hide();

    playerposition = findViewById(R.id.playerPosition);
    playerduration = findViewById(R.id.playerduration);
    seekBar = findViewById(R.id.seek_bar);
    btplay = findViewById(R.id.btplay);
    btrew = findViewById(R.id.btff);
    btpause = findViewById(R.id.btpuse);
    btff = findViewById(R.id.btff);

    mediaPlayer = MediaPlayer.create(this,R.raw.mer);

    runnable = new Runnable() {
        @Override
        public void run() {
            seekBar.setProgress(mediaPlayer.getCurrentPosition());

            handler.postDelayed(this,500);
        }
    };
    int duration = mediaPlayer.getDuration();
    String sDuration = convertFormat(duration);
    playerduration.setText(sDuration);

    btplay.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            btplay.setVisibility(View.GONE);
            btpause.setVisibility(View.VISIBLE);
            mediaPlayer.start();
            seekBar.setMax(mediaPlayer.getDuration());
            handler.postDelayed(runnable,0);
        }
    });

    btpause.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            btpause.setVisibility(View.GONE);
            btplay.setVisibility(View.VISIBLE);
            mediaPlayer.pause();
            handler.removeCallbacks(runnable,0);
        }
    });

    btff.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int currentPosition= mediaPlayer.getCurrentPosition();
            int duration = mediaPlayer.getDuration();
            if(mediaPlayer.isPlaying() && duration !=currentPosition){
                currentPosition= currentPosition + 500;
                playerposition.setText(convertFormat(currentPosition));
                mediaPlayer.seekTo(currentPosition);
            }
        }
    });
    btrew.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int currentPosition= mediaPlayer.getCurrentPosition();
            if(mediaPlayer.isPlaying() && currentPosition > 500){
                currentPosition= currentPosition - 500;
                playerposition.setText(convertFormat(currentPosition));
                mediaPlayer.seekTo(currentPosition);
            }
        }
    });

    seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            if (fromUser){
                mediaPlayer.seekTo(progress);
            }
            playerposition.setText(convertFormat(mediaPlayer.getCurrentPosition()));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });

    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            btpause.setVisibility(View.GONE);
            btplay.setVisibility(View.VISIBLE);
            mediaPlayer.seekTo(0);
        }
    });


    }

    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d"
                ,TimeUnit.MILLISECONDS.toMinutes(duration)
                ,TimeUnit.MILLISECONDS.toSeconds(duration)
                ,TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }
}