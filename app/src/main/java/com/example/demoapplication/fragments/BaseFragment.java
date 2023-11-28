package com.example.demoapplication.fragments;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.subpresenters.SubPresenter;

public class BaseFragment extends Fragment {
    protected MainActivityView activity;
    protected SubPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.activity = (MainActivityView)requireActivity();
    }

    @Override
    public void onDestroy() {
        presenter.endListeners();
        super.onDestroy();
    }
}
