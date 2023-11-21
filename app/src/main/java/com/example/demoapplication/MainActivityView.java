package com.example.demoapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.demoapplication.baseClasses.UserType;
import com.example.demoapplication.databinding.ActivityMainBinding;
import com.example.demoapplication.fragments.ComplaintsFragmentView;
import com.example.demoapplication.fragments.EventsFragmentView;
import com.example.demoapplication.fragments.HomeFragmentView;
import com.example.demoapplication.fragments.NotificationsFragmentView;
import com.example.demoapplication.fragments.PostFragmentView;

public class MainActivityView extends AppCompatActivity {

    MainActivityPresenter presenter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragmentView());
//        editText = (EditText) findViewById(R.id.editTextTextPersonName);
//        textView = (TextView) findViewById(R.id.output);
        presenter = new MainActivityPresenter(this, new MainActivityModel());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//            if (presenter.auth.getCurrentUserType() == UserType.Admin) {}
            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragmentView());
                    break;
                case R.id.notifications:
                    replaceFragment(new NotificationsFragmentView());
                    break;
                case R.id.post:
                    replaceFragment(new PostFragmentView());
                    break;
                case R.id.events:
                    replaceFragment(new EventsFragmentView());
                    break;
                case R.id.complaints:
                    replaceFragment(new ComplaintsFragmentView());
                    break;
            }

            return true;
        });
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

//    public void onClickCheck(View view){
//        presenter.checkDB(editText.getText().toString());
//    }

//    public void setOutputText(String resultText)
//    {
//        textView.setText(resultText);
//    }

}