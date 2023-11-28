package com.example.demoapplication.fragments.events;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.demoapplication.MainActivityModel;
import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Event;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.student.StudentEventsPresenter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventsFragmentView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragmentView extends BaseFragment {

    public EventsFragmentView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new StudentEventsPresenter(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.event_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view,
                              Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        // getting the employeelist
        ArrayList<Event> eventArrayList = EventConstants.getEventData();

        // Assign employeelist to ItemAdapter
        EventAdapter eventAdapter = new EventAdapter(activity, eventArrayList);

        // Set the LayoutManager that
        // this RecyclerView will use.
        RecyclerView recyclerView
                = view.findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(getContext()));

        // adapter instance is set to the
        // recyclerview to inflate the items.
        recyclerView.setAdapter(eventAdapter);
    }
}