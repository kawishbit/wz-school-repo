package com.example.mobileprogramming.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.fragments.ActionDialogFragment;
import com.example.mobileprogramming.helpers.DownloadImageTask;
import com.example.mobileprogramming.helpers.MainEnums;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);

        TextView mainNameTextView = findViewById(R.id.mainNameText);
        String profilePreferencesKey = getString(R.string.profile_preferences);
        String profilePreferencesNameKey = getString(R.string.profile_preferences_name);
        String avatarUrl = getString(R.string.avatar_url);
        SharedPreferences sharedPreferences = getSharedPreferences(profilePreferencesKey, Context.MODE_PRIVATE);
        String profileName = sharedPreferences.getString(profilePreferencesNameKey, "Kawish Behzad");

        new DownloadImageTask(findViewById(R.id.mainAvatar)).execute(avatarUrl);

        mainNameTextView.setText(profileName);

        Button weekFiveButton = findViewById(R.id.weekFiveButton);
        Button weekSevenButton = findViewById(R.id.weekSevenButton);
        Button weekNineButton = findViewById(R.id.weekNineButton);
        Button weekTenButton = findViewById(R.id.weekTenButton);
        Button weekSixteenButton = findViewById(R.id.weekSixteenButton);

        weekFiveButton.setOnClickListener(v -> {
            showDialog("Minggu 5", "Test 5", MainEnums.Assignments.WEEK_5);
        });
        weekSevenButton.setOnClickListener(v -> {
            showDialog("Minggu 7", "Test 7", MainEnums.Assignments.WEEK_7);
        });
        weekNineButton.setOnClickListener(v -> {
            showDialog("Minggu 9", "Test 9", MainEnums.Assignments.WEEK_9);
        });
        weekTenButton.setOnClickListener(v -> {
            showDialog("Minggu 10", "Test 10", MainEnums.Assignments.WEEK_10);
        });
        weekSixteenButton.setOnClickListener(v -> {
            showDialog("Minggu 16", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, qu", MainEnums.Assignments.WEEK_16);
        });

    }

    private void showDialog(String title, String description, MainEnums.Assignments assignment) {
        ActionDialogFragment bottomDialogFragment =
                ActionDialogFragment.newInstance(title, description, assignment);
        bottomDialogFragment.show(getSupportFragmentManager(),
                ActionDialogFragment.TAG);

    }
}