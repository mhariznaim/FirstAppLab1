package com.example.hibuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.hibuddy.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnSubmit.setOnClickListener(this:: fnToast);
    }

    private void fnToast(View view) {
        Toast.makeText(this,"Hello hi there" +
                binding.edtFullName.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}