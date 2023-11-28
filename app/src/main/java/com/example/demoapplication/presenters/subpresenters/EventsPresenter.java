package com.example.demoapplication.presenters.subpresenters;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.fragments.events.EventsFragmentView;

import java.util.ArrayList;

public class EventsPresenter extends SubPresenter {

    public EventsPresenter(MainActivityView activity) {
        super(activity);
    }

    public void getEvents(EventsFragmentView view) {
        ArrayListenerCallback<Event> callback = new ArrayListenerCallback<Event>() {
            @Override
            public void execute(ArrayList<Event> eventList) {
                view.setEventList(eventList);
            }
        };
        model.createSubscription(Event.parentRef, this.listenerTracker, Event.class, callback);
    }
}
