package com.example.demoapplication.fragments.complaints;

import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;
import com.example.demoapplication.baseClasses.Announcement;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.fragments.announcements.AnnouncementViewHolder;
import com.example.demoapplication.helpers.Helper;

import java.util.ArrayList;
import com.example.demoapplication.fragments.complaints.ComplaintViewHolder;

public class ComplaintsAdapter extends RecyclerView.Adapter<ComplaintViewHolder>{
    private ArrayList<Complaint> complaintList;
    private static final int maxComplaintLines = 2;

    public ComplaintsAdapter(ArrayList<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    @NonNull
    @Override
    public ComplaintViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.complaint_item, parent, false);
        return new ComplaintViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComplaintViewHolder holder, int position) {
        Complaint complaint = complaintList.get(position);

        // Set text for each view
        holder.titleTextView.setText(complaint.getTitle());
        holder.timestampTextView.setText(Helper.formatTimestamp(complaint.getTimestamp()));
        holder.contentTextView.setText(complaint.getContent());
        holder.contentTextView.setMaxLines(holder.isExpanded() ? Integer.MAX_VALUE : maxComplaintLines);
        holder.contentTextView.setTypeface(null, holder.isRead() ? Typeface.NORMAL : Typeface.BOLD);

        // Set click listener for the entire item
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                onItemClickListener.onItemClick(complaint);
                holder.setExpanded(!holder.isExpanded());
                holder.contentTextView.setMaxLines(holder.isExpanded() ? Integer.MAX_VALUE : maxComplaintLines);

                holder.setRead(true);
                holder.contentTextView.setTypeface(null, holder.isRead() ? Typeface.NORMAL : Typeface.BOLD);
            }
        });
    }


    @Override
    public int getItemCount() {
        if (complaintList == null) return 0;
        return complaintList.size();
    }


}
