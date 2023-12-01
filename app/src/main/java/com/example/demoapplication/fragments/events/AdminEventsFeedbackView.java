package com.example.demoapplication.fragments.events;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.demoapplication.R;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.admin.AdminEventsPresenter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AdminEventsFeedbackView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AdminEventsFeedbackView extends BaseFragment {

    AdminEventsPresenter presenter;

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
        TextView test = view.findViewById(R.id.feedbackTest);
        test.setText(eventId);
    }

}