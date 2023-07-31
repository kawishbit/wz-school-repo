package com.example.mobileprogramming.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.helpers.ImageDownloader;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProfileActivity extends AppCompatActivity {
    private ExecutorService executorService;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_profile);


        executorService = Executors.newFixedThreadPool(1);

        handler = new Handler();

        TextView mainNameTextView = findViewById(R.id.mainNameText);
        TextView mainNimTextView = findViewById(R.id.mainNimText);
        String profilePreferencesKey = getString(R.string.profile_preferences);
        String profilePreferencesNameKey = getString(R.string.profile_preferences_name);
        String profilePreferencesNimKey = getString(R.string.profile_preferences_nim);
        String avatarUrl = getString(R.string.avatar_url);
        SharedPreferences sharedPreferences = getSharedPreferences(profilePreferencesKey, Context.MODE_PRIVATE);
        String profileName = sharedPreferences.getString(profilePreferencesNameKey, "Kawish Behzad");
        String profileNim = sharedPreferences.getString(profilePreferencesNimKey, "200401075");

        CircularImageView avatar = findViewById(R.id.mainAvatar);


        loadImageFromUrl(avatar, avatarUrl);

        mainNameTextView.setText(profileName);
        mainNimTextView.setText(profileNim);


        avatar.setOnClickListener(v -> {
            ImageDownloader.downloadImage(getApplicationContext(), avatarUrl);
            Toast.makeText(getApplicationContext(), "File is being downloaded", Toast.LENGTH_SHORT).show();
        });



        FloatingActionButton editBtn = findViewById(R.id.editProfileBtn);
        editBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, SettingActivity.class);
            startActivity(intent);
        });
        AppCompatButton settingBtn = findViewById(R.id.settingsBtn);
        settingBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, SettingActivity.class);
            startActivity(intent);
        });
        FloatingActionButton backBtn = findViewById(R.id.profBackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }
    private void loadImageFromUrl(ImageView view, String imageUrl) {
        executorService.execute(() -> {
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                final Bitmap bitmap = BitmapFactory.decodeStream(inputStream);

                handler.post(() -> view.setImageBitmap(bitmap));

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Shut down the ExecutorService when the activity is destroyed to release resources.
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String avatarUrl = getString(R.string.avatar_url);
        ImageDownloader.downloadImage(getApplicationContext(), avatarUrl);
        Toast.makeText(getApplicationContext(), "You have unlocked an easter egg onRestart()", Toast.LENGTH_SHORT).show();
    }
}