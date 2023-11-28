package com.example.demoapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.demoapplication.databinding.ActivityMainBinding;
import com.example.demoapplication.fragments.complaints.StudentComplaintsFragmentView;
import com.example.demoapplication.fragments.events.EventsFragmentView;
import com.example.demoapplication.fragments.HomeFragmentView;
import com.example.demoapplication.fragments.announcements.AdminAnnouncementsFragmentView;
import com.example.demoapplication.fragments.PostFragmentView;

public class MainActivityView extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragmentView());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//            if (presenter.auth.getCurrentUserData().getUserType() == UserType.Admin) {}
            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragmentView());
                    break;
                case R.id.notifications:
                    replaceFragment(new AdminAnnouncementsFragmentView());
                    break;
                case R.id.post:
                    replaceFragment(new PostFragmentView());
                    break;
                case R.id.events:
                    replaceFragment(new EventsFragmentView());
                    break;
                case R.id.complaints:
                    replaceFragment(new StudentComplaintsFragmentView());
                    break;
            }

            return true;
        });
    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }

    public void replaceFragment(Fragment fragment, int animation){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.setCustomAnimations(animation, 0);
        fragmentTransaction.replace(R.id.frame_layout, fragment);

        fragmentTransaction.commit();
    }

    public void logout() {
        startActivity(new Intent(this, LoginActivityView.class));
    }
}