package com.example.demoapplication.presenters;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.subpresenters.SubPresenter;
import com.example.demoapplication.presenters.subpresenters.admin.AdminAnnouncementsPresenter;
import com.example.demoapplication.presenters.subpresenters.admin.AdminComplaintsPresenter;
import com.example.demoapplication.presenters.subpresenters.admin.AdminEventsPresenter;

public class AdminPresenter extends SubPresenter {
    public AdminAnnouncementsPresenter announcements;
    public AdminComplaintsPresenter complaints;
    public AdminEventsPresenter events;

    public AdminPresenter(MainActivityView view, MainActivityModel model) {
        super(view, model);
        this.announcements = new AdminAnnouncementsPresenter(view, model);
        this.complaints = new AdminComplaintsPresenter(view, model);
        this.events = new AdminEventsPresenter(view, model);
    }
}
