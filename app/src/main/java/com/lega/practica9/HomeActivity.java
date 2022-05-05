package com.lega.practica9;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.lega.practica9.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private String welcome = "";
    private String name = "";
    private String surname = "";
    private com.lega.practica9.PageAdapterHome pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.HAToolbar);

       // binding.VPA1Tabs.setSelectedTabIndicatorColor(androidx.appcompat.R.attr.colorPrimary);

        binding.HAToolbar.setNavigationIcon(R.drawable.home);

        if(getIntent().getExtras() != null){
            name = getIntent().getExtras().getString("name", "No hay Nombre");
            surname = getIntent().getExtras().getString("surname", "No hay Apellido");
            Log.e("lega",name);
            Log.e("lega",surname);
            Snackbar.make(binding.HAToolbar, welcome, Snackbar.LENGTH_SHORT).show();
        }

        pageAdapter = new com.lega.practica9.PageAdapterHome(this);
        binding.VPA1ContainerPages.setAdapter(pageAdapter);
        binding.VPA1ContainerPages.setCurrentItem(0, false);

        new TabLayoutMediator(binding.VPA1Tabs, binding.VPA1ContainerPages,((tab, position) -> {
            if(position == 0){
                tab.view.setBackgroundColor(Color.rgb(159,252,253));
                tab.setIcon(R.drawable.camara);
            }else  if(position == 1){
                tab.view.setBackgroundColor(Color.rgb(226,211,242));
                tab.setIcon(R.drawable.baseline_directions_car_black_24dp);

            }else  if(position == 2) {
                tab.view.setBackgroundColor(Color.rgb(242,186,237));

                tab.setIcon(R.drawable.baseline_terrain_black_24dp);
            }
            else  if(position == 3) {
                tab.view.setBackgroundColor(Color.rgb(255,241,130));
                tab.setIcon(R.drawable.baseline_face_black_24dp);
            }
        })).attach();

        binding.VPA1Tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                tab.getIcon().setColorFilter(Color.BLACK, PorterDuff.Mode.SRC_IN);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }

        });
    }


}