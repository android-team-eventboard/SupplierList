package com.example.supplierlist;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


public class LoginActivity extends AppCompatActivity {

    TextView user;
    TextView pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        user = findViewById(R.id.tv_username);
        pwd = findViewById(R.id.tv_password);

        TextView register = (TextView)findViewById(R.id.signUp_text);
        TextView signInButton = (TextView)findViewById(R.id.button_signin);

        register.setMovementMethod(LinkMovementMethod.getInstance());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = user.getText().toString();
                String password = pwd.getText().toString();
                //updateUI(user);
                //signIn(email, password);
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);


            }
        });
    }

   /* public void onStart(){
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }*/

    private boolean validateForm() {
        boolean valid = true;

        String email = user.getText().toString();
        if (TextUtils.isEmpty(email)) {
            user.setError("Required.");
            valid = false;
        } else {
            user.setError(null);
        }

        String password = pwd.getText().toString();
        if (TextUtils.isEmpty(password)) {
            pwd.setError("Required.");
            valid = false;
        } else {
            pwd.setError(null);
        }

        return valid;
    }



}
