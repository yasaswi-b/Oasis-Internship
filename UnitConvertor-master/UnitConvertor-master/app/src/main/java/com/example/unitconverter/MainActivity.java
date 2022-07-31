package com.example.unitconverter;

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

    public void onWeight(View view) {
        startActivity(new Intent(getApplicationContext(), Weight.class));
    }

    public void onLength(View view) {
        startActivity(new Intent(getApplicationContext(), Length.class));
    }

    public void onSpeed(View view) {
        startActivity(new Intent(getApplicationContext(), Speed.class));
    }

    public void onTemperature(View view) {
        startActivity(new Intent(getApplicationContext(), Temperature.class));
    }
}