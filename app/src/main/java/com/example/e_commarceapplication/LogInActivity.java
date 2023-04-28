package com.example.e_commarceapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class LogInActivity extends AppCompatActivity {
    TextInputLayout email_space_login, password_space_login;
    TextInputEditText email_login;
    TextInputEditText password_login;
    AppCompatButton logInBtn;
    TextView register_text;
    DBHalper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        email_space_login = findViewById(R.id.text_layout_email_log_in);
        password_space_login = findViewById(R.id.text_layout_password_log_in);
        email_login = findViewById(R.id.text_view_email_log_in);
        password_login = findViewById(R.id.text_view_password_log_in);
        logInBtn = findViewById(R.id.button_log_in);
        register_text = findViewById(R.id.text_view_register_log_in);
        DB = new DBHalper(this);


        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_input = email_login.getText().toString();
                String password_input = password_login.getText().toString();
                if (email_input.equals("")) {
                    email_space_login.setError("Enter Email");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email_input).matches()) {
                    email_space_login.setError("Enter Valid Email");

                } else {
                    email_space_login.setErrorEnabled(false);
                }
                if (password_input.equals("")) {
                    password_space_login.setError("Enter password");
                } else {
                    password_space_login.setErrorEnabled(false);
                }
                Boolean checkUserPass = DB.checkEmailPassword(email_input, password_input);
                if (checkUserPass == true) {
                    Toast.makeText(LogInActivity.this, "Sign in Successful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(LogInActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }


            }
        });
        register_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegistrationActivity.class));
                finish();
            }
        });


    }
}