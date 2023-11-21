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

public class AdminNotificationsFragmentView extends NotificationsFragmentView {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.admin_notifications, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewNotifications);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        NotificationAdapter adapter = new NotificationAdapter(notificationList, this);
        recyclerView.setAdapter(adapter);

        Button createButton = view.findViewById(R.id.createButton);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showCreateFragment();
            }
        });

        return view;
    }

    private void showCreateFragment() {
        if (getActivity() instanceof MainActivityView) {
            ((MainActivityView) getActivity()).showCreateFragment();
        }
    }
}