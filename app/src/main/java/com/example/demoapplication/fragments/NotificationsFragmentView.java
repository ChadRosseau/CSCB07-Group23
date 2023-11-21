package com.example.demoapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Announcement;

import java.util.List;
import java.util.ArrayList;

public class NotificationsFragmentView extends Fragment implements NotificationAdapter.OnItemClickListener {

    protected List<NotificationItem> notificationList;

    public NotificationsFragmentView() {
        // Required empty public constructor
    }

//    public static NotificationsFragmentView newInstance(String param1, String param2) {
//        NotificationsFragmentView fragment = new NotificationsFragmentView();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Initialize the notification list using database
        ((MainActivityView)requireActivity()).presenter.student.announcements.getAnnouncements(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notifications, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewNotifications);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        NotificationAdapter adapter = new NotificationAdapter(notificationList, this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemClick(NotificationItem notificationItem) {
        // Handle the click event for the specific notification item
        // You can open a new activity, show a dialog, etc.
        // For example, show an extended text using a DialogFragment

//        ((MainActivityView) getActivity()).showCreateFragment();

        notificationItem.setContent("A");
        setNotificationList(notificationList);
    }

    // Setter method to update the notification list
    public void setNotificationList(List<NotificationItem> notificationList) {
        this.notificationList = notificationList;
        // Notify the adapter that the data set has changed
        if (getView() != null) {
            RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewNotifications);
            NotificationAdapter adapter = new NotificationAdapter(notificationList, this);
            recyclerView.setAdapter(adapter);
        }
    }
}
