package com.example.demoapplication.fragments.events;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;


import com.example.demoapplication.R;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.admin.AdminAnnouncementsPresenter;
import com.example.demoapplication.presenters.subpresenters.admin.AdminEventsPresenter;

public class CreateEventFragmentView extends BaseFragment {
    private AdminEventsPresenter presenter;
    private AdminAnnouncementsPresenter announcementsPresenter;
    private EditText titleEditText, descriptionEditText, capacityEditText, locationEditText;
    private DatePicker datePicker;
    private Button submitEventButton;

    public CreateEventFragmentView() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.presenter = new AdminEventsPresenter(activity);
        this.announcementsPresenter = new AdminAnnouncementsPresenter(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.create_event, container, false);

        // Initialize UI components
        titleEditText = view.findViewById(R.id.editTextText3);
        descriptionEditText = view.findViewById(R.id.editTextText4);
        capacityEditText = view.findViewById(R.id.editTextText5);
        locationEditText = view.findViewById(R.id.editTextText6);
        datePicker = view.findViewById(R.id.datePicker);
        submitEventButton = view.findViewById(R.id.submitEventButton);

        // Handle submit event button click
        submitEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitEvent();
            }
        });

        return view;
    }

    // Get selected date from DatePicker
    int day = datePicker.getDayOfMonth();
    int month = datePicker.getMonth();
    int year = datePicker.getYear();

    // Convert date to timestamp
    long timestamp = convertDateToTimestamp(day, month, year);

// ...

    // Helper method to convert date to timestamp
    private long convertDateToTimestamp(int day, int month, int year) {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);

        // Set specific time components to default of the midnight
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTimeInMillis();
    }


    // Handle event submission
    private void submitEvent() {
        // Get input values
        String title = titleEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        int capacity = Integer.parseInt(capacityEditText.getText().toString().trim());
        String location = locationEditText.getText().toString().trim();

        // Get selected date from DatePicker
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth() + 1; // Months are 0-indexed
        int year = datePicker.getYear();

        // Convert date to timestamp or handle as needed
        // Example: long timestamp = convertDateToTimestamp(day, month, year);

        /*
         private void submitAnnouncement() {
        String title = titleText.getText().toString();
        String type = typeSpinner.getSelectedItem().toString();
        String content = contentText.getText().toString();
        presenter.createAnnouncement(title, type, content);
    }
         */
        // Create an Event object and pass it to the presenter
        //Event(String eventId, String title, String description, int attendeeCount, int maxAttendees, long date)
        presenter.createEvent(title, description, 0, capacity, timestamp);
    }
}
