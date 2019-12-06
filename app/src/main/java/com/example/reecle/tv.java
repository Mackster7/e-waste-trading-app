package com.example.reecle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class tv extends AppCompatActivity  implements AdapterView.OnItemSelectedListener{
    private RadioGroup type,capacity;
    private RadioButton typeRadio,capacityRadio;
    private Button submit,accept;
    DatabaseReference rootRef,demoRef;
    Spinner spinner;
    TextView content;
    int price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tv);

        getSupportActionBar().setTitle("TV details");

        Spinner spinner = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tv, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


        addListenerOnButton();
    }
    public void addListenerOnButton() {

        type = (RadioGroup) findViewById(R.id.radioGroup);
        capacity = (RadioGroup) findViewById(R.id.radioGroup1);
        submit = (Button) findViewById(R.id.button);
        spinner=(Spinner) findViewById(R.id.spinner1);


        rootRef = FirebaseDatabase.getInstance().getReference();


        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                demoRef = rootRef.child("OTHER APPLIANCES/TV/");
                demoRef.child("price").addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //progressBar.setVisibility(View.VISIBLE);
                        int value = Integer.valueOf(String.valueOf(dataSnapshot.getValue()));
                        price = value;
                        int selectedId = type.getCheckedRadioButtonId();
                        int selectedId1 = capacity.getCheckedRadioButtonId();
                        switch (selectedId) {
                            case R.id.radioButton1:
                                price = price - (price*50)/100;
                                switch (selectedId1) {
                                    case R.id.radioButton4:
                                        price = price + 50;
                                        break;
                                    case R.id.radioButton5:
                                        price = price + 100;
                                        break;
                                    case R.id.radioButton6:
                                        price = price + 150;
                                        break;
                                    case R.id.radioButton7:
                                        price = price + 200;
                                        break;
                                    case R.id.radioButton8:
                                        price = price + 250;
                                        break;
                                    case R.id.radioButton9:
                                        price = price + 300;
                                        break;
                                }
                                break;
                            case R.id.radioButton2:
                                price = price  - (price*25)/100;

                                switch (selectedId1) {
                                    case R.id.radioButton4:
                                        price = price + 60;
                                        break;
                                    case R.id.radioButton5:
                                        price = price + 120;
                                        break;
                                    case R.id.radioButton6:
                                        price = price + 180;
                                        break;
                                    case R.id.radioButton7:
                                        price = price + 240;
                                        break;
                                    case R.id.radioButton8:
                                        price = price + 300;
                                        break;
                                    case R.id.radioButton9:
                                        price = price + 360;
                                        break;
                                }
                                break;
                            case R.id.radioButton3:
                                price = price +1;

                                switch (selectedId1) {
                                    case R.id.radioButton4:
                                        price = price + 70;
                                        break;
                                    case R.id.radioButton5:
                                        price = price + 140;
                                        break;
                                    case R.id.radioButton6:
                                        price = price + 210;
                                        break;
                                    case R.id.radioButton7:
                                        price = price + 280;
                                        break;
                                    case R.id.radioButton8:
                                        price = price + 350;
                                        break;
                                    case R.id.radioButton9:
                                        price = price + 420;
                                        break;
                                }
                                break;
                        }

                        String brand=spinner.getSelectedItem().toString();
                        RadioButton mini=(RadioButton)findViewById(R.id.radioButton1);

                        if(brand.equals("Select Brand")){
                            Toast.makeText(tv.this , "Select a Brand." , Toast.LENGTH_SHORT).show();
                            return;
                        }
                        else if(brand.equals("Other") || mini.isChecked()){
                            price=price+1;
                        }
                        else
                        {
                            price=price+200;
                        }

                        if (selectedId == -1 || selectedId1 == -1 ) {
                            Toast.makeText(tv.this , "Please Select All The Conditions." , Toast.LENGTH_SHORT).show();
                        }

                        else {
                            setContentView(R.layout.layout2);
                            getSupportActionBar().setTitle("TV Price");
                            content = (TextView) findViewById(R.id.content);
                            content.setText(String.valueOf("Rs" + price + "/-"));
                            accept = (Button) findViewById(R.id.Accept);


                            accept.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    startActivity(new Intent(getApplicationContext() , location.class));
                                }
                            });

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(tv.this , "" , Toast.LENGTH_SHORT).show();
                    }
                });


            }


        });


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView , View view , int i , long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
