package com.example.congitivetech;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Splash extends AppCompatActivity {



    final private int REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS = 124;
    String[] permissions = {
            "android.permission.BLUETOOTH",
            "android.permission.BLUETOOTH_ADMIN"/*
            "android.permission.WRITE_EXTERNAL_STORAGE",
            "android.permission.INTERNET",
            "android.permission.CAMERA",
            "android.permission.ACCESS_COARSE_LOCATION",
            "android.permission.ACCESS_FINE_LOCATION"*/};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        //TODO: Runtime permission check
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS);
        } else {
            launchApp();
        }


    }

    private void launchApp() {

        //TODO shared prefs

        SharedPreferences sharedpreferences = getSharedPreferences("COG_TECH_PREFS", Context.MODE_PRIVATE);
        String serverip = sharedpreferences.getString("serverip", null);
        String username = sharedpreferences.getString("username", null);

        if(serverip == null || username == null){
            openLoginActivity();
        }else if(serverip.equals("true") && username.equals("true")){
            openRefreshActivity();
        }else{
            openLoginActivity();

        }
    }

    private void openRefreshActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), RefreshActivity.class));
                finish();            }
        }, 2000);
    }

    private void openLoginActivity() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();            }
        }, 2000);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CODE_ASK_MULTIPLE_PERMISSIONS) {
            Map<String, Integer> perms = new HashMap<>();
            perms.put(Manifest.permission.BLUETOOTH, PackageManager.PERMISSION_GRANTED);
            perms.put(Manifest.permission.BLUETOOTH_ADMIN, PackageManager.PERMISSION_GRANTED);
/*            perms.put(Manifest.permission.ACCESS_COARSE_LOCATION, PackageManager.PERMISSION_GRANTED);
            perms.put(Manifest.permission.ACCESS_FINE_LOCATION, PackageManager.PERMISSION_GRANTED);
            perms.put(Manifest.permission.READ_PHONE_STATE, PackageManager.PERMISSION_GRANTED);
            perms.put(Manifest.permission.CAMERA, PackageManager.PERMISSION_GRANTED);
            perms.put(Manifest.permission.INTERNET, PackageManager.PERMISSION_GRANTED);*/

            for (int i = 0; i < permissions.length; i++)
                perms.put(permissions[i], grantResults[i]);
            if (perms.get(Manifest.permission.BLUETOOTH) == PackageManager.PERMISSION_GRANTED
                    && perms.get(Manifest.permission.BLUETOOTH_ADMIN) == PackageManager.PERMISSION_GRANTED
                /*
                    && perms.get(Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                    perms.get(Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                    perms.get(Manifest.permission.READ_PHONE_STATE) == PackageManager.PERMISSION_GRANTED &&
                    perms.get(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED &&
                    perms.get(Manifest.permission.INTERNET) == PackageManager.PERMISSION_GRANTED*/
            ) {
                // All Permissions Granted
                launchApp();

            } else {
                // Permission Denied
                Toast.makeText(Splash.this, "Some Permission is Denied", Toast.LENGTH_LONG).show();
                finish();
            }

        }
    }
}
