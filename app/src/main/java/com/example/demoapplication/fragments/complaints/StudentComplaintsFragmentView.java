package com.example.demoapplication.fragments.complaints;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demoapplication.R;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.student.StudentComplaintsPresenter;

public class StudentComplaintsFragmentView extends BaseFragment {
    private StudentComplaintsPresenter presenter;
    public StudentComplaintsFragmentView() {}

    EditText titleText;
    EditText contentText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new StudentComplaintsPresenter(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.student_complaints, container, false);
        titleText = view.findViewById(R.id.complaintTitleText);
        contentText = view.findViewById(R.id.complaintContentText);
        Button submit = view.findViewById(R.id.complaintsSubmitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                createComplaint();
            }
        });
        return view;
    }

    private void createComplaint() {
        String title = titleText.getText().toString();
        String content = contentText.getText().toString();
        presenter.createComplaint(this, title, content);
    }

    public void handleCreateComplaintSuccess() {
        titleText.setText("");
        contentText.setText("");
    }

    public void handleCreateComplaintFailure(String text) {
        activity.toast(text);
    }
}