package com.example.demoapplication.fragments.events;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.demoapplication.R;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.presenters.subpresenters.admin.AdminAnnouncementsPresenter;
import com.example.demoapplication.presenters.subpresenters.admin.AdminEventsPresenter;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Calendar;
import java.util.Date;

public class CreateEventFragmentView extends BaseFragment {
    private AdminEventsPresenter presenter;
    private AdminAnnouncementsPresenter announcementsPresenter;
    private EditText titleEditText, descriptionEditText, capacityEditText, locationEditText, dateEditText;
    private Button submitEventButton;
    private Button selectDateTimeButton;
    private Date timestamp;

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

        // Initialize all components
        titleEditText = view.findViewById(R.id.editTextText3);
        descriptionEditText = view.findViewById(R.id.editTextText4);
        capacityEditText = view.findViewById(R.id.editTextText5);
        locationEditText = view.findViewById(R.id.editTextText6);
        selectDateTimeButton = view.findViewById(R.id.selectDateTimeButton);
        submitEventButton = view.findViewById(R.id.submitEventButton);
        dateEditText = view.findViewById(R.id.dateEditText);

        // Set click listener for date and time button
        selectDateTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call ShowDatePickerDialog function for date and time picking.
                showDatePickerDialog();
            }
        });

        // Set click listener for submit button
        submitEventButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                submitEvent();
                activity.replaceFragment(new AdminEventsFragmentView());
            }
        });

        return view;
    }

    private void showDatePickerDialog() {
        // Create a Date Picker Dialog
        DatePickerDialog datePickerDialog = new DatePickerDialog(activity,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int date) {
                        // Handle the selected date
                        handleSelectedDate(year, month, date);
                    }
                },
                // Set initial date to current date
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
        );
        // Show the dialog
        datePickerDialog.show();
    }

    private void handleSelectedDate(int year, int month, int dayOfMonth) {
        // Convert date to a formatted string or handle as needed
        String formattedDate = formatDate(year, month, dayOfMonth);

        // Update the TextInputEditText
        //TextInputEditText dateEditText = view.findViewById(R.id.dateEditText);
        dateEditText.setText(formattedDate);

        // Calculate timestamp with a specific starting time (e.g., 12:00 PM)
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, dayOfMonth, 12, 0, 0);
        timestamp = new Date(calendar.getTimeInMillis());
    }

    // ...

    private String formatDate(int year, int month, int dayOfMonth) {
        //  months are 0-indexed in Calendar
        month += 1;

        // Format the date using standard "MM/dd/yyyy" representation
        String formattedMonth = (month < 10) ? "0" + month : String.valueOf(month);
        String formattedDay = (dayOfMonth < 10) ? "0" + dayOfMonth : String.valueOf(dayOfMonth);

        return formattedMonth + "/" + formattedDay + "/" + year;
    }



    // Handle event submission
    private void submitEvent() {
         // <- here add title of event, "event" as type, description as content

        // Get input values
        String title = titleEditText.getText().toString().trim();
        String description = descriptionEditText.getText().toString().trim();
        int capacity = Integer.parseInt(capacityEditText.getText().toString().trim());
        String location = locationEditText.getText().toString().trim();

        announcementsPresenter.createAnnouncement(title, "Event", description);
        // *4th parameter is a long type.
        presenter.createEvent(title, description, capacity, timestamp, location);//createEvent(String title, String description, int maxAttendees, Date date)
    }
}
