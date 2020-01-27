package com.example.congitivetech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        //TODO: Runtime permission check

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                launchApp();
            }
        }, 2000);
    }

    private void launchApp() {

        //TODO shared prefs

        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
