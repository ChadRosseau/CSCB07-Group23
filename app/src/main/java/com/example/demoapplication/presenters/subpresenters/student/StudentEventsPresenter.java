package com.example.demoapplication.presenters.subpresenters.student;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.baseClasses.Metrics;
import com.example.demoapplication.presenters.subpresenters.EventsPresenter;
import com.google.firebase.database.DatabaseReference;

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
     */
    public StudentEventsPresenter(MainActivityView view) {
        super(view);
    }

    /**
     * Allows a student to RSVP for an event.
     *
     * @param eventId The id of the event for which the RSVP is made.
     */
    public void rsvpForEvent(String eventId) {
        // Get the user ID
        String userId = auth.getCurrentUserData().getUid();

        // Add the user ID under the corresponding event ID node in eventAttendees
        DatabaseReference eventAttendeesRef = model.getRootRef().child("events").child("eventAttendees").child(eventId);
        model.setRef(eventAttendeesRef.child(userId), true);

        // Add the event ID under the corresponding user ID node in userSubscriptions
        DatabaseReference userSubscriptionsRef = model.getRootRef().child("events").child("userSubscriptions").child(userId);
        model.setRef(userSubscriptionsRef.child(eventId), true);

        // Update the 'attendeeCount' in the database
        // TODO: Implement transaction.
    }

    /**
     * Allows a student to rate an event.
     *
     * @param eventId  The id of the event to be rated.
     * @param rating The rating given by the student.
     */
    public void rateEvent(String eventId, int rating) {
        // Get the user ID
        String userId = auth.getCurrentUserData().getUid();

        DatabaseReference target = Feedback.parentRef.child(eventId).child("ratings").child(userId);
        model.setRef(target, rating);

        // TODO: Implement transaction for ratingSum
        // TODO: Implement transaction for ratingCount
    }

    /**
     * Allows a student to comment on an event.
     *
     * @param eventId   The id of the event to be commented on.
     * @param comment The comment provided by the student.
     */
    public void commentEvent(String eventId, String comment) {
        // Get the user ID
        String userId = auth.getCurrentUserData().getUid();

        DatabaseReference target = Feedback.parentRef.child(eventId).child("comments").child(userId);
        model.setRef(target, comment);

        // TODO: Implement transaction for ratingSum
        // TODO: Implement transaction for ratingCount
    }
}

