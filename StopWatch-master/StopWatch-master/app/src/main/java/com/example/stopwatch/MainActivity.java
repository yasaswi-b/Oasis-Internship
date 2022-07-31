package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int sec = 0;
    private boolean running;
    private boolean wasRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            sec = savedInstanceState.getInt("seconds");

            running = savedInstanceState.getBoolean("running");

            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
    }

    public void onSaveInstanceState( Bundle savedInstanceState) {

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putInt("seconds", sec);

        savedInstanceState.putBoolean("running", running);

        savedInstanceState.putBoolean("wasRunning", wasRunning);
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    public void onStart(View v) {
        running = true;
    }

    public void onStop(View v) {
        running = false;
    }

    public void onReset(View v) {
        running = false;
        sec = 0;
    }

    private void runTimer()
    {
        final TextView timerView = (TextView)findViewById(R.id.stopWatch_timer);

        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int secs = sec % 60;
                int minutes = (sec % 3600) / 60;
                int hours = sec / 3600;

                String time = String.format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                timerView.setText(time);
                if (running) {
                    sec++;
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}
