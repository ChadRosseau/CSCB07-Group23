package com.example.demoapplication.fragments.events;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.AuthModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.UserType;

public class EventViewHolder extends RecyclerView.ViewHolder {
    private String eventId;
    public TextView name;
    public TextView date;
    public TextView location;
    public TextView attendees;
    public TextView description;

    public Button feedbackButton;
    public Button rsvpButton;


    public EventViewHolder(View eventView) {
        super(eventView);
        name = eventView.findViewById(R.id.eventName);
        date = eventView.findViewById(R.id.eventDate);
        location = eventView.findViewById(R.id.eventLocation);
        attendees = eventView.findViewById(R.id.eventAttendees);
        description = eventView.findViewById(R.id.eventDescription);
        feedbackButton = eventView.findViewById(R.id.feedbackButton);
        rsvpButton = eventView.findViewById(R.id.rsvpButton);
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}