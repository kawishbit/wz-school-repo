package com.example.mobileprogramming.models;

import android.content.Intent;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.activities.SnapCameraActivity;
import com.example.mobileprogramming.helpers.Tiles;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class PuzzleCallback extends ItemTouchHelper.SimpleCallback {
    private final PuzzleAdapter mAdapter;
    HashMap<Integer, Tiles> tiles = new LinkedHashMap<>();

    public PuzzleCallback(PuzzleAdapter adapter) {
        super(ItemTouchHelper.UP | ItemTouchHelper.DOWN | ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, 0);
        this.mAdapter = adapter;

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
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
        int fromPosition = viewHolder.getAdapterPosition();
        int toPosition = target.getAdapterPosition();
        mAdapter.swapTiles(fromPosition, toPosition);
        int itemCount = Objects.requireNonNull(recyclerView.getAdapter()).getItemCount();

        boolean correct = true;
        for (int i = 0; i < itemCount; i++) {
            // Get the ViewHolder at the specified position
            RecyclerView.ViewHolder currViewHolder = recyclerView.findViewHolderForAdapterPosition(i);
            assert currViewHolder != null;
            String original = String.valueOf(Objects.requireNonNull(tiles.get(i)).getDrawable());
            String curr = String.valueOf(currViewHolder.itemView.findViewById(R.id.puzzle_tile).getContentDescription());
            boolean viewHolderPosition = original.equals(curr);


            if(!viewHolderPosition) {
                this.mAdapter.setCorrect(false);
                correct = false;
                break;
            }
        }

        if(correct) {
            this.mAdapter.setCorrect(true);
        }
        return true;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
        // We don't need this for the 15-puzzle, but it's required to be implemented.
    }

}
