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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragmentView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragmentView extends Fragment{
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
//                UserData userData = ((MainActivityView)requireActivity()).presenter.auth.getCurrentUserData();
//                String text = "Signed in as " + userData.getUid();
//                testText.setText(text);
            }
        });
        Button logoutButton = view.findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AuthModel.getInstance().logout();
                ((MainActivityView)getActivity()).logout();
            }
        });
    }
}