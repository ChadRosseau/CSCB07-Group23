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
    String eventId;
    TextView name;
    TextView date;
    TextView location;
    TextView attendees;
    TextView description;

    private Button feedbackButton;
    private Button rsvpButton;


    public EventViewHolder(MainActivityView activity, View eventView) {
        super(eventView);
        name = eventView.findViewById(R.id.eventName);
        date = eventView.findViewById(R.id.eventDate);
        location = eventView.findViewById(R.id.eventLocation);
        attendees = eventView.findViewById(R.id.eventAttendees);
        description = eventView.findViewById(R.id.eventDescription);
        feedbackButton = eventView.findViewById(R.id.feedbackButton);
        rsvpButton = eventView.findViewById(R.id.rsvpButton);

        boolean isAdmin = AuthModel.getInstance().getCurrentUserData().getUserType() == UserType.Admin;

        if (isAdmin) {
            feedbackButton.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            feedbackButton.setText("VIEW FEEDBACK");
            rsvpButton.setVisibility(View.GONE);
        }

        feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO: situational for admin/student
                activity.replaceFragment(isAdmin ? AdminEventsFeedbackView.newInstance(eventId) : new StudentEventsFeedbackView(), R.anim.transition_up);
            }
        });
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }
}