package com.example.demoapplication.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.demoapplication.AuthModel;
import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.UserType;
import com.example.demoapplication.fragments.announcements.AnnouncementsAdapter;
import com.example.demoapplication.fragments.events.AdminEventsFragmentView;
import com.example.demoapplication.fragments.events.EventViewHolder;
import com.example.demoapplication.fragments.events.StudentEventsFragmentView;
import com.example.demoapplication.helpers.Helper;
import com.example.demoapplication.presenters.subpresenters.HomePresenter;

import java.util.ArrayList;


public class HomeFragmentView extends BaseFragment {
    TextView testText;

    private HomePresenter presenter;

    protected static final int NUM_ANNOUNCEMENTS = 2;
    protected static final int MAX_EVENT_LINES = 3;

    protected ArrayList<Announcement> announcementList;
    protected RecyclerView recyclerViewAnnouncements;
    protected ArrayList<Announcement> mostRecentAnnouncements;

    protected EventViewHolder eventItemViewHolder;
    protected Event event;


    public HomeFragmentView() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new HomePresenter(activity);

        // Initialize the announcement list using database
        presenter.getAnnouncements(this);
        presenter.getUpcomingEvent(this);
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
            mostRecentAnnouncements = new ArrayList<> (announcementList.subList(0, NUM_ANNOUNCEMENTS));
            AnnouncementsAdapter adapter = new AnnouncementsAdapter(mostRecentAnnouncements);
            recyclerViewAnnouncements.setAdapter(adapter);
        }
    }

    public void setEventContent(Event event) {
        eventItemViewHolder.setEventId(event.getEventId());
        eventItemViewHolder.name.setText(event.getTitle());
        eventItemViewHolder.date.setText(Helper.formatTimestamp(event.getDate()));
        eventItemViewHolder.location.setText(event.getLocation());
        eventItemViewHolder.attendees.setText(String.format("Attendees: %d/%d", event.getAttendeeCount(), event.getMaxAttendees()));

        eventItemViewHolder.description.setText(event.getDescription());
        eventItemViewHolder.description.setMaxLines(MAX_EVENT_LINES);
        eventItemViewHolder.description.setEllipsize(TextUtils.TruncateAt.END);

        eventItemViewHolder.rsvpButton.setVisibility(View.GONE);
        eventItemViewHolder.feedbackButton.setText("SEE MORE");

        eventItemViewHolder.feedbackButton.setOnClickListener((l) -> {activity.replaceFragment(AuthModel.getInstance().getCurrentUserData().getUserType() == UserType.Admin ? new AdminEventsFragmentView() : new StudentEventsFragmentView());});

        ViewGroup.LayoutParams layoutParams = eventItemViewHolder.feedbackButton.getLayoutParams();
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        eventItemViewHolder.feedbackButton.setLayoutParams(layoutParams);
    }
}