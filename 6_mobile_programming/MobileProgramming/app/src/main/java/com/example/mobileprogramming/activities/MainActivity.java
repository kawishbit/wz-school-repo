package com.example.mobileprogramming.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mobileprogramming.R;

import uk.co.markormesher.android_fab.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);

    }
}