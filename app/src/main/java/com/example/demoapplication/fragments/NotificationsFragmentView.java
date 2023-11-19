package com.example.demoapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapplication.R;

import java.util.List;
import java.util.ArrayList;

public class NotificationsFragmentView extends Fragment {

    private List<NotificationItem> notificationList;

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
        notificationList = new ArrayList<>();
        notificationList.add(new NotificationItem("Notification 1", "announcement", "2023/11/11", "You are beautiful."));
        notificationList.add(new NotificationItem("Notification 2",  "event", "2022/1/1", "Free pizza today."));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notifications, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewNotifications);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        NotificationAdapter adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    // Setter method to update the notification list
    public void setNotificationList(List<NotificationItem> notificationList) {
        this.notificationList = notificationList;
        // Notify the adapter that the data set has changed
        if (getView() != null) {
            RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewNotifications);
            NotificationAdapter adapter = new NotificationAdapter(notificationList);
            recyclerView.setAdapter(adapter);
        }
    }
}
