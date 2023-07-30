package com.example.mobileprogramming.activities;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.databinding.ActivityFabLayoutBinding;

public class FabLayoutActivity extends AppCompatActivity {

    private ActivityFabLayoutBinding binding;
    private boolean IsExpanded = false;
    private Animation fromBottomFabAnim;
    private Animation toBottomFabAnim;
    private Animation fromBottomBgAnim;
    private Animation toBottomBgAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        binding = ActivityFabLayoutBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        fromBottomFabAnim = AnimationUtils.loadAnimation(this, R.anim.from_bottom_fab);
        toBottomFabAnim = AnimationUtils.loadAnimation(this, R.anim.to_bottom_fab);
        fromBottomBgAnim = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
        toBottomBgAnim = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);

        binding.mainFabBtn.setOnClickListener(v -> {
            if (this.IsExpanded) {
                shrinkFab();
            } else {
                expandFab();
            }

        });


        //TODO: frags on click
    }

    private void shrinkFab() {
        binding.transparentBg.startAnimation(toBottomBgAnim);
        binding.homeFabBtn.startAnimation(toBottomFabAnim);
        binding.homeFabTv.startAnimation(toBottomFabAnim);
        binding.linearHFabBtn.startAnimation(toBottomFabAnim);
        binding.linearHFabTv.startAnimation(toBottomFabAnim);
        binding.linearVFabBtn.startAnimation(toBottomFabAnim);
        binding.linearVFabTv.startAnimation(toBottomFabAnim);
        binding.relativeFabBtn.startAnimation(toBottomFabAnim);
        binding.relativeFabTv.startAnimation(toBottomFabAnim);

        this.IsExpanded = !this.IsExpanded;
    }
    private void expandFab() {
        binding.transparentBg.startAnimation(fromBottomBgAnim);
        binding.homeFabBtn.startAnimation(fromBottomFabAnim);
        binding.homeFabTv.startAnimation(fromBottomFabAnim);
        binding.linearHFabBtn.startAnimation(fromBottomFabAnim);
        binding.linearHFabTv.startAnimation(fromBottomFabAnim);
        binding.linearVFabBtn.startAnimation(fromBottomFabAnim);
        binding.linearVFabTv.startAnimation(fromBottomFabAnim);
        binding.relativeFabBtn.startAnimation(fromBottomFabAnim);
        binding.relativeFabTv.startAnimation(fromBottomFabAnim);

        this.IsExpanded = !this.IsExpanded;

    }
}