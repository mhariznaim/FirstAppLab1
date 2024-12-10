package com.example.hibuddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import com.bumptech.glide.Glide;
import com.example.hibuddy.adapter.ExpenseAdapter;
import com.example.hibuddy.databinding.ActivityExpenseBinding;
import com.example.hibuddy.model.Expense;

import java.util.Calendar;
import java.util.Vector;

public class ActivityExpense extends AppCompatActivity {

    ActivityExpenseBinding binding;
    Expense expense;
    private Vector<Expense> expenses;
    private ExpenseAdapter expenseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityExpenseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Integer[] numbers = new Integer[15];
        for (int i = 0; i < 15; i++) {
            numbers[i] = i + 1;
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,numbers);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spnQty.setAdapter(adapter);

        Glide.with(getApplicationContext()).load("https://lh3.googleusercontent.com/p/AF1QipPH8YIRrh-GRTaCH4z4Vz5cFjJsxLt845rqWy4-=w1080-h608-p-no-v0").into(binding.imgExp);
       // binding.imgExp.setImageURI(Uri.parse("https://lh3.googleusercontent.com/p/AF1QipPH8YIRrh-GRTaCH4z4Vz5cFjJsxLt845rqWy4-=w1080-h608-p-no-v0"));

        binding.btnSave.setOnClickListener(this::fnSaveExp);
        binding.imgExp.setOnClickListener(this::fnTakePic);
        binding.edtExpDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fnInvokeDatePicker();
            }
        });
        expenses = new Vector<>();
        expenseAdapter = new ExpenseAdapter(getLayoutInflater(),expenses);
        binding.rcvVw.setAdapter(expenseAdapter);
        binding.rcvVw.setLayoutManager(new LinearLayoutManager(this));
    }

    DatePickerDialog pickerDialog;
    private void fnInvokeDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);

        pickerDialog = new DatePickerDialog(ActivityExpense.this, new
                DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthofyear, int dayOfMonth)
            {
                binding.edtExpDate.setText(dayOfMonth + "/" + (monthofyear+2) + "/" + year);
            }
        },year,month,day);
        pickerDialog.show();
    }

    private void fnSaveExp(View view)
    {
        Expense expense = new Expense();
        int qtyItem = (int) binding.spnQty.getSelectedItemId();

        binding.txtVwTotalPrice.setText(""+qtyItem * Float.parseFloat(binding.edtExpValue.
                getText().toString()));

        expenses.add(expense);
        expenseAdapter.notifyDataSetChanged();
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
        binding.imgExp.setImageBitmap(bitmap);
    }
}