package com.example.demoapplication.fragments.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.demoapplication.R;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.fragments.announcements.AdminAnnouncementsFragmentView;
import com.example.demoapplication.presenters.subpresenters.admin.AdminEventsPresenter;
import com.example.demoapplication.presenters.subpresenters.student.StudentEventsPresenter;
import com.google.android.material.textfield.TextInputEditText;


public class StudentEventsFeedbackView extends BaseFragment {

    private StudentEventsPresenter presenter;
    private static final String ARG_EVENT_ID = "eventId";

    private String eventId;
    private RatingBar ratingBar;
    private EditText contentEditText;
    private Button submitFeedbackButton;
    private Button cancelButton;


    public StudentEventsFeedbackView() {};

    public static StudentEventsFeedbackView newInstance(String eventId) {
        StudentEventsFeedbackView fragment = new StudentEventsFeedbackView();
        Bundle args = new Bundle();
        args.putString(ARG_EVENT_ID, eventId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        if (getArguments() == null) {
            activity.replaceFragment(new StudentEventsFeedbackView());
            return;
        }

        this.eventId = getArguments().getString(ARG_EVENT_ID);
        this.presenter = new StudentEventsPresenter(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.event_feedback, container, false);
        contentEditText = view.findViewById(R.id.inputFeedback);
        ratingBar = view.findViewById(R.id.studentEventFeedbackRatingBar);
        submitFeedbackButton = view.findViewById(R.id.submitFeedbackButton);
        cancelButton = view.findViewById(R.id.cancelButton);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        // Get data for user's current feedback from database.
        presenter.getCurrentFeedback(this, eventId);

        submitFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFeedback();
                showSuccessMessage("Feedback submitted successfully!");
                activity.replaceFragment(new StudentEventsFragmentView());
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.replaceFragment(new StudentEventsFragmentView());
            }
        });

    }

    public String getComment() {
        return contentEditText.getText().toString();
    }

    public int getRating() {
        return (int) ratingBar.getRating();
    }

    public void setComment(String text) {
        contentEditText.setText(text);
    }

    public void setRating(int rating) {
        ratingBar.setRating(rating);
    }

    private void submitFeedback() {
        presenter.commentEvent(eventId, getComment());
        presenter.rateEvent(eventId, getRating());
    }

    private void showSuccessMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
}