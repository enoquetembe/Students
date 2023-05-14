package com.example.studets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.studets.databinding.ActivityMainBinding;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private  ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Crie o adapter para o ViewPager
        FragmentAdapter fragmentAdapter = new FragmentAdapter(this);
        binding.viewPager.setAdapter(fragmentAdapter);

// Vincule o ViewPager ao TabLayout
        new TabLayoutMediator(binding.tabLayout, binding.viewPager, (tab, position) -> {
            switch (position) {
                case 0:
                    tab.setText("Registrar");
                    break;
                case 1:
                    tab.setText("Listar");
                    break;
                case 2:
                    tab.setText("Configurações");
                    break;
            }
        }).attach();
    }
}