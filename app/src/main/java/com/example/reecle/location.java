package com.example.reecle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class location extends AppCompatActivity {
    EditText name,street,area,doorno,city,pincode;
    Button pickup;
    private FirebaseFirestore db;
    private FirebaseAuth firebaseAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);
        getSupportActionBar().setTitle("Location details");
        name = (EditText) findViewById(R.id.name);
        street = (EditText) findViewById(R.id.street);
        area = findViewById(R.id.area);
        doorno = findViewById(R.id.doorno);
        pickup = (Button) findViewById(R.id.pickup);
        city =findViewById(R.id.city);
        pincode=findViewById(R.id.pincode);

        db = FirebaseFirestore.getInstance();

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        pickup.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String name1 = name.getText().toString().trim();
                String street1 = street.getText().toString().trim();
                String area1 = area.getText().toString().trim();
                String doorno1 = doorno.getText().toString().trim();
                String city1 = city.getText().toString().trim();
                String pincode1 = pincode.getText().toString().trim();


                if (TextUtils.isEmpty(name1)&&TextUtils.isEmpty(street1)&&TextUtils.isEmpty(area1)&&TextUtils.isEmpty(doorno1)&&TextUtils.isEmpty(city1)&&TextUtils.isEmpty(pincode1)) {
                    Toast.makeText(location.this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (pincode1.length() != 6 ) {
                    Toast.makeText(location.this, "enter correct pincode", Toast.LENGTH_SHORT).show();
                }

                else{progressBar.setVisibility(View.VISIBLE);
                    if (!validateInputs(name1 , street1 , area1 , doorno1, city1, pincode1)) {

                    CollectionReference dbProducts = db.collection("products");

                    Product product = new Product(
                            name1 ,
                            street1 ,
                            doorno1 ,
                            city1,
                            area1,
                            pincode1
                    );

                    dbProducts.add(product)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Toast.makeText(location.this , "Product Added" , Toast.LENGTH_LONG).show();
                                    startActivity(new Intent(getApplicationContext(), thankyou.class));

                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(location.this , e.getMessage() , Toast.LENGTH_LONG).show();
                                }
                            });

                }}

            }

            private boolean validateInputs(String name1 , String street1 , String area1 , String doorno1,String city1,String pincode1) {
                return false;
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }

}
