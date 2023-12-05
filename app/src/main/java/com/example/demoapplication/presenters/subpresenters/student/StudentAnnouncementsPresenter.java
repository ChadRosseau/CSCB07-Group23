package com.example.demoapplication.presenters.subpresenters.student;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.subpresenters.AnnouncementsPresenter;

/**
 * Presenter class for managing announcements from a student's perspective.
 */
public class StudentAnnouncementsPresenter extends AnnouncementsPresenter {

    /**
     * Constructor for StudentAnnouncementsPresenter.
     *
     * @param activity  The associated MainActivityView.
     */
    public StudentAnnouncementsPresenter(MainActivityView activity) {
        super(activity);
    }
}
