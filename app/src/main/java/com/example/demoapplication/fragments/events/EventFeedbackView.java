package com.example.demoapplication.fragments.events;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

import com.example.demoapplication.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventFeedbackView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventFeedbackView extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EventFeedbackView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EventFeedbackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static EventFeedbackView newInstance(String param1, String param2) {
        EventFeedbackView fragment = new EventFeedbackView();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //initiate rating bar and button
        final RatingBar feedbackRatingBar = (RatingBar) getView().findViewById(R.id.feedbackRatingBar);
        Button submitFeedbackButton = (Button) getView().findViewById(R.id.submitFeedbackButton);

        submitFeedbackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values and then displayed in a toast
                String totalStars = "Total Stars:: " + feedbackRatingBar.getNumStars();
                String rating = "Rating :: " + feedbackRatingBar.getRating();
                Toast.makeText(getActivity().getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.event_feedback, container, false);
    }
}