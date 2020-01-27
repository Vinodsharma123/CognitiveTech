package com.example.congitivetech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Button loginButton = findViewById(R.id.button_login);
        loginButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button_login){
            //TODO check login credentials
            //if verified
            Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
            gotoRefreshActivity();
        }
    }

    private void gotoRefreshActivity() {
        //TODO save to shared prefs
        startActivity(new Intent(this, RefreshActivity.class));
        finish();
    }
}
