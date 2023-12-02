package com.example.demoapplication.fragments.events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.helpers.Helper;

import java.util.ArrayList;

public class FeedbackAdapter extends RecyclerView.Adapter<FeedbackViewHolder> {
    private ArrayList<FeedbackItem> feedbackItemList;

    public FeedbackAdapter(ArrayList<FeedbackItem> feedbackItemList) {
        this.feedbackItemList = feedbackItemList;
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    @Override
    public FeedbackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_admin_feedback_list, parent, false);
        return new FeedbackViewHolder(eventView);
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @Override
    public void onBindViewHolder(FeedbackViewHolder holder, int position) {
        FeedbackItem currentFeedbackItem = feedbackItemList.get(position);
        holder.comment.setText(currentFeedbackItem.comment);
        if (currentFeedbackItem.rating >= 0) {
            holder.rating.setRating(currentFeedbackItem.rating);
        } else {
            holder.rating.setVisibility(View.GONE);
        }
    }

    // This method returns the total
    // number of items in the data set
    @Override
    public int getItemCount() {
        if (feedbackItemList == null) return 0;
        return feedbackItemList.size();
    }
}
