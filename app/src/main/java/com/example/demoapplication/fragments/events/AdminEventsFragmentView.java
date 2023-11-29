package com.example.demoapplication.fragments.events;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demoapplication.R;

public class AdminEventsFragmentView extends StudentEventsFragmentView {
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button createButton = view.findViewById(R.id.createEventButton);
        createButton.setVisibility(View.VISIBLE);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}

