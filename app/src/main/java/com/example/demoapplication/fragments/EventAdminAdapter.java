package com.example.demoapplication.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;

import java.util.ArrayList;
public class EventAdminAdapter extends RecyclerView.Adapter<EventAdminAdapter.MyViewHolder> {
    private ArrayList<Event> emptylist;

    public EventAdminAdapter(ArrayList<Event> emptylist) {
        this.emptylist = emptylist;
    }

    // This method creates a new ViewHolder object for each item in the RecyclerView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the layout for each item and return a new ViewHolder object
        View eventView = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_admin_list, parent, false);
        return new MyViewHolder(eventView);
    }

    // do i really need new adapter when the info's basically the same but one button is different?
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

        private Button feedbackButton;

        public MyViewHolder(View eventView) {
            super(eventView);
            name = eventView.findViewById(R.id.tvName);
            date = eventView.findViewById(R.id.tvDate);
            maxParticipants = eventView.findViewById(R.id.tvParticipants);
            remaining = eventView.findViewById(R.id.tvRemaining);
            description = eventView.findViewById(R.id.tvDescription);
            feedbackButton = eventView.findViewById(R.id.feedbackButton);
//            feedbackButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    showStudentFeedback();
//                }
//            });
        }
//        private void showStudentFeedback() {
//            if (getActivity() instanceof MainActivityView) {
//                EventFeedbackView createFeedbackView = new EventFeedbackView();
//                ((MainActivityView) getActivity()).replaceFragment(createFeedbackView, R.anim.transition_up);
//            }
//        }
    }

}
