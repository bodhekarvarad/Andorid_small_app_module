package com.example.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Contact_model_Room> arrContacts = new ArrayList<>();
    SearchView searchView;
    RecyclerRoomAdapter adapter; // Declare adapter as a member variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.view); // Corrected ID to match XML
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Add sample data
        arrContacts.add(new Contact_model_Room(R.drawable.room_profile, "ABC", "9999999999"));
        arrContacts.add(new Contact_model_Room(R.drawable.room_profile, "DEF", "8888888888"));
        arrContacts.add(new Contact_model_Room(R.drawable.room_profile, "GHI", "7777777777"));
        arrContacts.add(new Contact_model_Room(R.drawable.room_profile, "JKL", "6666666666"));
        arrContacts.add(new Contact_model_Room(R.drawable.room_profile, "JL", "6666666666"));

        // Initialize adapter
        adapter = new RecyclerRoomAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);

        // Initialize SearchView
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filterList(newText);
                return true;
            }
        });
    }

    private void filterList(String text) {
        ArrayList<Contact_model_Room> filteredList = new ArrayList<>();
        for (Contact_model_Room item : arrContacts) {
            if (item.getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        if (filteredList.isEmpty()) {
            Toast.makeText(this, "No data found", Toast.LENGTH_SHORT).show();
        }
        adapter.setFilteredList(filteredList);
    }
}
