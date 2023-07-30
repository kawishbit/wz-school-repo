package com.example.mobileprogramming.models;

import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PuzzleDecoration extends RecyclerView.ItemDecoration {
    private final int space;

    public PuzzleDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, @NonNull View view, RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.left = this.space;
        outRect.right = this.space;
        outRect.bottom = this.space;

        if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = this.space;
        } else {
            outRect.top = 0;
        }
    }
}
