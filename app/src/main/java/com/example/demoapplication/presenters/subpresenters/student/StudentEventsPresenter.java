package com.example.demoapplication.presenters.subpresenters.student;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.fragments.events.StudentEventsFeedbackView;
import com.example.demoapplication.presenters.listeners.ItemListenerCallback;
import com.example.demoapplication.baseClasses.Subscription;
import com.example.demoapplication.presenters.subpresenters.EventsPresenter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Presenter class for managing events from a student's perspective.
 */
public class StudentEventsPresenter extends EventsPresenter {
    public List<Event> events = new ArrayList<>();
    public Map<String, Boolean> rsvps = new HashMap<>();

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

//        // Add the user ID under the corresponding event ID node in eventAttendees
//        DatabaseReference eventAttendeesRef = model.getRootRef().child("events").child("eventAttendees").child(eventId);
//        model.setRef(eventAttendeesRef.child(userId), true);

        // Add the event ID under the corresponding user ID node in rsvps
        DatabaseReference rsvpsRef = Subscription.parentRef.child(userId);
        model.setRef(rsvpsRef.child(eventId), true);

        // Update the 'attendeeCount' in the database via a transaction.
        DatabaseReference attendeeCountRef = model.getRootRef().child("events").child("eventList").child(eventId).child("attendeeCount");
        attendeeCountRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData currentData) {
                // Better to use Integer class in case the data is somehow null
                Integer currentAttendeeCount = currentData.getValue(Integer.class);

                if (currentAttendeeCount == null){
                    currentData.setValue(1);
                }
                else {
                    currentData.setValue(currentAttendeeCount + 1);
                }

                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError error, boolean committed, @Nullable DataSnapshot currentData) {
                if (committed) {
                    activity.toast("Successfully RSVPed!");
                }
                else {
                    activity.toast("RSVP Failed");
                }
            }
        });
    }
    /**
     * Allows a student to undo a RSVP for an event.
     *
     * @param eventId The id of the event for which the RSVP is made.
     */
    public void undoRSVP(String eventId){
        // Get the user ID
        String userId = auth.getCurrentUserData().getUid();

//        // Add the user ID under the corresponding event ID node in eventAttendees
//        DatabaseReference eventAttendeesRef = model.getRootRef().child("events").child("eventAttendees").child(eventId);
//        model.setRef(eventAttendeesRef.child(userId), true);

        // Add the event ID under the corresponding user ID node in rsvps
        DatabaseReference rsvpsRef = Subscription.parentRef.child(userId);
        model.deleteRef(rsvpsRef.child(eventId));

        // Update the 'attendeeCount' in the database
        // TODO: Implement transaction.
        DatabaseReference attendeeCountRef = model.getRootRef().child("events").child("eventList").child(eventId).child("attendeeCount");
        attendeeCountRef.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData currentData) {
                // Better to use Integer class in case the data is somehow null
                Integer currentAttendeeCount = currentData.getValue(Integer.class);

                if (currentAttendeeCount == null){
                    currentData.setValue(0);
                }
                else {
                    currentData.setValue(Math.max(currentAttendeeCount - 1, 0));
                }

                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError error, boolean committed, @Nullable DataSnapshot currentData) {
                if (committed) {
                    activity.toast("Successfully unRSVPed!");
                }
                else {
                    activity.toast("unRSVP Failed");
                }
            }
        });
    }

    /**
     * Listener function to get RSVPs of current user.
     *
     */
    public void getRSVP(){
        String userId = auth.getCurrentUserData().getUid();
        ItemListenerCallback<Map<String, Boolean>> rsvpCallback = new ItemListenerCallback<Map<String, Boolean>>() {
            @Override
            public void execute(Map<String, Boolean> rsvpMap) {

                rsvps = rsvpMap;
            }
        };
        model.createSubscriptionOnMap(Subscription.parentRef.child(userId), this.listenerTracker, Boolean.class, rsvpCallback);
    }

    /**
     * Enables the student to view in real time what events they have and haven't RSVPed for.
     *
     */
    public boolean isRSVPd (String eventId){
        if (rsvps == null || !rsvps.containsKey(eventId)) return false;
        return Boolean.TRUE.equals(rsvps.get(eventId));
    }

    /**
     * Allows a student to comment on an event.
     *
     * @param eventId The id of the event to be commented on.
     * @param comment The comment provided by the student.
     */
    public void commentEvent(String eventId, String comment) {
        // Don't submit empty comments
        if (comment.isEmpty()) return;
        // Get the user ID
        String userId = auth.getCurrentUserData().getUid();
        DatabaseReference target = Feedback.parentRef.child(eventId).child("comments").child(userId);
        model.setRef(target, comment);
    }

    /**
     * Allows a student to rate an event.
     *
     * @param eventId  The id of the event to be rated.
     * @param rating The rating given by the student.
     */
    public void rateEvent(String eventId, int rating) {
        // Don't submit empty ratings.
        if (rating == 0) return;

        // Get the user ID
        String userId = auth.getCurrentUserData().getUid();

        DatabaseReference target = Feedback.parentRef.child(eventId).child("ratings").child(userId);
        model.setRef(target, rating);

        DatabaseReference ratingSumTarget = Feedback.parentRef.child(eventId).child("ratingSum");
        DatabaseReference ratingCountTarget = Feedback.parentRef.child(eventId).child("ratingCount");

        // Transaction for ratingSum
        ratingSumTarget.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData currentData) {
                // Better to use Integer class in case the data is somehow null
                Integer currentRatingSum = currentData.getValue(Integer.class);

                if (currentRatingSum == null){
                    currentData.setValue(rating);
                }
                else {
                    currentData.setValue(currentRatingSum + rating);
                }

                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError error, boolean committed, @Nullable DataSnapshot currentData) {}
        });

        // Transaction for ratingCount
        ratingCountTarget.runTransaction(new Transaction.Handler() {
            @NonNull
            @Override
            public Transaction.Result doTransaction(@NonNull MutableData currentData) {
                // Better to use Integer class in case the data is somehow null
                Integer currentRatingCount = currentData.getValue(Integer.class);

                if (currentRatingCount == null){
                    currentData.setValue(1);
                }
                else {
                    currentData.setValue(currentRatingCount + 1);
                }

                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError error, boolean committed, @Nullable DataSnapshot currentData) {}
        });
    }

    public void getCurrentFeedback(StudentEventsFeedbackView view, String eventId) {
        String userId = auth.getCurrentUserData().getUid();
        ItemListenerCallback<String> commentCallback = new ItemListenerCallback<String>() {
            @Override
            public void execute(String comment) {
                // If comment box is empty, set it to value from database.
                if (view.getComment().isEmpty()) view.setComment(comment);
            }
        };
        ItemListenerCallback<Integer> ratingCallback = new ItemListenerCallback<Integer>() {
            @Override
            public void execute(Integer rating) {
                // If rating is empty, set it to value from database.
                if (view.getRating() == 0) view.setRating(rating);
            }
        };
        model.createSubscription(Feedback.parentRef.child(eventId).child("comments").child(userId), this.listenerTracker, String.class, commentCallback);
        model.createSubscription(Feedback.parentRef.child(eventId).child("ratings").child(userId), this.listenerTracker, Integer.class, ratingCallback);
    }
}

