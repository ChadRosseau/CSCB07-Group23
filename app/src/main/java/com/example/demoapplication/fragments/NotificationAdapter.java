package com.example.demoapplication.fragments;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<NotificationItem> notificationList;
    private OnItemClickListener onItemClickListener;
    private static final int maxNotificationLines = 2;

    public NotificationAdapter(List<NotificationItem> notificationList, OnItemClickListener onItemClickListener) {
        this.notificationList = notificationList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.notification_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NotificationItem notification = notificationList.get(position);

        // Set text for each view
        holder.titleTextView.setText(notification.getTitle());
        holder.typeTextView.setText(notification.getType());
        holder.timestampTextView.setText(notification.getTimestamp());
        holder.contentTextView.setText(notification.getContent());
        holder.contentTextView.setMaxLines(notification.isExpanded() ? Integer.MAX_VALUE : maxNotificationLines);
        holder.contentTextView.setTypeface(null, notification.isRead() ? Typeface.NORMAL : Typeface.BOLD);

        // Set click listener for the entire item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onItemClickListener.onItemClick(notification);
                notification.setExpanded(!notification.isExpanded());
                holder.contentTextView.setMaxLines(notification.isExpanded() ? Integer.MAX_VALUE : maxNotificationLines);

                notification.setRead(true);
                holder.contentTextView.setTypeface(null, notification.isRead() ? Typeface.NORMAL : Typeface.BOLD);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (notificationList == null) return 0;
        return notificationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView titleTextView;
        public TextView typeTextView;
        public TextView timestampTextView;
        public TextView contentTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            typeTextView = itemView.findViewById(R.id.typeTextView);
            timestampTextView = itemView.findViewById(R.id.timestampTextView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(NotificationItem notificationItem);
    }
}

