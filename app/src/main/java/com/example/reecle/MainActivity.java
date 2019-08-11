package com.example.reecle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

public class MainActivity extends AppCompatActivity {

    EditText editText1, editText2;
    Button button;
    private ProgressBar progressBar;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Reecle Login");
        firebaseAuth = FirebaseAuth.getInstance();

        button = (Button) findViewById(R.id.button);
        Button button1 = (Button) findViewById(R.id.button1);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editText1.getText().toString().trim();
                String password = editText2.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(MainActivity.this, "Please enter email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "Please enter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                progressBar.setVisibility(View.VISIBLE);
                //create user
                firebaseAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(getApplicationContext(), signup.class));
                                } else {
                                    Toast.makeText(MainActivity.this, "login failed or user not registered", Toast.LENGTH_SHORT).show();
                                }

                                // ...
                            }
                        });

            }
        });

    }

    @SuppressLint("ShowToast")

    public void int2(View view) {
        Intent int2 = new Intent(MainActivity.this, Main2Activity.class);
        startActivity(int2);


    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}


