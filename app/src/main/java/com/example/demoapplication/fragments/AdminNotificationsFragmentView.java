package com.example.demoapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AdminNotificationsFragmentView extends Fragment {

    private List<NotificationItem> notificationList;
    public AdminNotificationsFragmentView() {
        // Required empty public constructor
    }
//    public static AdminNotificationsFragmentView newInstance(String param1, String param2) {
//        AdminNotificationsFragmentView fragment = new AdminNotificationsFragmentView();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notificationList = new ArrayList<>();
        notificationList.add(new NotificationItem("Notification 1", "announcement", "2023/11/11", "You are beautiful."));
        notificationList.add(new NotificationItem("Notification 2",  "event", "2022/1/1", "Free pizza today."));

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.admin_notifications, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewNotifications);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        NotificationAdapter adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);

        Button createButton = view.findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showCreateFragment();
            }
        });

        return view;
    }

    public void setNotificationList(List<NotificationItem> notificationList) {
        this.notificationList = notificationList;
        // Notify the adapter that the data set has changed
        if (getView() != null) {
            RecyclerView recyclerView = getView().findViewById(R.id.recyclerViewNotifications);
            NotificationAdapter adapter = new NotificationAdapter(notificationList);
            recyclerView.setAdapter(adapter);
        }
    }

    private void showCreateFragment() {
        if (getActivity() instanceof MainActivityView) {
            ((MainActivityView) getActivity()).showCreateFragment();
        }
    }
}