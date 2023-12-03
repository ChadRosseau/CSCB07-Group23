package com.example.demoapplication.presenters.subpresenters.student;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.ArrayListenerCallback;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.baseClasses.ItemListenerCallback;
import com.example.demoapplication.baseClasses.Metrics;
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
                    //dunno what to do if we successfully rsvped
                    System.out.println("Successful RSVP");
                }
                else{
                    System.out.println("Failed RSVP");
                }

            }
        });
    }
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
                    currentData.setValue(currentAttendeeCount - 1);
                }

                return Transaction.success(currentData);
            }

            @Override
            public void onComplete(@Nullable DatabaseError error, boolean committed, @Nullable DataSnapshot currentData) {
                if (committed) {
                    //dunno what to do if we successfully rsvped
                    System.out.println("Successful unRSVP");
                }
                else{
                    System.out.println("Failed unRSVP");
                }

            }
        });
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
    public boolean isRSVPd (String eventId){
        if (rsvps == null) return false;
        return Boolean.TRUE.equals(rsvps.get(eventId));
    }
}

