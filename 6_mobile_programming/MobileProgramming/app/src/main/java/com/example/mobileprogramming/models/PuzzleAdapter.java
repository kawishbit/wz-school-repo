package com.example.mobileprogramming.models;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.service.quicksettings.Tile;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.activities.SnapCameraActivity;
import com.example.mobileprogramming.helpers.Tiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class PuzzleAdapter extends RecyclerView.Adapter<PuzzleAdapter.ViewHolder> {
    private Map<Integer, Tiles> adapterData;
    private final LayoutInflater inflater;
    private Context context;
    private ViewHolder selectedTileViewHolder = null;
    private ItemClickListener clickListener;

    private boolean correct = false;

    public PuzzleAdapter(Context context, Map<Integer, Tiles> data) {
        this.inflater = LayoutInflater.from(context);
        this.context = context;
        this.adapterData = data;
    }

    public Context getContext() {
        return this.context;
    }

    public boolean getCorrect() {
        return this.correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.puzzle_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Tiles imageRes = adapterData.get(position);
        if(imageRes != null) {
            holder.tile.setImageResource(imageRes.getDrawable());
            holder.tile.setContentDescription(String.valueOf(imageRes.getDrawable()));
        }

    }

    @Override
    public int getItemCount() {
        return adapterData.size();
    }

    public void swapTiles(int fromPosition, int toPosition) {

        List<Integer> keys = new ArrayList<>(this.adapterData.keySet());
        Collections.swap(keys, fromPosition, toPosition);

        Map<Integer, Tiles> shuffledTiles = new LinkedHashMap<>();

        for(int i = 0; i < keys.size(); i++) {
            shuffledTiles.put(i, this.adapterData.get(keys.get(i)));
        }

        this.adapterData = shuffledTiles;

        notifyItemMoved(fromPosition, toPosition);
//        checkOrder();
    }

    public void checkOrder() {
        List<Tiles> tiles = new ArrayList<>();

        for (Map.Entry<Integer, Tiles> i : this.adapterData.entrySet()) {
            tiles.add(i.getValue());
        }

        String orders = tiles.stream().map(Tiles::getOrder).map(String::valueOf).collect(Collectors.joining(""));

        String rightOrders = "0169214378135114121015";

        boolean sorted = rightOrders.equals(orders);

        if(sorted) {
            try {
                TimeUnit.SECONDS.sleep(2);
                this.context.startActivity(new Intent(context, SnapCameraActivity.class));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void onTileSelected(ViewHolder tileViewHolder) {
        tileViewHolder.itemView.setBackgroundColor(Color.GRAY);
        this.selectedTileViewHolder = tileViewHolder;
    }

    public void onTileReleased(ViewHolder tileViewHolder) {
        tileViewHolder.itemView.setBackgroundColor(Color.WHITE);

        if (this.selectedTileViewHolder != null && this.selectedTileViewHolder != tileViewHolder) {
            int fromPosition = this.selectedTileViewHolder.getAdapterPosition();
            int toPosition = tileViewHolder.getAdapterPosition();
            this.swapTiles(fromPosition, toPosition);
        }

        this.selectedTileViewHolder = null;
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public AppCompatImageView tile;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tile = itemView.findViewById(R.id.puzzle_tile);
            this.tile.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (clickListener != null) clickListener.onItemClick(view, correct);
        }
    }

    public Tiles getItem(int id) {
        return this.adapterData.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, boolean correct);
    }
}
