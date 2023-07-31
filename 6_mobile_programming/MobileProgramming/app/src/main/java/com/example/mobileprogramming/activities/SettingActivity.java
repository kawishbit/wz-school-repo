package com.example.mobileprogramming.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.example.mobileprogramming.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SettingActivity extends AppCompatActivity {

    private ExecutorService executorService;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_setting);

        executorService = Executors.newFixedThreadPool(1);

        handler = new Handler();


        String avatarUrl = getString(R.string.avatar_url);

        CircularImageView avatar = findViewById(R.id.mainAvatar);
        loadImageFromUrl(avatar, avatarUrl);

        String profilePreferencesKey = getString(R.string.profile_preferences);
        String profilePreferencesNameKey = getString(R.string.profile_preferences_name);
        String profilePreferencesNimKey = getString(R.string.profile_preferences_nim);
        SharedPreferences sharedPreferences = getSharedPreferences(profilePreferencesKey, Context.MODE_PRIVATE);
        String profileName = sharedPreferences.getString(profilePreferencesNameKey, "Kawish Behzad");
        String profileNim = sharedPreferences.getString(profilePreferencesNimKey, "200401075");

        TextInputEditText nameInput = findViewById(R.id.name_input);
        TextInputEditText nimInput = findViewById(R.id.nim_input);

        nameInput.setText(profileName);
        nimInput.setText(profileNim);

        MaterialButton saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(v -> {
            String name = String.valueOf(nameInput.getText());
            String nim = String.valueOf(nimInput.getText());
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(profilePreferencesNameKey, name);
            editor.putString(profilePreferencesNimKey, nim);
            editor.apply();
            Intent intent = new Intent(SettingActivity.this, ProfileActivity.class);
            startActivity(intent);
        });

        FloatingActionButton backBtn = findViewById(R.id.profBackBtn);
        backBtn.setOnClickListener(v -> {
            Intent intent = new Intent(SettingActivity.this, ProfileActivity.class);
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
}