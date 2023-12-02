package com.example.demoapplication.fragments.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.baseClasses.Feedback;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.fragments.announcements.AnnouncementsAdapter;
import com.example.demoapplication.helpers.Helper;
import com.example.demoapplication.presenters.subpresenters.admin.AdminEventsPresenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdminEventsFeedbackView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdminEventsFeedbackView extends BaseFragment {

    AdminEventsPresenter presenter;
    TextView title;
    TextView description;
    TextView date;
    TextView location;
    TextView attendees;
    TextView ratingText;
    RatingBar ratingStars;
    RecyclerView recyclerView;
    Button backButton;

    List<FeedbackItem> feedbackItemList;


    private static final String ARG_EVENT_ID = "eventId";
    // TODO: Rename and change types of parameters
    private String eventId;

    public AdminEventsFeedbackView() {}
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param eventId The ID of the event.
     * @return A new instance of fragment EventViewHolder.
     */
    // TODO: Rename and change types and number of parameters
    public static AdminEventsFeedbackView newInstance(String eventId) {
        AdminEventsFeedbackView fragment = new AdminEventsFeedbackView();
        Bundle args = new Bundle();
        args.putString(ARG_EVENT_ID, eventId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() == null) {
            activity.replaceFragment(new AdminEventsFragmentView());
            return;
        }
        this.eventId = getArguments().getString(ARG_EVENT_ID);
        this.presenter = new AdminEventsPresenter(activity);
        presenter.getEventFeedback(this, eventId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.events_admin_feedback, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.adminEventsFeedbackTitle);
        description = view.findViewById(R.id.adminEventsFeedbackDescription);
        date = view.findViewById(R.id.adminEventsFeedbackDate);
        location = view.findViewById(R.id.adminEventsFeedbackLocation);
        attendees = view.findViewById(R.id.adminEventsFeedbackAttendees);
        ratingText = view.findViewById(R.id.eventFeedbackAverageRatingText);
        ratingStars = view.findViewById(R.id.adminEventsFeedbackAverageRatingStars);
        backButton = view.findViewById(R.id.adminEventsFeedbackBackButton);
        recyclerView = view.findViewById(R.id.adminEventsFeedbackRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.replaceFragment(new AdminEventsFragmentView());
            }
        });
    }

    public void setEventInfo(Event event) {
        title.setText(event.getTitle());
        description.setText(event.getDescription());
        date.setText(Helper.formatTimestamp(event.getDate()));
        location.setText(event.getLocation());
        attendees.setText(String.format(getString(R.string.feedbackAttendeesCount), event.getAttendeeCount(), event.getMaxAttendees()));
    }

    public void setEventFeedbackInfo(float feedbackAverage) {
        ratingText.setText(String.format("%.2f/5", feedbackAverage));
        ratingStars.setRating(feedbackAverage);
    }

    public void setEventFeedbackItemsInfo(ArrayList<FeedbackItem> feedbackItemList) {
        if (getView() != null) {
            FeedbackAdapter adapter = new FeedbackAdapter(feedbackItemList);
            recyclerView.setAdapter(adapter);
        }
    }

}