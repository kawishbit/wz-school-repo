package com.example.mobileprogramming.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mobileprogramming.R;
import com.example.mobileprogramming.activities.FabLayoutActivity;
import com.example.mobileprogramming.activities.MainActivity;
import com.example.mobileprogramming.activities.ProfileActivity;
import com.example.mobileprogramming.activities.PuzzleActivity;
import com.example.mobileprogramming.helpers.MainEnums;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

public class ActionDialogFragment extends BottomSheetDialogFragment {
    public static final String TAG = "ActionBottomDialog";
    public String title = "Title";
    public String description = "Description";
    public MainEnums.Assignments assignment = MainEnums.Assignments.WEEK_5;

    public ActionDialogFragment(String title, String description, MainEnums.Assignments assignment) {
        this.title = title;
        this.description = description;
        this.assignment = assignment;
    }

    public static ActionDialogFragment newInstance(String title, String description, MainEnums.Assignments assignment) {
        return new ActionDialogFragment(title, description, assignment);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_bottomsheet_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Objects.requireNonNull(getDialog()).getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        TextView title = view.findViewById(R.id.bottomTitleText);
        title.setText(this.title);

        TextView description = view.findViewById(R.id.bottomDescriptionText);
        description.setText(this.description);

        Button proceedButton = view.findViewById(R.id.bottomSheetButton);
        proceedButton.setOnClickListener(v -> {
            Intent intent = null;

            switch (this.assignment) {

                case WEEK_5: {
                    intent = new Intent(getActivity(), FabLayoutActivity.class);
                }
                break;
                case WEEK_7:
                case WEEK_9:
                case WEEK_10: {
                    intent = new Intent(getActivity(), ProfileActivity.class);
                }
                break;
                case WEEK_16: {
                    intent = new Intent(getActivity(), PuzzleActivity.class);
                }
                break;

            }

            if(intent != null) {
                startActivity(intent);
            }
        });
    }

}
