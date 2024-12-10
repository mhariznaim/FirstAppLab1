package com.example.hibuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.hibuddy.databinding.ActivityLoginBinding;
import com.google.android.material.navigation.NavigationView;

public class ActivityLogin extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;
    ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        drawerLayout = binding.myDrawerLayout;
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout, R.string.nav_open,
                R.string.nav_close);
        actionBarDrawerToggle.syncState();
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView = binding.navigation;

        navigationView.setNavigationItemSelectedListener(new
                     NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Intent intent;
                switch (item.getItemId())
                {
                    case R.id.nav_login_activity:
                        intent = new Intent(getApplicationContext(), ActivityLogin.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_register:
                        intent = new Intent(getApplicationContext(), ActivityRegister.class);
                        startActivity(intent);
                        return true;
                    case R.id.nav_expenses:
                        intent = new Intent(getApplicationContext(),ActivityExpense.class);
                        startActivity(intent);
                        return true;
                    default:return false;
                }
            }
        });

        binding.button.setOnClickListener(this::fnLogin);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
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

    public void fnLogin(View view) {

        String username = binding.editTextTextPersonName.getText().toString();
        Intent intent = new Intent(this,ActivityRegister.class);
        intent.putExtra("username", username);
        intent.putExtra("password", binding.editTextTextPassword.getText().toString());
        startActivity(intent);



    }
}