package com.example.congitivetech.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.congitivetech.LoginActivity;
import com.example.congitivetech.R;

public class LogoutFragment extends Fragment implements View.OnClickListener {

    View root;
    AlertDialog alert;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         root = inflater.inflate(R.layout.fragment_home, container, false);
        Button button = root.findViewById(R.id.logout_yes);
        button.setOnClickListener(this);
        return root;
    }

    private void showAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Are you Sure?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                logout();
                alert.hide();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Not Log out", Toast.LENGTH_SHORT).show();
            }
        });
        alert = builder.create();
        alert.show();
    }

    private void logout() {
        Toast.makeText(getActivity(), "Logging out..", Toast.LENGTH_SHORT).show();
        SharedPreferences preferences= getActivity().getSharedPreferences("COG_TECH_PREFS", Context.MODE_PRIVATE);
        preferences.edit().clear().commit();
        startActivity(new Intent(getActivity(), LoginActivity.class));
        getActivity().finish();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.logout_yes){
            logout();
        }
    }
}