package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private Button mSavedButton;
    private ProgressDialog pd;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setTitle("Add Data");
        }

        user = findViewById(R.id.editTextUsername);
        password = findViewById(R.id.editTextPassword);
        mSavedButton = findViewById(R.id.buttonLogin);
        pd = new ProgressDialog(this);
        db = FirebaseFirestore.getInstance();

        mSavedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = user.getText().toString().trim();
                String des = password.getText().toString().trim();
                uploadData(title, des);
            }
        });
    }

    private void uploadData(String title, String des) {
        pd.setTitle("Adding Data to Firestore");
        pd.show();
        String id = UUID.randomUUID().toString();
        Map<String, Object> doc = new HashMap<>();
        doc.put("id", id);
        doc.put("title", title);
        doc.put("description", des);

        db.collection("Documents").document(id).set(doc)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        pd.dismiss();
                        Toast.makeText(MainActivity.this, "Uploaded....", Toast.LENGTH_SHORT).show();
                        // Start the new activity here
                        Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                        startActivity(intent);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        pd.dismiss();
                        Toast.makeText(MainActivity.this, "Failed to upload: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
