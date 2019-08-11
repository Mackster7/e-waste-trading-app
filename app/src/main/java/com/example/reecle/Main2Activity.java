package com.example.reecle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Main2Activity extends AppCompatActivity {
    EditText txtemail,txtpassword,txtconfirmpassword;
    Button buttonregister;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Reecle Signup");
        setContentView(R.layout.main2);


        txtemail = (EditText)findViewById(R.id.texthint);
        txtpassword=(EditText)findViewById(R.id.editText4);
        txtconfirmpassword=(EditText)findViewById(R.id.editText5);
        buttonregister=findViewById(R.id.button);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        firebaseAuth=FirebaseAuth.getInstance();

        buttonregister.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View v) {
                String email = txtemail.getText().toString().trim();
                String password = txtpassword.getText().toString().trim();
                String confirmpassword = txtconfirmpassword.getText().toString().trim();


                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(Main2Activity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText (Main2Activity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(confirmpassword)) {
                    Toast.makeText(Main2Activity.this, "Please confirm password", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.length() < 6) {
                    Toast.makeText(Main2Activity.this, "password too short", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(Main2Activity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(),signup.class));
                                } else {

                                    Toast.makeText(Main2Activity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });




            }
        }) ;

    }
    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}

