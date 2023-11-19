package com.example.demoapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapterComplaints extends RecyclerView.Adapter<RecycleViewAdapterComplaints.ViewHolder>{
    private final Context context;
    private final ArrayList<Integer> integerArrayList;

    public RecycleViewAdapterComplaints(Context context, ArrayList<Integer> integerArrayList) {
        this.context = context;
        this.integerArrayList = integerArrayList;
    }

    @NonNull
    @Override
    public RecycleViewAdapterComplaints.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.complaint_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapterComplaints.ViewHolder holder, int position) {
        //show images if needed 
    }

    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        Button card_button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            card_button = itemView.findViewById(R.id.card_Button);
        }
    }
}
