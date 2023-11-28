package com.example.demoapplication.presenters.subpresenters.student;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.baseClasses.Metrics;
import com.example.demoapplication.baseClasses.User;
import com.example.demoapplication.fragments.NotificationItem;
import com.example.demoapplication.presenters.subpresenters.EventsPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Presenter class for managing events from a student's perspective.
 */
public class StudentEventsPresenter extends EventsPresenter {
    public List<Event> events = new ArrayList<>();

    /**
     * Constructor for the StudentEventsPresenter.
     *
     * @param view  The associated MainActivityView.
     * @param model The associated MainActivityModel.
     */
    public StudentEventsPresenter(MainActivityView view) {
        super(view);
    }

    /**
     * Retrieves events and updates the local list of events.
     */
    public void getEvents() {
        ArrayListenerCallback<Event> callback = new ArrayListenerCallback<Event>() {
            @Override
            public void execute(List<Event> eventList) {
                for (Event event : eventList) {
                    System.out.println(event);
                    if (!events.contains(event)) {
                        events.add(event);
                    }
                }
            }
        };
        model.createSubscription(Event.parentRef, this.listenerTracker, Event.class, callback);
    }

    /**
     * Retrieves event notifications based on the local list of events.
     *
     * @return List of NotificationItem containing event details.
     */
    public List<NotificationItem> getEventNotifications() {
        List<NotificationItem> notificationList = new ArrayList<>();
        for (Event event : events) {
            notificationList.add(new NotificationItem(event.getTitle(),
                    "Event", "Nov 20, 2023", event.getDescription()));
        }
        return notificationList;
    }

    /**
     * Allows a student to RSVP for an event.
     *
     * @param user  The user who is RSVPing.
     * @param event The event for which the RSVP is made.
     */
    public void rsvpForEvent(User user, Event event) {
        // Get the user ID
        String userId = user.getUid();
        String eventId = event.getEventId();

        // Add the user ID under the corresponding event ID node in eventAttendees
        model.createChildRef(Event.parentRef.child(eventId).child("eventAttendees"))
                .child(userId).setValue(true);

        // Add the event ID under the corresponding user ID node in userSubscriptions
        model.createChildRef(User.parentRef.child(userId).child("userSubscriptions"))
                .child(eventId).setValue(true);

        // Update the 'attendeeCount' in the database
        int newAttendeeCount = event.getAttendeeCount() + 1;
        model.setRef(Event.parentRef.child(event.getEventId()).child("attendeeCount"), newAttendeeCount);
    }

    /**
     * Allows a student to rate an event.
     *
     * @param user   The user who is rating the event.
     * @param event  The event to be rated.
     * @param rating The rating given by the student.
     */
    public void rateEvent(User user, Event event, int rating) {
        // Get the user ID
        String userId = user.getUid();
        String eventId = event.getEventId();
    }

    /**
     * Allows a student to comment on an event.
     *
     * @param user    The user who is commenting on the event.
     * @param event   The event to be commented on.
     * @param comment The comment provided by the student.
     */
    public void commentEvent(User user, Event event, String comment) {
        // Get the user ID
        String userId = user.getUid();
        String eventId = event.getEventId();

        // Add comment under feedbackList->[eventId]->comments. Key should be uid and the value the comment.
        model.createChildRef(Feedback.parentRef.child(eventId).child("comments").child(userId)).setValue(comment);
    }
}

