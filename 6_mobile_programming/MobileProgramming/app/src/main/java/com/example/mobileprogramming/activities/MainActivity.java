package com.example.mobileprogramming.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.helpers.DownloadImageTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView mainNameTextView = findViewById(R.id.mainNameText);
        String profilePreferencesKey = getString(R.string.profile_preferences);
        String profilePreferencesNameKey = getString(R.string.profile_preferences_name);
        String avatarUrl = getString(R.string.avatar_url);
        SharedPreferences sharedPreferences = getSharedPreferences(profilePreferencesKey, Context.MODE_PRIVATE);
        String profileName = sharedPreferences.getString(profilePreferencesNameKey, "Kawish Behzad");

        new DownloadImageTask(findViewById(R.id.mainAvatar)).execute(avatarUrl);

        mainNameTextView.setText(profileName);

    }
}