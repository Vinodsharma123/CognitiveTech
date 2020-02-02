package com.example.congitivetech;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {


    EditText serverIP;
    EditText userrname;
    EditText txt;

    SharedPreferences sp;
    Button button;
    private CheckBox checckbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        button = findViewById(R.id.button_login);
        button.setOnClickListener(this);

        CheckBox checkbox = findViewById(R.id.checkbox);
        final EditText editText = findViewById(R.id.edt_password);

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    //show Password

                    editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    //Hide Password
                    editText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
            }
        });
        serverIP = findViewById(R.id.edt_server);
        userrname = findViewById(R.id.edt_username);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_login) {
            //TODO check login credentials
            //if verified
            //Just Trying

            if(serverIP.getText().toString().toLowerCase().equals("true") && userrname.getText().toString().toLowerCase().equals("true")){
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show();
                gotoRefreshActivity();
            }else{
                Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                userrname.setText("");
                serverIP.setText("");
            }


        }
    }

    private void gotoRefreshActivity() {
        //TODO save to shared prefs
        saveToSharedPrefs(serverIP.getText().toString().toLowerCase(), userrname.getText().toString().toLowerCase());
        startActivity(new Intent(this, RefreshActivity.class));
        finish();
    }

    private void saveToSharedPrefs(String serverip, String username) {
        SharedPreferences preferences = getSharedPreferences("COG_TECH_PREFS", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("serverip", serverip);
        editor.putString("username", username);
        editor.apply();
    }

}
