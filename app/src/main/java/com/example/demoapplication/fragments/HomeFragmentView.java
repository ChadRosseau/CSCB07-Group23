package com.example.demoapplication.fragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import com.example.demoapplication.baseClasses.UserData;

import java.util.concurrent.TimeUnit;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragmentView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragmentView extends BaseFragment {
    Button testButton;
    TextView testText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        testButton = view.findViewById(R.id.testButton);
        testText = view.findViewById(R.id.testText);

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                testText.setText("Signed in as a " + AuthModel.getInstance().getCurrentUserData().getUserType().toString());
            }
        });
        Button logoutButton = view.findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.logout();
            }
        });
    }
}