package com.example.demoapplication.fragments.complaints;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;

public class ComplaintViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView timestampTextView;
    public TextView contentTextView;
    private boolean isExpanded;
    private boolean isRead;

    public ComplaintViewHolder(View complaintView) {
        super(complaintView);
        titleTextView = itemView.findViewById(R.id.titleTextViewComplaints);
        timestampTextView = itemView.findViewById(R.id.timestampTextViewComplaints);
        contentTextView = itemView.findViewById(R.id.contentTextViewComplaints);
        isExpanded = false;
        isRead = false;
    }

    public boolean isExpanded() {
        return isExpanded;
    }

    public void setExpanded(boolean expanded) {
        isExpanded = expanded;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}