package com.example.demoapplication.fragments.events;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demoapplication.R;
import com.example.demoapplication.presenters.subpresenters.admin.AdminEventsPresenter;
import com.example.demoapplication.presenters.subpresenters.student.StudentEventsPresenter;

public class AdminEventsFragmentView extends StudentEventsFragmentView {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new AdminEventsPresenter(activity);

        // Initialize the event list using database
        presenter.getEvents(this);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button createButton = view.findViewById(R.id.createEventButton);
        createButton.setVisibility(View.VISIBLE);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activity.replaceFragment(new CreateEventFragmentView());
            }
        });
    }
}

