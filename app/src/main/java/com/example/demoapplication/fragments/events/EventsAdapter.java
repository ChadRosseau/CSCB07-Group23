package com.example.demoapplication.fragments.events;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.AuthModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.UserType;
import com.example.demoapplication.helpers.Helper;
import com.example.demoapplication.presenters.subpresenters.EventsPresenter;
import com.example.demoapplication.presenters.subpresenters.admin.AdminEventsPresenter;
import com.example.demoapplication.presenters.subpresenters.student.StudentEventsPresenter;

import java.util.ArrayList;

public class EventsAdapter extends RecyclerView.Adapter<EventViewHolder> {
    private ArrayList<Event> eventList;
    private MainActivityView activity;
    boolean isAdmin;
    private EventsPresenter presenter;

    public EventsAdapter(MainActivityView activity, EventsPresenter presenter, ArrayList<Event> eventList) {
        this.activity = activity;
        this.eventList = eventList;
        this.presenter = presenter;
        isAdmin = presenter instanceof AdminEventsPresenter;
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        return new EventViewHolder(activity, eventView);
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Event currentEvent = eventList.get(position);
        holder.setEventId(currentEvent.getEventId());
        holder.name.setText(currentEvent.getTitle());
        holder.date.setText(Helper.formatTimestamp(currentEvent.getDate()));
        holder.location.setText(currentEvent.getLocation());
        holder.attendees.setText(String.format("Attendees: %d/%d", currentEvent.getAttendeeCount(), currentEvent.getMaxAttendees()));
        holder.description.setText(currentEvent.getDescription());

        boolean isAdmin = AuthModel.getInstance().getCurrentUserData().getUserType() == UserType.Admin;

        if (isAdmin) {
            holder.feedbackButton.getLayoutParams().width = ViewGroup.LayoutParams.MATCH_PARENT;
            holder.feedbackButton.setText("VIEW FEEDBACK");
            holder.rsvpButton.setVisibility(View.GONE);
        } else {
            StudentEventsPresenter studentEventsPresenter = (StudentEventsPresenter)presenter;
            if (studentEventsPresenter.isRSVPd(holder.getEventId())) {
                holder.rsvpButton.setText("UNDO RSVP");
                holder.rsvpButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        studentEventsPresenter.undoRSVP(holder.getEventId());
                    }
                });
            } else {
                holder.rsvpButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        studentEventsPresenter.rsvpForEvent(holder.getEventId());
                    }
                });
            }
        }
        holder.feedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.replaceFragment(isAdmin ? AdminEventsFeedbackView.newInstance(holder.getEventId()) : new StudentEventsFeedbackView(), R.anim.transition_up);
            }
        });
    }

    // This method returns the total
    // number of items in the data set
    @Override
    public int getItemCount() {
        if (eventList == null) return 0;
        return eventList.size();
    }
}
