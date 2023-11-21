package com.example.demoapplication.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.demoapplication.R;
import com.example.demoapplication.MainActivityView;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class CreateNotificationView extends Fragment {

    private Spinner typeSpinner;
    private TextInputEditText titleText;
    private TextInputEditText contentText;
    public CreateNotificationView() {
        // Required empty public constructor
    }

    // public static CreateNotificationView newInstance(String param1, String param2) {
    //     CreateNotificationView fragment = new CreateNotificationView();
    //     Bundle args = new Bundle();
    //     args.putString(ARG_PARAM1, param1);
    //     args.putString(ARG_PARAM2, param2);
    //     fragment.setArguments(args);
    //     return fragment;
    // }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.create_notification, container, false);
        typeSpinner = view.findViewById(R.id.type_spinner);
        titleText = view.findViewById(R.id.titleText);
        contentText = view.findViewById(R.id.contentText);
        Button submit = view.findViewById(R.id.submitButton);
        Button cancel = view.findViewById(R.id.cancelButton);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                submitNotification(v);
                ((MainActivityView)requireActivity())
                            .replaceFragment(new AdminNotificationsFragmentView());
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivityView)requireActivity())
                            .replaceFragment(new AdminNotificationsFragmentView());
            }
        });
        return view;
    }

    private void submitNotification(View view){
        String author = "Jean";
        String title = titleText.getText().toString();
        String type = typeSpinner.getSelectedItem().toString();
        String content = contentText.getText().toString();
        ((MainActivityView)requireActivity()).presenter.admin.announcements
                .createAnnouncement(title, type, content, author);
    }
}