package com.example.demoapplication.fragments.events;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.EventsPresenter;
import com.example.demoapplication.presenters.subpresenters.student.StudentEventsPresenter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StudentEventsFragmentView extends BaseFragment {
    private EventsPresenter presenter;
    protected RecyclerView recyclerView;
    protected ArrayList<Event> eventItemList;

    public StudentEventsFragmentView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new StudentEventsPresenter(activity);

        // Initialize the event list using database
        presenter.getEvents(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.event_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setEventList(eventItemList);
    }

    // Setter method to update the event list
    public void setEventList(ArrayList<Event> eventItemList) {
        this.eventItemList = eventItemList;
        // Notify the adapter that the data set has changed
        if (getView() != null) {
            EventsAdapter eventsAdapter = new EventsAdapter(activity, eventItemList);
            recyclerView.setAdapter(eventsAdapter);
        }
    }
}