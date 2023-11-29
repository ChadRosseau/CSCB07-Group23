package com.example.demoapplication.fragments.events;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;

public class AdminEventViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView feedback;
    TextView rating;

    private Button feedbackButton;

    public AdminEventViewHolder(MainActivityView activity, View eventView) {
        super(eventView);
        name = eventView.findViewById(R.id.eventsFeedbackAName);
        feedback = eventView.findViewById(R.id.eventsFeedbackA);
        rating = eventView.findViewById(R.id.eventsAdminFeedbackRating);
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