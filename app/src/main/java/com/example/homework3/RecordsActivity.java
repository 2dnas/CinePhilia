package com.example.homework3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Objects;

public class RecordsActivity extends AppCompatActivity {
    String NAME_CODE = "name";
    int soldTicketNumber = 1;

    Button buyButton;
    TextView ticketsLeft;

    RecyclerViewAdapter adapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_records);
        Objects.requireNonNull(getSupportActionBar()).hide();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        buyButton = findViewById(R.id.buyButton);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList list = new ArrayList<Movie>();
        list.add(new Movie("Dark Knight", R.drawable.dark_knight));
        list.add(new Movie("Dead Pool", R.drawable.dead_pool));
        list.add(new Movie("Eight Mile", R.drawable.eight_mile));
        list.add(new Movie("Fight Club", R.drawable.fight_club));
        list.add(new Movie("Forrest Gump", R.drawable.forrest_gump));
        list.add(new Movie("Joker", R.drawable.joker));
        list.add(new Movie("Seven", R.drawable.seven));
        list.add(new Movie("Shutter Island", R.drawable.shutter_island));


        adapter = new RecyclerViewAdapter(list);




        recyclerView.setAdapter(adapter);




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


    public void buyTicket(View view){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue(soldTicketNumber);
        if(soldTicketNumber == 30){
            Toast.makeText(this, "All the Tickets have been sold ", Toast.LENGTH_SHORT).show();

        }else {
            soldTicketNumber++;
        }

        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                int value = dataSnapshot.getValue(int.class);


            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TAG", "Failed to read value.", error.toException());
            }
        });
    }


}