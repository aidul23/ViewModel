package com.duodevloopers.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.duodevloopers.viewmodel.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewModel model = new ViewModelProvider(this).get(ViewModel.class);

        binding.addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.increaseQuantity();

            }
        });

        binding.removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.decreaseQuantity();
            }
        });

        model.getAmount().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.quantity.setText(String.valueOf(integer));
            }
        });

        model.getTotalCost().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                binding.totalCost.setText(String.valueOf(integer)+" Taka");
            }
        });

    }
}