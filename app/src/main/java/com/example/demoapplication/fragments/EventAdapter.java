package com.example.demoapplication.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;

import java.util.ArrayList;
public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {
    private ArrayList<Event> emptylist;

    public EventAdapter(ArrayList<Event> emptylist) {
        this.emptylist = emptylist;
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list, parent, false);
        return new MyViewHolder(eventView);
    }

    // This method returns the total
    // number of items in the data set
    @Override
    public int getItemCount() {
        return emptylist.size();
    }

    // This method binds the data to the ViewHolder object
    // for each item in the RecyclerView
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String participants = "Max Participants: ";
        String remain = "Remaining Seats: ";
        Event currentEmp = emptylist.get(position);
        holder.name.setText(currentEmp.getName());
        holder.date.setText(currentEmp.getDate());
        holder.maxParticipants.setText(participants + currentEmp.getMaxParticipants());
        holder.remaining.setText(remain +currentEmp.getRemaining());
        holder.description.setText(currentEmp.getDescription());
    }

    // This class defines the ViewHolder object for each item in the RecyclerView
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView date;
        private TextView maxParticipants;
        private TextView remaining;
        private TextView description;

        public MyViewHolder(View eventView) {
            super(eventView);
            name = eventView.findViewById(R.id.tvName);
            date = eventView.findViewById(R.id.tvDate);
            maxParticipants = eventView.findViewById(R.id.tvParticipants);
            remaining = eventView.findViewById(R.id.tvRemaining);
            description = eventView.findViewById(R.id.tvDescription);
        }
    }
}
