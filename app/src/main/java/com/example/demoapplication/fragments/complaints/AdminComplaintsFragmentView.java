package com.example.demoapplication.fragments.complaints;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.demoapplication.R;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.baseClasses.Complaint;
import com.example.demoapplication.fragments.complaints.ComplaintsAdapter;
import com.example.demoapplication.presenters.subpresenters.admin.AdminComplaintsPresenter;

import java.util.ArrayList;


public class AdminComplaintsFragmentView extends BaseFragment {
    private AdminComplaintsPresenter presenter;

    protected ArrayList<Complaint> complaintList;
    protected RecyclerView recyclerView;

    public AdminComplaintsFragmentView() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new AdminComplaintsPresenter(activity);

        // Initialize the complaint list using database
        presenter.getComplaints(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.admin_complaints, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewNotifications2);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setComplaintList(complaintList);
        return view;

    }

    // Setter method to update the complaint list
    public void setComplaintList(ArrayList<Complaint> complaintList) {
        this.complaintList = complaintList;
        // Notify the adapter that the data set has changed
        if (getView() != null) {
            ComplaintsAdapter adapter = new ComplaintsAdapter(complaintList);
            recyclerView.setAdapter(adapter);
        }
    }
}