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

    @Override
    protected void onStart() {

        super.onStart();
    }

    @Override
    protected void onPostResume() {

        super.onPostResume();
    }


    @Override
    protected void onPause() {

        super.onPause();
    }

    @Override
    protected void onStop() {

        super.onStop();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    protected void onRestart() {

        super.onRestart();
    }

    private void fnToast(View view) {
        Toast.makeText(this,"Hello hi there" +
                binding.edtFullName.getText().toString(), Toast.LENGTH_SHORT).show();
    }
}