package com.example.demoapplication.fragments.events;

import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;

public class FeedbackViewHolder extends RecyclerView.ViewHolder {
    TextView comment;
    RatingBar rating;

    public FeedbackViewHolder(View eventView) {
        super(eventView);
        comment = eventView.findViewById(R.id.eventsFeedbackComment);
        rating = eventView.findViewById(R.id.adminEventsFeedbackRatingBar);
    }
}