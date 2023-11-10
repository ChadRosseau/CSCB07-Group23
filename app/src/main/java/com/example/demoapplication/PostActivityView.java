// PostActivityView.java
package com.example.demoapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class PostActivityView extends AppCompatActivity {

    private Spinner csca08Spinner, mata31Spinner, csca67Spinner,
            csca48Spinner, mata37Spinner, mata22Spinner;

    private Float CSCA08_GPA, MATA31_GPA, CSCA67_GPA, CSCA48_GPA, MATA37_GPA, MATA22_GPA;
    private Spinner enrolledProgramSpinner, desiredProgramSpinner;
    private String enrollmentProgram, desiredProgram;
    private Button buttonPostResult;
    private EditText editTextPostResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post);

        csca08Spinner = findViewById(R.id.csca08GPA);
        mata31Spinner = findViewById(R.id.mata31GPA);
        csca67Spinner = findViewById(R.id.csca67GPA);
        csca48Spinner = findViewById(R.id.csca48GPA);
        mata37Spinner = findViewById(R.id.mata37GPA);
        mata22Spinner = findViewById(R.id.mata22GPA);

        enrolledProgramSpinner = findViewById(R.id.spinner_enrolled_program);
        desiredProgramSpinner = findViewById(R.id.spinner_desired_program);

        buttonPostResult = findViewById(R.id.postGetResult);
        editTextPostResult = findViewById(R.id.postResult);

        buttonPostResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSpinnerValues();
                String post_result = accessPostEligibility();
                editTextPostResult.setText(post_result);
            }
        });
    }

    private void saveSpinnerValues() {
        CSCA08_GPA = Float.parseFloat(csca08Spinner.getSelectedItem().toString());
        MATA31_GPA = Float.parseFloat(mata31Spinner.getSelectedItem().toString());
        CSCA67_GPA = Float.parseFloat(csca67Spinner.getSelectedItem().toString());
        CSCA48_GPA = Float.parseFloat(csca48Spinner.getSelectedItem().toString());
        MATA37_GPA = Float.parseFloat(mata37Spinner.getSelectedItem().toString());
        MATA22_GPA = Float.parseFloat(mata22Spinner.getSelectedItem().toString());

        enrollmentProgram = enrolledProgramSpinner.getSelectedItem().toString();
        desiredProgram = desiredProgramSpinner.getSelectedItem().toString();
    }

    private String accessPostEligibility() {

        String uncertainPostResult = "You will be considered for extra spaces, and not guaranteed entry.";
        String acceptanceResult = "Congratulations! You are guaranteed to make POSt!";
        String failedResult = "Unfortunately, you cannot make POSt.";
        String invalidInput = "Invalid program entered!";


        if (Objects.equals(desiredProgram, "Computer Science - Specialist or Major")) {

            if (Objects.equals(enrollmentProgram, "Computer Science")) {

                float averageGPA = (MATA31_GPA + CSCA67_GPA + CSCA48_GPA
                        + MATA37_GPA + MATA22_GPA) / 5;

                if (averageGPA >= 2.5 && CSCA48_GPA >= 3.0 &&
                        ((CSCA67_GPA >= 1.7 && MATA22_GPA >= 1.7) ||
                                (CSCA67_GPA >= 1.7 && MATA37_GPA >= 1.7) ||
                                (MATA22_GPA >= 1.7 && MATA37_GPA >= 1.7)))
                    return acceptanceResult;

                else
                    return failedResult;
            }

            else if (Objects.equals(enrollmentProgram, "Mathematics") ||
                    Objects.equals(enrollmentProgram, "Statistics")) {
                return uncertainPostResult;
            }

            else {
                if (CSCA67_GPA >= 3.7 && MATA31_GPA >= 3.7) return uncertainPostResult;
                else return failedResult;
            }
        }

        else if (Objects.equals(desiredProgram, "Mathematics - Major")) {

            if (Objects.equals(enrollmentProgram, "Mathematics")) {

                float averageGPA = (MATA31_GPA + CSCA67_GPA + MATA37_GPA + MATA22_GPA) / 4;

                if (averageGPA >= 2.0 &&
                        (CSCA67_GPA >= 3.0 || MATA22_GPA >= 3.0 || MATA37_GPA >= 3.0))
                    return acceptanceResult;

                else
                    return failedResult;
            }

            else
                return uncertainPostResult;
        }

        else if (Objects.equals(desiredProgram, "Mathematics - Specialist")) {

            if (Objects.equals(enrollmentProgram, "Mathematics")) {

                float averageGPA = (MATA31_GPA + CSCA67_GPA + MATA37_GPA + MATA22_GPA) / 4;

                if (averageGPA >= 2.5 &&
                        ((CSCA67_GPA >= 3.0 && MATA22_GPA >= 3.0) ||
                                (CSCA67_GPA >= 3.0 && MATA37_GPA >= 3.0) ||
                                (MATA22_GPA >= 3.0 && MATA37_GPA >= 3.0)))
                    return acceptanceResult;

                else
                    return failedResult;
            }

            else
                return uncertainPostResult;
        }

        else if (Objects.equals(desiredProgram, "Statistics - Major")) {

            if (Objects.equals(enrollmentProgram, "Statistics")) {

                float averageGPA = (MATA31_GPA + MATA37_GPA + CSCA08_GPA + MATA22_GPA) / 4;

                if (averageGPA >= 2.3)
                    return acceptanceResult;

                else
                    return failedResult;
            }

            else
                return uncertainPostResult;
        }

        else if (Objects.equals(desiredProgram, "Statistics - Specialist")) {

            if (Objects.equals(enrollmentProgram, "Statistics")) {

                float averageGPA = (MATA31_GPA + MATA37_GPA + CSCA08_GPA +
                        CSCA67_GPA + MATA22_GPA) / 5;

                if (averageGPA >= 2.5)
                    return acceptanceResult;

                else
                    return failedResult;
            }

            else
                return uncertainPostResult;
        }

        return invalidInput;
    }
}

