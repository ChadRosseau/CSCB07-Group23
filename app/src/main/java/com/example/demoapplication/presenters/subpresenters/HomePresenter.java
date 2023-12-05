package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.fragments.HomeFragmentView;
import com.example.demoapplication.presenters.listeners.ArrayListenerCallback;

import java.util.ArrayList;
import java.util.Collections;

public class HomePresenter extends SubPresenter {

    public HomePresenter(MainActivityView view) {
        super(view);
    }

    public void getAnnouncements(HomeFragmentView view) {
        ArrayListenerCallback<Announcement> callback = (announcementList) -> {
            Collections.reverse(announcementList);
            view.setAnnouncementList(announcementList);
        };
        model.createSubscriptionOnArray(Announcement.parentRef, this.listenerTracker, Announcement.class, callback);
    }

    public void getUpcomingEvent(HomeFragmentView view) {
        ArrayListenerCallback<Event> callback = (eventList) -> {
            Event upcomingEvent = eventList.get(0);
            view.setEventContent(upcomingEvent);
        };
        model.createSubscriptionOnArray(Event.parentRef.orderByChild("date").limitToFirst(1), this.listenerTracker, Event.class, callback);
    }


}
