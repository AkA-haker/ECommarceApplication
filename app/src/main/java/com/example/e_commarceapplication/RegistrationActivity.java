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

public class RegistrationActivity extends AppCompatActivity {
    TextInputLayout name_space, email_space, password_space, confirmPassword_space;
    private TextInputEditText name_reg, email_reg, password_reg, confirmPassword_reg;
    private AppCompatButton registrationBtn;
    private TextView signIn;
    DBHalper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        name_reg = findViewById(R.id.text_view_name_registration);
        email_reg = findViewById(R.id.text_view_email_registration);
        password_reg = findViewById(R.id.text_view_password_registration);
        confirmPassword_reg = findViewById(R.id.text_view_conferm_password_registration);
        registrationBtn = findViewById(R.id.button_registration);
        signIn = findViewById(R.id.text_view_sign_in_registration);
        name_space = findViewById(R.id.text_layout_name);
        email_space = findViewById(R.id.text_layout_email);
        password_space = findViewById(R.id.text_layout_password_registration);
        confirmPassword_space = findViewById(R.id.text_layout_conferm_password_registration);
        DB = new DBHalper(this);

        registrationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = name_reg.getText().toString();
                String email = email_reg.getText().toString();
                String password = password_reg.getText().toString();
                String confirmPassword = confirmPassword_reg.getText().toString();
                if (name.equals("")) {
                    name_space.setError("Enter Full Name");
                } else {
                    name_space.setErrorEnabled(false);
                }
                if (password.equals("")) {
                    password_space.setError("Enter password");
                } else {
                    password_space.setErrorEnabled(false);
                }

                if (confirmPassword.equals("")) {
                    confirmPassword_space.setError("Enter password");
                } else {
                    confirmPassword_space.setErrorEnabled(false);
                }

                if (email.equals("")) {
                    email_space.setError("Enter Email");
                } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    email_space.setError("Enter Valid Email");
                } else {
                    email_space.setErrorEnabled(false);
                    if (!password.equals("") && password.equals(confirmPassword)) {
                        Boolean checkuser = DB.checkEmail(email);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(email, password);
                            if (insert == true) {
                                Toast.makeText(RegistrationActivity.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                                finish();

                            } else {
                                Toast.makeText(RegistrationActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(RegistrationActivity.this, "User already exist! Please log in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(RegistrationActivity.this, "Password did not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LogInActivity.class));
                finish();
            }
        });


    }
}