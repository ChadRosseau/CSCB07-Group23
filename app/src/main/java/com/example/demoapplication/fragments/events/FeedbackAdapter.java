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
    private ArrayList<Event> eventList;
    private MainActivityView activity;

    public FeedbackAdapter(MainActivityView activity, ArrayList<Event> eventList) {
        this.activity = activity;
        this.eventList = eventList;
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    @Override
    public FeedbackViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_admin_feedback_list, parent, false);
        return new FeedbackViewHolder(activity, eventView);
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @Override
    public void onBindViewHolder(FeedbackViewHolder holder, int position) {
        Event currentEvent = eventList.get(position);
//        holder.feedback.setText(currentEvent.getFeedback());
    }

    // This method returns the total
    // number of items in the data set
    @Override
    public int getItemCount() {
        if (eventList == null) return 0;
        return eventList.size();
    }
}
