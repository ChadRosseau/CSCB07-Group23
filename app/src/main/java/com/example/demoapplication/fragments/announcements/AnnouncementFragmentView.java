package com.example.demoapplication.fragments.announcements;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.student.StudentAnnouncementsPresenter;

import java.util.ArrayList;
import java.util.List;

public class AnnouncementFragmentView extends BaseFragment {
    private StudentAnnouncementsPresenter presenter;

    protected ArrayList<Announcement> announcementList;
    protected RecyclerView recyclerView;

    public AnnouncementFragmentView() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new StudentAnnouncementsPresenter(activity);

        // Initialize the announcement list using database
        presenter.getAnnouncements(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notifications, container, false);

        recyclerView = view.findViewById(R.id.recyclerViewNotifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setAnnouncementList(announcementList);

        return view;
    }

//    @Override
//    public void onItemClick(AnnouncementItem announcementItem) {
////         Handle the click event for the specific notification item
////         You can open a new activity, show a dialog, etc.
////         For example, show an extended text using a DialogFragment
////
//        ((MainActivityView) getActivity()).showCreateFragment();
//
//        announcementItem.setContent("A");
//        setAnnouncementItemList(announcementItemList);
//    }

    // Setter method to update the notification list
    public void setAnnouncementList(ArrayList<Announcement> announcementList) {
        this.announcementList = announcementList;
        // Notify the adapter that the data set has changed
        if (getView() != null) {
            AnnouncementAdapter adapter = new AnnouncementAdapter(announcementList);
            recyclerView.setAdapter(adapter);
        }
    }
}
