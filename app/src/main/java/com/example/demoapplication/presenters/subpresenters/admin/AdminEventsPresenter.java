package com.example.demoapplication.presenters.subpresenters.admin;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.presenters.listeners.ItemListenerCallback;
import com.example.demoapplication.fragments.events.AdminEventsFeedbackView;
import com.example.demoapplication.fragments.events.FeedbackItem;
import com.example.demoapplication.presenters.subpresenters.EventsPresenter;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class AdminEventsPresenter extends EventsPresenter {
    Event currentEvent;
    Feedback currentEventFeedback;

    Map<String, String> currentCommentMap;
    Map<String, Integer> currentRatingMap;

    /**
     * Constructor for AdminEventsPresenter.
     *
     * @param activity  The associated MainActivityView.
     */
    public AdminEventsPresenter(MainActivityView activity) {
        super(activity);
    }

    /**
     * Creates a new event and adds it to the database.
     *
     * @param title   The title of the event.
     * @param description The description of the event.
     * @param maxAttendees The maximum attendees allowed for the event.
     * @param date The date of the event
     * @param location The location of the event
     */
    public void createEvent(String title, String description, int maxAttendees, Date date, String location) {
        // Generate a unique DB reference for new object.
        DatabaseReference target = model.createChildRef(Event.parentRef);
        // Retrieve key from new reference.
        String eventId = target.getKey();
        // Generate timestamp for event.
        // long date = Helper.createTimestamp();
        long unixDate = date.getTime() / 1000;
        // Create new event object using combination of parameters and generated data.
        Event newEvent = new Event(eventId, title, description, 0, maxAttendees, unixDate, location);
        // Set target DB ref to new object.
        model.setRef(target, newEvent);
        // Alert user
        activity.toast("Event created!");
    }

    /**
     * Retrieves an event and its associated feedback data. Used in AdminEventsFeedbackView.
     *
     * @param view The AdminEventsFeedbackView currently initialised by activity.
     * @param eventId The id of the event to retrieve information for.
     */
    public void getEventFeedback(AdminEventsFeedbackView view, String eventId) {
        // Define custom callback
        getEvent(view, eventId);
        getFeedback(view, eventId);
    }

    /**
     * Retrieves an event's data and updates the view.
     *
     * @param view The AdminEventsFeedbackView currently initialised by activity.
     * @param eventId The id of the event to retrieve information for.
     */
    private void getEvent(AdminEventsFeedbackView view, String eventId) {
        ItemListenerCallback<Event> callback = (event) -> {
            currentEvent = event;
            view.setEventInfo(event);
        };
        model.createSubscription(Event.parentRef.child(eventId), this.listenerTracker, Event.class, callback);
    }

    /**
     * Retrieves an event's feedback data and updates the view.
     *
     * @param view The AdminEventsFeedbackView currently initialised by activity.
     * @param eventId The id of the event to retrieve information for.
     */
    private void getFeedback(AdminEventsFeedbackView view, String eventId) {
        ItemListenerCallback<Feedback> feedbackCallback = (feedback) -> currentEventFeedback = feedback;
        ItemListenerCallback<Map<String, String>> commentCallback = (commentMap) -> {
            currentCommentMap = commentMap;
            view.setEventFeedbackInfo(calculateRatingAverage(), makeFeedbackList());
        };
        ItemListenerCallback<Map<String, Integer>> ratingCallback = (ratingMap) -> {
            currentRatingMap = ratingMap;
            view.setEventFeedbackInfo(calculateRatingAverage(), makeFeedbackList());
        };
        model.createSubscription(Feedback.parentRef.child(eventId), this.listenerTracker, Feedback.class, feedbackCallback);
        model.createSubscriptionOnMap(Feedback.parentRef.child(eventId).child("comments"), this.listenerTracker, String.class, commentCallback);
        model.createSubscriptionOnMap(Feedback.parentRef.child(eventId).child("ratings"), this.listenerTracker, Integer.class, ratingCallback);
    }

    // Calculates the event rating average using currentRatingMap.
    private float calculateRatingAverage() {
        if (currentRatingMap == null) return 0;
        int ratingSum = currentRatingMap.values().stream().reduce(0, Integer::sum);
        int ratingCount = currentRatingMap.size();
        return (float)ratingSum / ratingCount;
    }

    // Formats the separate comment and rating maps into a single class which can be fed into a RecyclerView.
    private ArrayList<FeedbackItem> makeFeedbackList() {
        ArrayList<FeedbackItem> feedbackItemList = new ArrayList<>();
        if (currentCommentMap == null) return feedbackItemList;
        for (Map.Entry<String,String> entry : currentCommentMap.entrySet()) {
            String uid = entry.getKey();
            String comment = entry.getValue();
            int rating = currentRatingMap != null && currentRatingMap.containsKey(uid) ? currentRatingMap.get(uid) : -1;
            feedbackItemList.add(new FeedbackItem(comment, rating));
        }
        return feedbackItemList;
    }
}
