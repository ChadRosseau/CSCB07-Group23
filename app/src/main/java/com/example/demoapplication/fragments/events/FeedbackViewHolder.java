package com.example.demoapplication.fragments.events;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;

public class FeedbackViewHolder extends RecyclerView.ViewHolder {
    TextView feedback;
    TextView rating;

    private Button feedbackButton;

    public FeedbackViewHolder(MainActivityView activity, View eventView) {
        super(eventView);
        feedback = eventView.findViewById(R.id.eventsFeedbackA);
        rating = eventView.findViewById(R.id.eventsAdminFeedbackRating);
    }
}