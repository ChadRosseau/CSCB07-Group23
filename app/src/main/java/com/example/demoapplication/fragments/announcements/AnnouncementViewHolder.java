package com.example.demoapplication.fragments.announcements;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;

public class AnnouncementViewHolder extends RecyclerView.ViewHolder {
    public TextView titleTextView;
    public TextView typeTextView;
    public TextView timestampTextView;
    public TextView contentTextView;
    private boolean isExpanded;
    private boolean isRead;

    public AnnouncementViewHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.titleTextView);
        typeTextView = itemView.findViewById(R.id.typeTextView);
        timestampTextView = itemView.findViewById(R.id.timestampTextView);
        contentTextView = itemView.findViewById(R.id.contentTextView);
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