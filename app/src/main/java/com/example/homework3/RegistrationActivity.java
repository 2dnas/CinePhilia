package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class RegistrationActivity extends AppCompatActivity {
    String NAME_CODE = "name";


    EditText registrationName,registrationLocation,registrationPassword,registrationPasswordConfirm,registrationPhone;
    Button registrationButton;
    Database database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Objects.requireNonNull(getSupportActionBar()).hide();

        registrationName = findViewById(R.id.registrationName);
        registrationPassword = findViewById(R.id.registrationPassword);
        registrationPasswordConfirm = findViewById(R.id.confirmPassword);
        registrationPhone = findViewById(R.id.registrationMobile);

        database = new Database(this);

    }

    public void Registration(View view) {
        String name = registrationName.getText().toString();
        String password = registrationPassword.getText().toString();
        String confirmPassword = registrationPasswordConfirm.getText().toString();
        String phone = registrationPhone.getText().toString();

        if(!password.equals(confirmPassword)){
            Toast.makeText(this, "Password doesn't match", Toast.LENGTH_SHORT).show();
            return;
        }

        database.saveUser(name,password,phone);

        Toast.makeText(this, "You are successfully registered", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(RegistrationActivity.this,RecordsActivity.class);
        intent.putExtra(NAME_CODE,name);
        startActivity(intent);

    }
}