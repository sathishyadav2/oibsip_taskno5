package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.textclassifier.TextClassifierEvent;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {
private Chronometer stopwatch;
private long pauseOffset;
private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stopwatch=findViewById(R.id.stopwatch);
    }
    public void startChronometer(View v){
        if(!running){
            stopwatch.setBase(SystemClock.elapsedRealtime()-pauseOffset);
            stopwatch.start();
            running =true;
        }
    }
    public void pauseChronometer(View v){
        if(running){
            stopwatch.stop();
            pauseOffset=SystemClock.elapsedRealtime()-stopwatch.getBase();
            running =false;
        }
    }
    public void resetChronometer(View v){
        stopwatch.setBase(SystemClock.elapsedRealtime());
        pauseOffset=0;
    }

}