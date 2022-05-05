package com.lega.practica9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.lega.practica9.databinding.ActivityMainBinding;
import com.lega.practica9.fragment.LoginFragment;
import com.lega.practica9.fragment.RegisterFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initLoginFragment();
    }

    private void initLoginFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.P9Container.getId(), new LoginFragment(), "LoginFragment")
                .commitAllowingStateLoss();
    }
}