package com.example.reecle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class signup extends AppCompatActivity {
GridView gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        getSupportActionBar().setTitle("Reecle");
        gridview =(GridView) findViewById(R.id.grid_view);
        gridview.setAdapter(new imageAdapter(this));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               Intent intent=new Intent(getApplicationContext(),smartphone.class);
               Intent intent1=new Intent(getApplicationContext(),laptop.class);
               if(position==0)
                startActivity(intent);
               if(position==1)
                   startActivity(intent1);

            }
        });
        }

    }

