package com.example.demoapplication.presenters.subpresenters.admin;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.baseClasses.ItemListenerCallback;
import com.example.demoapplication.fragments.events.AdminEventsFeedbackView;
import com.example.demoapplication.presenters.subpresenters.EventsPresenter;
import com.google.firebase.database.DatabaseReference;

import java.util.Date;

public class AdminEventsPresenter extends EventsPresenter {
    Event currentEvent;
    Feedback currentEventFeedback;


    public AdminEventsPresenter(MainActivityView view) {
        super(view);
    }

    public void createEvent(String title, String description, int maxAttendees, Date date) {
        // Generate a unique DB reference for new object.
        DatabaseReference target = model.createChildRef(Event.parentRef);
        // Retrieve key from new reference.
        String eventId = target.getKey();
        // Generate timestamp for event.
        // long date = Helper.createTimestamp();
        long unixDate = date.getTime() / 1000;
        // Create new event object using combination of parameters and generated data.
        Event newEvent = new Event(eventId, title, description, 0, maxAttendees, unixDate);
        // Set target DB ref to new object.
        model.setRef(target, newEvent);
    }

    public void getEventFeedback(AdminEventsFeedbackView view, String eventId) {
        // Define custom callback
        getEvent(view, eventId);
        getFeedback(view, eventId);
    }

    private void getEvent(AdminEventsFeedbackView view, String eventId) {
        ItemListenerCallback<Event> callback = new ItemListenerCallback<Event>() {
            public void execute(Event event) {
                currentEvent = event;
                updateFeedbackView(view);
            }
        };
        model.createSubscriptionOnChild(Event.parentRef, eventId, this.listenerTracker, Event.class, callback);
    }

    private void getFeedback(AdminEventsFeedbackView view, String eventId) {
        ItemListenerCallback<Feedback> callback = new ItemListenerCallback<Feedback>() {
            public void execute(Feedback feedback) {
                currentEventFeedback = feedback;
                updateFeedbackView(view);
            }
        };
        model.createSubscriptionOnChild(Feedback.parentRef, eventId, this.listenerTracker, Feedback.class, callback);
    }

    private void updateFeedbackView(AdminEventsFeedbackView view) {
        if (currentEvent == null || currentEventFeedback == null) return;

    }
}
