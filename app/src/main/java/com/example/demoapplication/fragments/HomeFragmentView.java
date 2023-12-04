package com.example.demoapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.fragments.announcements.AnnouncementsAdapter;
import com.example.demoapplication.fragments.events.EventViewHolder;
import com.example.demoapplication.helpers.Helper;
import com.example.demoapplication.presenters.subpresenters.HomePagePresenterAnnouncements;

import java.util.ArrayList;


public class HomeFragmentView extends BaseFragment {
    TextView testText;

    private HomePagePresenterAnnouncements presenterAnnouncements;

    protected static final int NUM_ANNOUNCEMENTS = 2;

    protected ArrayList<Announcement> announcementList;
    protected RecyclerView recyclerViewAnnouncements;
    protected ArrayList<Announcement> mostRecentAnnouncements;

    protected EventViewHolder eventItemViewHolder;
    protected Event event;


    public HomeFragmentView() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenterAnnouncements = new HomePagePresenterAnnouncements(activity);

        // Initialize the announcement list using database
        presenterAnnouncements.getAnnouncements(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.home, container, false);

        testText = view.findViewById(R.id.testText);
        recyclerViewAnnouncements = view.findViewById(R.id.recyclerViewNotificationsHome);
        recyclerViewAnnouncements.setLayoutManager(new LinearLayoutManager(activity));
        setAnnouncementList(announcementList);

        eventItemViewHolder = new EventViewHolder(view);
        getEventContentFromDatabase();
        setEventContent(eventItemViewHolder);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button logoutButton = view.findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.logout();
            }
        });
    }

    public void setAnnouncementList(ArrayList<Announcement> announcementList) {
        this.announcementList = announcementList;

        // Notify the adapter that the data set has changed
        if (getView() != null) {
            mostRecentAnnouncements = new ArrayList<Announcement> (announcementList.subList(0, NUM_ANNOUNCEMENTS));
            AnnouncementsAdapter adapter = new AnnouncementsAdapter(mostRecentAnnouncements);
            recyclerViewAnnouncements.setAdapter(adapter);
        }
    }

    public void getEventContentFromDatabase() {
        event = new Event("A", "A", "A", 1, 1, 1, "A");
    }

    public void setEventContent(EventViewHolder holder) {
        holder.setEventId(event.getEventId());
        holder.name.setText(event.getTitle());
        holder.date.setText(Helper.formatTimestamp(event.getDate()));
        holder.location.setText(event.getLocation());
        holder.attendees.setText(String.format("Attendees: %d/%d", event.getAttendeeCount(), event.getMaxAttendees()));
        holder.description.setText(event.getDescription());
        holder.rsvpButton.setVisibility(View.GONE);
        holder.feedbackButton.setText("Please visit the events page for further information.");

        ViewGroup.LayoutParams layoutParams = holder.feedbackButton.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        holder.feedbackButton.setLayoutParams(layoutParams);
    }
}