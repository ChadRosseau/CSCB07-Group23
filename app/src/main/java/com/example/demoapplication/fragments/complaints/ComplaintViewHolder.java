package com.example.demoapplication.fragments.complaints;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.R;
import com.example.demoapplication.fragments.events.StudentEventsFeedbackView;

public class ComplaintViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView authorTextView;
    public TextView timestampTextView;
    public TextView contentTextView;
    private boolean isExpanded;
    private boolean isRead;

    public ComplaintViewHolder(View complaintView) {
        super(complaintView);
        titleTextView = itemView.findViewById(R.id.titleTextView2);
        authorTextView = itemView.findViewById(R.id.typeTextView2);
        timestampTextView = itemView.findViewById(R.id.timestampTextView2);
        contentTextView = itemView.findViewById(R.id.contentTextView2);
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
