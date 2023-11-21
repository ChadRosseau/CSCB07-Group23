package com.example.demoapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.demoapplication.baseClasses.UserData;
import com.example.demoapplication.baseClasses.UserType;
import com.example.demoapplication.databinding.ActivityMainBinding;
import com.example.demoapplication.fragments.ComplaintsFragmentView;
import com.example.demoapplication.fragments.CreateNotificationView;
import com.example.demoapplication.fragments.EventsFragmentView;
import com.example.demoapplication.fragments.HomeFragmentView;
import com.example.demoapplication.fragments.NotificationsFragmentView;
import com.example.demoapplication.fragments.AdminNotificationsFragmentView;
import com.example.demoapplication.fragments.PostFragmentView;

public class MainActivityView extends AppCompatActivity {

    public MainActivityPresenter presenter;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(new HomeFragmentView());
        presenter = new MainActivityPresenter(this, new MainActivityModel());
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
//            if (presenter.auth.getCurrentUserData().getUserType() == UserType.Admin) {}
            switch(item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragmentView());
                    break;
                case R.id.notifications:
                    replaceFragment(new AdminNotificationsFragmentView());
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

    public void showCreateFragment() {
        CreateNotificationView createNotificationView = new CreateNotificationView();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.setCustomAnimations(R.anim.transition_up, 0);
        fragmentTransaction.replace(R.id.frame_layout, createNotificationView);

        fragmentTransaction.commit();
    }
}