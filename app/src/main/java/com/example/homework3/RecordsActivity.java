package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.AlphabeticIndex;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class RecordsActivity extends AppCompatActivity {
    String NAME_CODE = "name";


    Database database;
    ListView listView;
    ArrayList recordsList;
    ArrayAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);

        listView = findViewById(R.id.listview);
        recordsList = new ArrayList();
        arrayAdapter = new ArrayAdapter(RecordsActivity.this, android.R.layout.simple_list_item_1,recordsList);
        listView.setAdapter(arrayAdapter);


        database = new Database(this);

        String user = database.userAllInfo(getIntent().getStringExtra(NAME_CODE));
        String[] userString = user.split(" ");
        recordsList.addAll(Arrays.asList(userString));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void logout(MenuItem item) {
        Intent intent = new Intent(RecordsActivity.this,MainActivity.class);
        startActivity(intent);
    }
}