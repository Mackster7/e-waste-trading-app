package com.example.reecle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;
import java.text.CollationElementIterator;
import java.util.HashMap;

public class smartphone extends AppCompatActivity {
    final String[] brands = {"apple","mi","nokia","realme","samsung"};
    final String[] series ={"a4"," mix 3","note 5pro","note4","1100","3310","nokia 3","nokia 6","nokia 8","j2","j7","note 6","s7","s6 edge","iphone 4","iphone 5","iphone 6","iphone 7","iphone 8","iphone x"};

        Button fetch,accept;
        TextView content;
        AutoCompleteTextView oneamp,twoamp;
        String model;
        DatabaseReference rootRef,demoRef,demoref;
    private ProgressBar progressBar;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smartphone);
        getSupportActionBar().setTitle("Smartphone details");

            ArrayAdapter<String> adapter = new ArrayAdapter<String>
                    (this, android.R.layout.simple_dropdown_item_1line, brands);
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>
                    (this, android.R.layout.simple_dropdown_item_1line, series);

            final LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
            layout1.setVisibility(View.VISIBLE);
            final LinearLayout layout2 = (LinearLayout) findViewById(R.id.layout2);
            layout2.setVisibility(View.GONE);
        fetch=(Button) findViewById(R.id.fetchDocument);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

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

                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(smartphone.this, "Please Enter Brand", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(model)) {
                    Toast.makeText(smartphone.this, "Please Enter Model", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                demoref.child("price").addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //progressBar.setVisibility(View.VISIBLE);
                        String value = dataSnapshot.getValue(String.class);
                        content.setText(value);
                        if(value==null){
                            progressBar.setVisibility(View.GONE);
                            Toast.makeText(smartphone.this, "Please Select model with appropriate brand", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            progressBar.setVisibility(View.GONE);
                            fetch.setVisibility(View.GONE);
                            layout2.setVisibility(View.VISIBLE);
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(smartphone.this , "enter correct model name and brand" , Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String brand = oneamp.getText().toString().trim();
                String category = "Smartphone";
                String price=content.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(), location.class);
                intent.putExtra("brand",brand);
                intent.putExtra("category",category);
                intent.putExtra("price",price);
                startActivity(intent);
            }
        });

    }


}


