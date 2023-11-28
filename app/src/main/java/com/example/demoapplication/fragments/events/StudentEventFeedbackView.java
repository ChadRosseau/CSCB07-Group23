package com.example.demoapplication.fragments.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.demoapplication.R;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.student.StudentEventsPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentEventFeedbackView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentEventFeedbackView extends BaseFragment {
    private StudentEventsPresenter presenter;

    RatingBar feedbackRatingBar;
    Button submitFeedbackButton;

    public StudentEventFeedbackView() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initiate rating bar and button
        this.presenter = new StudentEventsPresenter(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.event_feedback, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        feedbackRatingBar = view.findViewById(R.id.feedbackRatingBar);
        submitFeedbackButton = view.findViewById(R.id.submitFeedbackButton);
        submitFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFeedback();
            }
        });

    }

    private void submitFeedback() {
//        String totalStars = "Total Stars:: " + feedbackRatingBar.getNumStars();
//        String rating = "Rating :: " + feedbackRatingBar.getRating();
//        Toast.makeText(getActivity().getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
    }
}