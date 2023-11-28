package com.example.demoapplication.fragments.announcements;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.helpers.Helper;

import java.util.ArrayList;

public class AnnouncementsAdapter extends RecyclerView.Adapter<AnnouncementViewHolder> {

    private ArrayList<Announcement> announcementList;
//    private OnItemClickListener onItemClickListener;
    private static final int maxNotificationLines = 2;

    public AnnouncementsAdapter(ArrayList<Announcement> announcementList) {
        this.announcementList = announcementList;
    }

    @NonNull
    @Override
    public AnnouncementViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.announcement_item, parent, false);
        return new AnnouncementViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnnouncementViewHolder holder, int position) {
        Announcement announcement = announcementList.get(position);

        // Set text for each view
        holder.titleTextView.setText(announcement.getTitle());
        holder.typeTextView.setText(announcement.getType());
        holder.timestampTextView.setText(Helper.formatTimestamp(announcement.getTimestamp()));
        holder.contentTextView.setText(announcement.getContent());
        holder.contentTextView.setMaxLines(holder.isExpanded() ? Integer.MAX_VALUE : maxNotificationLines);
        holder.contentTextView.setTypeface(null, holder.isRead() ? Typeface.NORMAL : Typeface.BOLD);

        // Set click listener for the entire item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onItemClickListener.onItemClick(notification);
                holder.setExpanded(!holder.isExpanded());
                holder.contentTextView.setMaxLines(holder.isExpanded() ? Integer.MAX_VALUE : maxNotificationLines);

                holder.setRead(true);
                holder.contentTextView.setTypeface(null, holder.isRead() ? Typeface.NORMAL : Typeface.BOLD);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (announcementList == null) return 0;
        return announcementList.size();
    }
}

