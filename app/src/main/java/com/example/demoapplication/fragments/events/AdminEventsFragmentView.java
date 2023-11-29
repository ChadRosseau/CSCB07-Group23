package com.example.demoapplication.fragments.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.demoapplication.R;

public class AdminEventsFragmentView extends EventsFragmentView{

    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.events_admin_list, parent, false);
        return new EventViewHolder(activity, eventView);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.eventsAdminRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        setEventList(eventItemList);
    }
}

