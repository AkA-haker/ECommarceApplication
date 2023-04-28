package com.example.e_commarceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.e_commarceapplication.databinding.ActivityAccountInfoBinding;

public class AccountInfoActivity extends DrawerBaseActivity {

    ActivityAccountInfoBinding activityAccountInfoBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAccountInfoBinding=ActivityAccountInfoBinding.inflate(getLayoutInflater());
        setContentView(activityAccountInfoBinding.getRoot());
        allocateActivityTitle("Account Information");
    }
}