package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.presenters.listeners.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.fragments.events.StudentEventsFragmentView;

import java.util.ArrayList;
import java.util.Collections;

public class EventsPresenter extends SubPresenter {

    public EventsPresenter(MainActivityView activity) {
        super(activity);
    }

    public void getEvents(StudentEventsFragmentView view) {
        ArrayListenerCallback<Event> callback = new ArrayListenerCallback<Event>() {
            @Override
            public void execute(ArrayList<Event> eventList) {
                Collections.reverse(eventList);
                view.setEventList(eventList);
            }
        };
        model.createSubscription(Event.parentRef, this.listenerTracker, Event.class, callback);
    }
}
