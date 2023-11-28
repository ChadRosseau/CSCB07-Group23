package com.example.demoapplication.fragments.complaints;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapplication.R;
import com.example.demoapplication.fragments.BaseFragment;

public class AdminComplaintsFragmentView extends BaseFragment {
    public AdminComplaintsFragmentView() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.complaints, container, false);
    }
}