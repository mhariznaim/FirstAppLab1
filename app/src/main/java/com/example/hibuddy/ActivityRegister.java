package com.example.hibuddy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.hibuddy.databinding.ActivityRegisterBinding;

import java.util.Calendar;

public class ActivityRegister extends AppCompatActivity {

    ActivityRegisterBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnReg.setOnClickListener(this::fnNavToExp);
        binding.imgProfile.setOnClickListener(this:: fnTakePic);

    }

    private void fnNavToExp(View view)
    {
        Intent intent = new Intent(this,ActivityExpense.class);
        startActivity(intent);
    }

    private void fnCalcAge(View view) {

        Float fltUserYear = Float.parseFloat(binding.editTextDate.getText().toString());
        Float diffYear = getCurrentYear() - fltUserYear;
        binding.editTextDate.setText("You are "  + diffYear +" years old");

    }

    private int getCurrentYear() {
        // Using Calendar
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);

        // Or, if using LocalDate and API level 26 and above
        // return getCurrentYearUsingLocalDate();
    }
    private void fnTakePic(View view) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bitmap = (Bitmap) data.getExtras(). get("data");
        binding.imgProfile.setImageBitmap(bitmap);
    }

    @Override
    protected void onStart() {
        Intent intent = getIntent();
        binding.editTextTextPersonName2.setText(intent.getStringExtra("username"));
        binding.edtPwd.setText(intent.getStringExtra("password"));
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


}