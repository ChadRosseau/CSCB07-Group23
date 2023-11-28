package com.example.demoapplication.fragments.events;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;

public class EventViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView date;
    TextView maxAttendees;
    TextView remaining;
    TextView description;

    private Button feedbackButton;

    public EventViewHolder(MainActivityView activity, View eventView) {
        super(eventView);
        name = eventView.findViewById(R.id.tvName);
        date = eventView.findViewById(R.id.tvDate);
        maxAttendees = eventView.findViewById(R.id.tvParticipants);
        remaining = eventView.findViewById(R.id.tvRemaining);
        description = eventView.findViewById(R.id.tvDescription);
        feedbackButton = eventView.findViewById(R.id.feedbackButton);
        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: situational for admin/student
                activity.replaceFragment(new StudentEventsFeedbackView(), R.anim.transition_up);
            }
        });
    }
}