package com.example.projectaad;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email, password;

    @SuppressLint("CutPasteId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.registerPassword);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView textLogin = findViewById(R.id.textLogin);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        textLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });

    }

    private void register() {
        String user = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (user.isEmpty()){
            email.setError("Email cannot be empty");
        }
        if (pass.isEmpty()){
            password.setError("Password cannot be empty");
        }
        else {
            mAuth.createUserWithEmailAndPassword(user, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        Toast.makeText(RegisterActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);
                        intent.putExtra("message_key", pass);
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "Registration Failed: "+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}