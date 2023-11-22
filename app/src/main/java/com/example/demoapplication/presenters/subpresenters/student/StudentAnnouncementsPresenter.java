package com.example.demoapplication.presenters.subpresenters.student;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.fragments.EventsFragmentView;
import com.example.demoapplication.fragments.NotificationItem;
import com.example.demoapplication.fragments.NotificationsFragmentView;
import com.example.demoapplication.helpers.Helper;
import com.example.demoapplication.presenters.subpresenters.AnnouncementsPresenter;

import java.util.ArrayList;
import java.util.List;

public class StudentAnnouncementsPresenter extends AnnouncementsPresenter {

    public StudentAnnouncementsPresenter(MainActivityView view, MainActivityModel model) {
        super(view, model);
    }
}
