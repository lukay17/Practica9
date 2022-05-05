package com.lega.practica9;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.lega.practica9.databinding.ActivityViewBinding;

public class ViewActivity extends AppCompatActivity {

    private ActivityViewBinding binding;
    private com.lega.practica9.PageAdapterOnboarding pageAdapter;
    private String position;
    private String pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        pageAdapter = new com.lega.practica9.PageAdapterOnboarding(this);
        binding.VPAContainerPages.setAdapter(pageAdapter);
        binding.VPAContainerPages.setCurrentItem(0, false);
        binding.VPAContainerPages.setUserInputEnabled(false);

        if(getIntent().getExtras() != null){
            position = getIntent().getExtras().getString("pos");
            Log.e("lega",position);
            switch (position){
                case "ONE":
                    binding.VPAContainerPages.setCurrentItem(0, false);
                    break;
                case "TWO":
                    binding.VPAContainerPages.setCurrentItem(1, false);
                    break;
                case "THREE":
                    binding.VPAContainerPages.setCurrentItem(2, false);
                    break;
                default:
                    throw  new IllegalStateException("Unexpected value " + position);
            }
        }
    }



}