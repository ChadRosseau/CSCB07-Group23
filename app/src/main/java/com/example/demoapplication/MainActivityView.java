package com.example.demoapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.demoapplication.baseClasses.UserType;
import com.example.demoapplication.databinding.ActivityMainBinding;
import com.example.demoapplication.fragments.BaseFragment;
import com.example.demoapplication.fragments.announcements.StudentAnnouncementsFragmentView;
import com.example.demoapplication.fragments.complaints.AdminComplaintsFragmentView;
import com.example.demoapplication.fragments.complaints.StudentComplaintsFragmentView;
import com.example.demoapplication.fragments.events.EventsFragmentView;
import com.example.demoapplication.fragments.HomeFragmentView;
import com.example.demoapplication.fragments.announcements.AdminAnnouncementsFragmentView;
import com.example.demoapplication.fragments.PostFragmentView;

public class MainActivityView extends AppCompatActivity {

    ActivityMainBinding binding;
    AuthModel auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragmentView());
        auth = AuthModel.getInstance();
        auth.fetchCurrentUser();

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            BaseFragment target;
            boolean isAdmin = auth.getCurrentUserData().getUserType() == UserType.Admin;
            switch(item.getItemId()){
                case R.id.home:
                    target = new HomeFragmentView();
                    break;
                case R.id.post:
                    target = new PostFragmentView();
                    break;
                case R.id.announcements:
                    target = isAdmin ? new AdminAnnouncementsFragmentView() : new StudentAnnouncementsFragmentView();
                    break;
                case R.id.events:
                    target = new EventsFragmentView();
                    break;
                case R.id.complaints:
                    target = isAdmin ? new AdminComplaintsFragmentView() : new StudentComplaintsFragmentView();
                    break;
                default:
                    target = new HomeFragmentView();
                    break;
            }

            replaceFragment(target);

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