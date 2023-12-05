package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.listeners.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.fragments.events.StudentEventsFragmentView;

import java.util.ArrayList;
import java.util.Collections;

public class EventsPresenter extends SubPresenter {
    /**
     * Constructor for EventsPresenter.
     *
     * @param activity  The associated MainActivityView.
     */
    public EventsPresenter(MainActivityView activity) {
        super(activity);
    }

    public void getEvents(StudentEventsFragmentView view) {
        ArrayListenerCallback<Event> callback = (eventList) -> {
            eventList.sort((event1, event2) -> event1.getDate() <= event2.getDate() ? -1 : 1);
            view.setEventList(eventList);
        };
        model.createSubscriptionOnArray(Event.parentRef, this.listenerTracker, Event.class, callback);
    }
}
