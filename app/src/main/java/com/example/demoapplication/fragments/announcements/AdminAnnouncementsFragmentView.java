package com.example.demoapplication.fragments.announcements;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;
import com.example.demoapplication.presenters.subpresenters.admin.AdminAnnouncementsPresenter;

public class AdminAnnouncementsFragmentView extends AnnouncementsFragmentView {
    private AdminAnnouncementsPresenter presenter;

    public AdminAnnouncementsFragmentView() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new AdminAnnouncementsPresenter(activity);

        // Initialize the notification list using database
        presenter.getAnnouncements(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button createButton = view.findViewById(R.id.createNotificationButton);
        createButton.setVisibility(View.VISIBLE);
        createButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showCreateFragment();
            }
        });
    }

    private void showCreateFragment() {
        if (getActivity() instanceof MainActivityView) {
            CreateAnnouncementView createAnnouncementView = new CreateAnnouncementView();
            activity.replaceFragment(createAnnouncementView, R.anim.transition_up);
        }
    }
}