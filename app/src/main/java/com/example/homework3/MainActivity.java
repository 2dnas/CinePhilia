package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.firestore.FirebaseFirestore;

import java.security.DomainCombiner;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    String NAME_CODE = "name";

    EditText mobileEditText, passwordEditText;
    Button signInButton, SignUpButton;
    Database database;

    FirebaseFirestore db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();

        database = new Database(this);

        db = FirebaseFirestore.getInstance();

        mobileEditText = findViewById(R.id.et_mobile);
        passwordEditText = findViewById(R.id.et_password);
        signInButton = findViewById(R.id.button);
        SignUpButton = findViewById(R.id.button2);
    }

    public void signUp(View view) {
        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(intent);
    }

    public void signIn(View view) {
        String phone = database.getUserPhone(mobileEditText.getText().toString());

        if (phone.equals("-1")) {
            Toast.makeText(MainActivity.this, "Wrong Number", Toast.LENGTH_LONG).show();
        } else {
            if (passwordEditText.getText().toString().equals(phone)) {
                Intent intent = new Intent(MainActivity.this, RecordsActivity.class);
                intent.putExtra(NAME_CODE, database.getUserName(mobileEditText.getText().toString()));
                startActivity(intent);
            }
        }
    }
}