package com.example.congitivetech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

public class Screen3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        ListView lstview=findViewById(R.id.list);
        // Inflate header view
        ViewGroup headerView = (ViewGroup)getLayoutInflater().inflate(R.layout.header, lstview,false);
        // Add header view to the ListView
        lstview.addHeaderView(headerView);
        // Get the string array defined in strings.xml file
        String[] items=getResources().getStringArray(R.array.items);
        // Create an adapter to bind data to the ListView
        LstAdapter adapter=new LstAdapter(this,R.layout.row_layout,R.id.attempts,items);
        // Bind data to the ListView
        lstview.setAdapter(adapter);
    }
}
