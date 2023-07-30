package com.example.mobileprogramming.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.helpers.Tiles;
import com.example.mobileprogramming.models.PuzzleAdapter;
import com.example.mobileprogramming.models.PuzzleCallback;
import com.example.mobileprogramming.models.PuzzleDecoration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class PuzzleActivity extends AppCompatActivity implements PuzzleAdapter.ItemClickListener  {

    PuzzleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_puzzle);

        HashMap<Integer, Tiles> tiles = new HashMap<>();

        tiles.put(0, new Tiles(R.drawable.image1x1,0));
        tiles.put(1, new Tiles(R.drawable.image2x1,1));
        tiles.put(2, new Tiles(R.drawable.image3x1,2));
        tiles.put(3, new Tiles(R.drawable.image4x1,3));

        tiles.put(4, new Tiles(R.drawable.image1x2,4));
        tiles.put(5, new Tiles(R.drawable.image2x2,5));
        tiles.put(6, new Tiles(R.drawable.image3x2,6));
        tiles.put(7, new Tiles(R.drawable.image4x2,7));

        tiles.put(8, new Tiles(R.drawable.image1x3,8));
        tiles.put(9, new Tiles(R.drawable.image2x3,9));
        tiles.put(10, new Tiles(R.drawable.image3x3,10));
        tiles.put(11, new Tiles(R.drawable.image4x3,11));

        tiles.put(12, new Tiles(R.drawable.image1x4,12));
        tiles.put(13, new Tiles(R.drawable.image2x4,13));
        tiles.put(14, new Tiles(R.drawable.image3x4,14));
        tiles.put(15, new Tiles(R.drawable.image4x4,15));

        List<Integer> list = new ArrayList<>(tiles.keySet());
        Collections.shuffle(list);

        Map<Integer, Tiles> shuffledTiles = new LinkedHashMap<>();

        for(int i = 0; i < list.size(); i++) {
            shuffledTiles.put(i, tiles.get(list.get(i)));
        }

        RecyclerView recyclerView = findViewById(R.id.puzzleRecyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this, 4, LinearLayoutManager.VERTICAL, false));

        this.adapter = new PuzzleAdapter(PuzzleActivity.this, shuffledTiles);
        this.adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        recyclerView.addItemDecoration(new PuzzleDecoration(5));


        ItemTouchHelper.SimpleCallback callback = new PuzzleCallback(this.adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

    }

    @Override
    public void onItemClick(View view, boolean correct) {
        if(this.adapter.getCorrect()) {

            try {
                Toast.makeText(getApplicationContext(), "You've solved the puzzle", Toast.LENGTH_SHORT).show();
                TimeUnit.SECONDS.sleep(2);
                startActivity(new Intent(getApplicationContext(), SnapCameraActivity.class));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}