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
               Intent intent2=new Intent(getApplicationContext(),tablet.class);
               Intent intent3=new Intent(getApplicationContext(),tv.class);
               Intent intent4=new Intent(getApplicationContext(),ac.class);
               Intent intent5=new Intent(getApplicationContext(),refridgerator.class);
               Intent intent6=new Intent(getApplicationContext(),desktop.class);
               Intent intent7=new Intent(getApplicationContext(),washingmachine.class);
               if(position==0)
                   startActivity(intent);
               if(position==1)
                   startActivity(intent1);
               if(position==2)
                   startActivity(intent2);
                if(position==3)
                    startActivity(intent3);
                if(position==4)
                    startActivity(intent4);
                if(position==5)
                    startActivity(intent5);
               if(position==6)
                    startActivity(intent6);
                if(position==7)
                    startActivity(intent7);

            }
        });
        }

    }

