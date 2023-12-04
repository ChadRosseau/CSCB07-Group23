package com.example.demoapplication.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.demoapplication.AuthModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.UserData;
import com.example.demoapplication.fragments.announcements.AnnouncementsAdapter;
import com.example.demoapplication.presenters.subpresenters.HomePagePresenterAnnouncements;
import com.example.demoapplication.presenters.subpresenters.student.StudentAnnouncementsPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class HomeFragmentView extends BaseFragment {
    TextView testText;

    private HomePagePresenterAnnouncements presenterAnnouncements;

    protected static final int NUM_ANNOUNCEMENTS = 2;

    protected ArrayList<Announcement> announcementList;
    protected RecyclerView recyclerViewAnnouncements;
    protected ArrayList<Announcement> mostRecentAnnouncements;


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
}