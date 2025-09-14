package com.example.otp_verification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity3 extends AppCompatActivity {
    EditText name, age, last;
    DatabaseReference databaseReference;
    TextView displayData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Initialize EditText fields
        name = findViewById(R.id.name);
        last = findViewById(R.id.last);
        age = findViewById(R.id.age);

        // Initialize the Firebase database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("users");

        // Initialize TextView to display fetched data
        displayData = findViewById(R.id.displayData);

        // Read data from Firebase Realtime Database
        readDataFromFirebase();
    }

    // Method to handle button click event
    public void enter(View view) {
        // Get values from EditText fields
        String nameValue = name.getText().toString();
        String ageValue = age.getText().toString();
        String lastNameValue = last.getText().toString();

        // Create a unique key for each user
        String userId = databaseReference.push().getKey();

        // Create a User object
        User user = new User(nameValue, ageValue, lastNameValue);

        // Write user object to the database
        databaseReference.child(userId).setValue(user);
    }

    // Method to read data from Firebase Realtime Database
    private void readDataFromFirebase() {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                StringBuilder data = new StringBuilder();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    User user = snapshot.getValue(User.class);
                    if (user != null) {
                        data.append("Name: ").append(user.getName()).append(", ")
                                .append("Age: ").append(user.getAge()).append(", ")
                                .append("Last Name: ").append(user.getLastName()).append("\n");
                    }
                }
                displayData.setText(data.toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle errors here
            }
        });
    }
}
