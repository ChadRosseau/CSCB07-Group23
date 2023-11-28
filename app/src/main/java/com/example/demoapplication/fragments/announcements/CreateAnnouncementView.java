package com.example.demoapplication.fragments.announcements;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.example.demoapplication.R;
import com.example.demoapplication.MainActivityView;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.admin.AdminAnnouncementsPresenter;
import com.google.android.material.textfield.TextInputEditText;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class CreateAnnouncementView extends BaseFragment {
    private AdminAnnouncementsPresenter presenter;

    private Spinner typeSpinner;
    private TextInputEditText titleText;
    private TextInputEditText contentText;
    public CreateAnnouncementView() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new AdminAnnouncementsPresenter(activity);
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
                submitAnnouncement(v);
                ((MainActivityView)requireActivity())
                            .replaceFragment(new AdminAnnouncementsFragmentView());
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ((MainActivityView)requireActivity())
                            .replaceFragment(new AdminAnnouncementsFragmentView());
            }
        });
        return view;
    }

    private void submitAnnouncement(View view){
        String title = titleText.getText().toString();
        String type = typeSpinner.getSelectedItem().toString();
        String content = contentText.getText().toString();
        presenter.createAnnouncement(title, type, content);
    }
}