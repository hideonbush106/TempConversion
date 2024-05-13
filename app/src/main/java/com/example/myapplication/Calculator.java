package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.CalculatorBinding;

public class Calculator extends AppCompatActivity {

    private CalculatorBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = CalculatorBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ctf.setOnClickListener(view -> {
            if (binding.celsiusInput.getText().toString().isEmpty())
                binding.output.setText("Celsius input is required");
            else {
                int temp = Integer.parseInt(binding.celsiusInput.getText().toString());
                int result = (temp * 9 / 5) + 32;
                binding.output.setText("°F: " + result);
            }
        });
        binding.ftc.setOnClickListener(view -> {
            if (binding.fahrenheitInput.getText().toString().isEmpty())
                binding.output.setText("Fahrenheit input is required");
            else {
                int temp = Integer.parseInt(binding.fahrenheitInput.getText().toString());
                int result = (temp - 32) * 5 / 9;
                binding.output.setText("°C: " + result);
            }
        });
        binding.clear.setOnClickListener(view -> {
            binding.output.setText("");
            binding.fahrenheitInput.setText("");
            binding.celsiusInput.setText("");
        });
    }
}