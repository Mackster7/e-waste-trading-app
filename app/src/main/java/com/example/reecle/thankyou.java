package com.example.reecle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

import java.util.Timer;
import java.util.TimerTask;

public class thankyou extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
        getSupportActionBar().hide();
 //timming
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {

            public void run() {

                //here you can start your Activity B.
                startActivity(new Intent(thankyou.this, signup.class));

            }

        }, 5000);
    }
}
