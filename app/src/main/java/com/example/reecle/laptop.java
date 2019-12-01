package com.example.reecle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class laptop extends AppCompatActivity {

    final String[] brands = {"Apple","Acer","Dell","lenovo","hp"};
    final String[] series ={"mac book","mac book air","3 series","5 series","7 series"};
    Button fetch,accept;
    TextView content;
    AutoCompleteTextView oneamp,twoamp;
    String model;
    DatabaseReference rootRef,demoRef,demoref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone);
        getSupportActionBar().setTitle("Laptop details");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, brands);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                (this, android.R.layout.simple_dropdown_item_1line, series);
           /* ArrayAdapter<String> adapter2 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_dropdown_item_1line, series1);
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_dropdown_item_1line, series2);
            ArrayAdapter<String> adapter4 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_dropdown_item_1line, series3);*/
        final LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout1.setVisibility(View.VISIBLE);
        final LinearLayout layout2 = (LinearLayout) findViewById(R.id.layout2);
        layout2.setVisibility(View.GONE);
        fetch=(Button) findViewById(R.id.fetchDocument);
        fetch.setVisibility(View.VISIBLE);
        accept=(Button)findViewById(R.id.button2);
        content=(TextView) findViewById(R.id.content);
        oneamp=(AutoCompleteTextView) findViewById(R.id.one);
        oneamp.setThreshold(0);//will start working from first character
        oneamp.setAdapter(adapter);
        oneamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneamp.showDropDown();;
            }
        });
        String val=oneamp.getText().toString().trim();
        twoamp=(AutoCompleteTextView) findViewById(R.id.two);
        twoamp.setThreshold(0);//will start working from first character
        twoamp.setAdapter(adapter1);
        twoamp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoamp.showDropDown();;
            }
        });
        model=twoamp.getText().toString();

        rootRef = FirebaseDatabase.getInstance().getReference();


        fetch.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String name = oneamp.getText().toString().trim();
                String model = twoamp.getText().toString().trim();
                demoRef = rootRef.child(name);
                demoref=demoRef.child(model);

                if (TextUtils.isEmpty(name)&&TextUtils.isEmpty(model)) {
                    Toast.makeText(laptop.this, "Please Enter Make and Model", Toast.LENGTH_SHORT).show();
                    return;
                }
                demoref.child("price").addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //progressBar.setVisibility(View.VISIBLE);
                        String value = dataSnapshot.getValue(String.class);
                        content.setText(value);
                        fetch.setVisibility(View.GONE);
                        layout2.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(laptop.this , "enter correct model name and brand" , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), location.class));
            }
        });

    }

}
