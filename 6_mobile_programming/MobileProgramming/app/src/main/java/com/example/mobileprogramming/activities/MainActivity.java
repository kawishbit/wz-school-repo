package com.example.mobileprogramming.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.fragments.ActionDialogFragment;
import com.example.mobileprogramming.helpers.MainEnums;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private ExecutorService executorService;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);

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

        Button weekFiveButton = findViewById(R.id.weekFiveButton);
        Button weekSevenButton = findViewById(R.id.weekSevenButton);
        Button weekNineButton = findViewById(R.id.weekNineButton);
        Button weekTenButton = findViewById(R.id.weekTenButton);
        Button weekSixteenButton = findViewById(R.id.weekSixteenButton);

        weekFiveButton.setOnClickListener(v -> showDialog("Minggu 5", "Layout (linear [horizontal & vertical], relative)", MainEnums.Assignments.WEEK_5));
        weekSevenButton.setOnClickListener(v -> showDialog("Minggu 7", "Multiple activities (can move between activities)", MainEnums.Assignments.WEEK_7));

        weekNineButton.setOnClickListener(v -> showDialog("Minggu 9", "- Move to activity with intent\n" +
                "- Download an image using async task (click something to download)\n" +
                "- Input text, with SharedPreferences", MainEnums.Assignments.WEEK_9));

        weekTenButton.setOnClickListener(v -> showDialog("Minggu 10", "- Download image OnRestart\n" +
                "- Edit profile, save data with SharedPreferences (NIM & Name)", MainEnums.Assignments.WEEK_10));

        weekSixteenButton.setOnClickListener(v -> showDialog("Minggu 16", "- 15-Puzzle (RecyclerView) (show 15 tiles, find the correct order)\n" +
                "- CameraX  > Capture > share to social media", MainEnums.Assignments.WEEK_16));

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
    private void showDialog(String title, String description, MainEnums.Assignments assignment) {
        ActionDialogFragment bottomDialogFragment =
                ActionDialogFragment.newInstance(title, description, assignment);
        bottomDialogFragment.show(getSupportFragmentManager(),
                ActionDialogFragment.TAG);

    }

    @Override
    public void onBackPressed() {
        ActionDialogFragment fragment = (ActionDialogFragment) getSupportFragmentManager().findFragmentByTag(ActionDialogFragment.TAG);

        if (fragment != null && fragment.isAdded()) {
            fragment.dismiss();
        }

        super.onBackPressed();
    }
}