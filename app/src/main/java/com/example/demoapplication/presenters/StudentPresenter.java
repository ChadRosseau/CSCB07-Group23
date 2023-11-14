package com.example.demoapplication.presenters;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.subpresenters.student.StudentAnnouncementsPresenter;
import com.example.demoapplication.presenters.subpresenters.student.StudentComplaintsPresenter;
import com.example.demoapplication.presenters.subpresenters.student.StudentEventsPresenter;

public class StudentPresenter extends UserPresenter {
    StudentAnnouncementsPresenter announcements;
    StudentComplaintsPresenter complaints;
    StudentEventsPresenter events;
    public StudentPresenter(MainActivityView view, MainActivityModel model) {
        super(view, model);
        this.announcements = new StudentAnnouncementsPresenter(view, model);
        this.complaints = new StudentComplaintsPresenter(view, model);
        this.events = new StudentEventsPresenter(view, model);
    }
}
