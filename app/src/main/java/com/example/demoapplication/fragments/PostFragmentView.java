// PostView.java
package com.example.demoapplication.fragments;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.demoapplication.R;

import java.util.Objects;

public class PostFragmentView extends BaseFragment {

    private Spinner csca08Spinner, mata31Spinner, csca67Spinner,
            csca48Spinner, mata37Spinner, mata22Spinner;

    private Float CSCA08_GPA, MATA31_GPA, CSCA67_GPA, CSCA48_GPA, MATA37_GPA, MATA22_GPA;
    private Spinner enrolledProgramSpinner, desiredProgramSpinner;
    private String enrollmentProgram, desiredProgram;

    private final String uncertainResult = "You will be considered for extra spaces, and not guaranteed entry.";
    private final String acceptanceResult = "Congratulations! You are guaranteed to make POSt!";
    private final String failedResult = "Unfortunately, you cannot make POSt.";
    private Button buttonPostResult;
    private EditText editTextPostResult;

    public PostFragmentView() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.post, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        csca08Spinner = view.findViewById(R.id.csca08GPA);
        mata31Spinner = view.findViewById(R.id.mata31GPA);
        csca67Spinner = view.findViewById(R.id.csca67GPA);
        csca48Spinner = view.findViewById(R.id.csca48GPA);
        mata37Spinner = view.findViewById(R.id.mata37GPA);
        mata22Spinner = view.findViewById(R.id.mata22GPA);

        enrolledProgramSpinner = view.findViewById(R.id.spinner_enrolled_program);
        desiredProgramSpinner = view.findViewById(R.id.spinner_desired_program);

        buttonPostResult = view.findViewById(R.id.postGetResult);
        editTextPostResult = view.findViewById(R.id.postResult);

        buttonPostResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSpinnerValues();
                String post_result = assessPostEligibility();
                editTextPostResult.setText(post_result);
            }
        });
    }

    private void setSpinnerValues() {
        CSCA08_GPA = Float.parseFloat(csca08Spinner.getSelectedItem().toString());
        MATA31_GPA = Float.parseFloat(mata31Spinner.getSelectedItem().toString());
        CSCA67_GPA = Float.parseFloat(csca67Spinner.getSelectedItem().toString());
        CSCA48_GPA = Float.parseFloat(csca48Spinner.getSelectedItem().toString());
        MATA37_GPA = Float.parseFloat(mata37Spinner.getSelectedItem().toString());
        MATA22_GPA = Float.parseFloat(mata22Spinner.getSelectedItem().toString());

        enrollmentProgram = enrolledProgramSpinner.getSelectedItem().toString();
        desiredProgram = desiredProgramSpinner.getSelectedItem().toString();
    }


    private boolean hasNotPassedRequiredCourses(Float [] required_courses) {
        for (Float course : required_courses) {
            if (course == 0.0)
                return true;
        }
        return false;
    }

    private String assessPostEligibility() {

        if (Objects.equals(desiredProgram, "Computer Science - Specialist or Major"))
            return assessCSMajorSpecialistEligibility();

        else if (Objects.equals(desiredProgram, "Mathematics - Major"))
            return assessMathMajorEligibility();

        else if (Objects.equals(desiredProgram, "Mathematics - Specialist"))
            return assessMathSpecialistEligibility();

        else if (Objects.equals(desiredProgram, "Statistics - Major"))
            return assessStatsMajorEligibility();

        else if (Objects.equals(desiredProgram, "Statistics - Specialist"))
            return assessStatsSpecialistEligibility();

        return "Invalid program entered!";
    }

    private String assessCSMajorSpecialistEligibility() {

        Float [] required_courses = {CSCA08_GPA, MATA31_GPA, CSCA67_GPA, CSCA48_GPA, MATA37_GPA, MATA22_GPA};
        if (hasNotPassedRequiredCourses(required_courses)) return failedResult;

        if (Objects.equals(enrollmentProgram, "Computer Science")) {

            float averageGPA = (MATA31_GPA + CSCA67_GPA + CSCA48_GPA
                    + MATA37_GPA + MATA22_GPA) / 5;

            if (averageGPA >= 2.5 && CSCA48_GPA >= 3.0 &&
                    ((CSCA67_GPA >= 1.7 && MATA22_GPA >= 1.7) ||
                            (CSCA67_GPA >= 1.7 && MATA37_GPA >= 1.7) ||
                            (MATA22_GPA >= 1.7 && MATA37_GPA >= 1.7)))
                return acceptanceResult;

            return failedResult;
        }

        else if (Objects.equals(enrollmentProgram, "Mathematics") ||
                Objects.equals(enrollmentProgram, "Statistics")) {
            return uncertainResult;
        }

        else {
            if (CSCA67_GPA >= 3.7 && MATA31_GPA >= 3.7)
                return uncertainResult;
            return failedResult;
        }
    }

    private String assessMathMajorEligibility() {

        Float [] required_courses = {CSCA08_GPA, MATA31_GPA, CSCA67_GPA, MATA37_GPA, MATA22_GPA};
        if (hasNotPassedRequiredCourses(required_courses)) return failedResult;

        if (Objects.equals(enrollmentProgram, "Mathematics")) {

            float averageGPA = (MATA31_GPA + CSCA67_GPA + MATA37_GPA + MATA22_GPA) / 4;

            if (averageGPA >= 2.0 &&
                    (CSCA67_GPA >= 3.0 || MATA22_GPA >= 3.0 || MATA37_GPA >= 3.0))
                return acceptanceResult;

            return failedResult;
        }

        return uncertainResult;
    }

    private String assessMathSpecialistEligibility() {

        Float [] required_courses = {CSCA08_GPA, MATA31_GPA, CSCA67_GPA, MATA37_GPA, MATA22_GPA};
        if (hasNotPassedRequiredCourses(required_courses)) return failedResult;

        if (Objects.equals(enrollmentProgram, "Mathematics")) {

            float averageGPA = (MATA31_GPA + CSCA67_GPA + MATA37_GPA + MATA22_GPA) / 4;

            if (averageGPA >= 2.5 &&
                    ((CSCA67_GPA >= 3.0 && MATA22_GPA >= 3.0) ||
                            (CSCA67_GPA >= 3.0 && MATA37_GPA >= 3.0) ||
                            (MATA22_GPA >= 3.0 && MATA37_GPA >= 3.0)))
                return acceptanceResult;

            return failedResult;
        }

        else return uncertainResult;
    }

    private String assessStatsMajorEligibility() {

        Float [] required_courses = {CSCA08_GPA, MATA31_GPA, MATA37_GPA, MATA22_GPA};
        if (hasNotPassedRequiredCourses(required_courses)) return failedResult;


        if (Objects.equals(enrollmentProgram, "Statistics")) {

            float averageGPA = (MATA31_GPA + MATA37_GPA + CSCA08_GPA + MATA22_GPA) / 4;

            if (averageGPA >= 2.3)
                return acceptanceResult;

            return failedResult;
        }

        return uncertainResult;
    }

    private String assessStatsSpecialistEligibility() {

        Float [] required_courses = {CSCA08_GPA, MATA31_GPA, CSCA67_GPA, MATA37_GPA, MATA22_GPA};
        if (hasNotPassedRequiredCourses(required_courses)) return failedResult;


        if (Objects.equals(enrollmentProgram, "Statistics")) {

            float averageGPA = (MATA31_GPA + MATA37_GPA + CSCA08_GPA +
                    CSCA67_GPA + MATA22_GPA) / 5;

            if (averageGPA >= 2.5)
                return acceptanceResult;

            return failedResult;
        }

        return uncertainResult;
    }
}

