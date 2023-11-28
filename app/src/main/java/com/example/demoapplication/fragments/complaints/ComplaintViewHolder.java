package com.example.demoapplication.fragments.complaints;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;
import com.example.demoapplication.fragments.events.StudentEventsFeedbackView;

public class ComplaintViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView date;
    TextView maxAttendees;
    TextView remaining;
    TextView description;

    public ComplaintViewHolder(View complaintView) {
        super(complaintView);
//        title = complaintView.findViewById(R.id.complaintTitle);
//        content = complaintView.findViewById(R.id.complaintContent);
    }
}
