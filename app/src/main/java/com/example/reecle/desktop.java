package com.example.reecle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class desktop extends AppCompatActivity {
    private RadioGroup monitor,storageSize,chipset,ram,accesories;
    private RadioButton monitorRadio,storageSizeRadio,chipsetRadio,ramRadio,accesoriesRadio;
    private Button submit,accept;
    DatabaseReference rootRef,demoRef;

    TextView content;
    int price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop);

        getSupportActionBar().setTitle("Desktop details");
        //scrollView = (ScrollView) findViewById(R.id.scrollView);
        addListenerOnButton();

    }
    public void addListenerOnButton() {

        monitor = (RadioGroup) findViewById(R.id.radioGroup);
        storageSize = (RadioGroup) findViewById(R.id.radioGroup1);
        chipset = (RadioGroup) findViewById(R.id.radioGroup2);
        ram = (RadioGroup) findViewById(R.id.radioGroup3);
        accesories = (RadioGroup) findViewById(R.id.radioGroup4);
        submit = (Button) findViewById(R.id.button);

        rootRef = FirebaseDatabase.getInstance().getReference();

        final LinearLayout layout1 = (LinearLayout) findViewById(R.id.layout1);
        layout1.setVisibility(View.VISIBLE);

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


                demoRef = rootRef.child("OTHER APPLIANCES/DESKTOP/");
                demoRef.child("price").addListenerForSingleValueEvent(new ValueEventListener() {

                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //progressBar.setVisibility(View.VISIBLE);
                        int value = Integer.valueOf(String.valueOf(dataSnapshot.getValue()));
                        price = value;
                        int selectedId = monitor.getCheckedRadioButtonId();
                        switch (selectedId) {
                            case R.id.radioButton1:
                                price = price - 100;
                                break;
                            case R.id.radioButton2:
                                price = price - 50;
                                break;
                            case R.id.radioButton3:
                                price = price + 1;
                                break;
                        }
                        int selectedId1 = storageSize.getCheckedRadioButtonId();
                        switch (selectedId1) {
                            case R.id.radioButton4:
                                price = price - 50;
                                break;
                            case R.id.radioButton5:
                                price = price + 1;
                                break;
                            case R.id.radioButton6:
                                price = price - 100;
                                break;
                        }
                        int selectedId3 = chipset.getCheckedRadioButtonId();
                        switch (selectedId3) {
                            case R.id.radioButton7:
                                price = price + 1;
                                break;
                            case R.id.radioButton8:
                                price = price - 50;
                                break;

                        }
                        int selectedId4 = ram.getCheckedRadioButtonId();
                        switch (selectedId4) {
                            case R.id.radioButton10:
                                price = price - 50;
                                break;
                            case R.id.radioButton11:
                                price = price + 1;
                                break;
                            case R.id.radioButton12:
                                price = price - 100;
                                break;
                        }
                        int selectedId5 = accesories.getCheckedRadioButtonId();


                        switch (selectedId5) {
                            case R.id.radioButton13:
                                price = price + 1;
                                break;
                            case R.id.radioButton14:
                                price = price + 50;
                                break;
                            case R.id.radioButton15:
                                price = price - 100;
                                break;

                        }

                        if (selectedId == -1 || selectedId1 == -1 || selectedId3 == -1 || selectedId4 == -1 || selectedId5 == -1) {
                            Toast.makeText(desktop.this , "Please Select All The Conditions." , Toast.LENGTH_SHORT).show();
                        } else {
                            setContentView(R.layout.layout2);
                            getSupportActionBar().setTitle("Desktop Price");
                            content = (TextView) findViewById(R.id.content);
                            content.setText(String.valueOf("Rs" + price + "/-"));
                            accept = (Button) findViewById(R.id.Accept);


                            accept.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    String brand ="-";
                                    String category = "Desktop";
                                    String price=content.getText().toString().trim();
                                    Intent intent = new Intent(getApplicationContext(), location.class);
                                    intent.putExtra("brand",brand);
                                    intent.putExtra("category",category);
                                    intent.putExtra("price",price);
                                    startActivity(intent);                                }
                            });

                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(desktop.this , "" , Toast.LENGTH_SHORT).show();
                    }
                });


            }


        });


    }
}
