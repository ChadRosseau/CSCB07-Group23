package com.example.demoapplication.fragments.complaints;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapplication.R;

public class StudentComplaintsFragmentView extends Fragment {
    public StudentComplaintsFragmentView() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.complaints, container, false);
    }
}