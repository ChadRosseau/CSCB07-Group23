package com.example.demoapplication.fragments.events;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapplication.R;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.admin.AdminAnnouncementsPresenter;
import com.example.demoapplication.presenters.subpresenters.admin.AdminEventsPresenter;

public class CreateEventFragmentView extends BaseFragment {
    private AdminEventsPresenter presenter;
    private AdminAnnouncementsPresenter announcementsPresenter;

    public CreateEventFragmentView() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new AdminEventsPresenter(activity);
        this.announcementsPresenter = new AdminAnnouncementsPresenter(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.create_event, container, false);
    }


    // Complete this method :)
    private void submitEvent() {
        announcementsPresenter.createAnnouncement(); // <- here add title of event, "event" as type, description as content
    }
}