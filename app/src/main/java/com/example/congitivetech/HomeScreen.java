package com.example.congitivetech;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HomeScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


    }
    private void logout() {
        SharedPreferences preferences= getSharedPreferences("COG_TECH_PREF",MODE_PRIVATE);
        SharedPreferences.Editor edit= preferences.edit();
        edit.clear();
        edit.commit();
        startActivity(new Intent(this, LoginActivity.class));
        this.finish();
    }
}
