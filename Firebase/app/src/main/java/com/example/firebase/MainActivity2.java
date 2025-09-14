package com.example.firebase;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.*;

import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

public class MainActivity2 extends AppCompatActivity {
    TextView user;
    TextView password;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        user=findViewById(R.id.utxt);
        password=findViewById(R.id.passtxt);
        //userId=fAuth.getCurrentUser()
       fAuth=FirebaseAuth.getInstance();
       fStore=FirebaseFirestore.getInstance();
       userId=fAuth.getCurrentUser().getUid();
        DocumentReference df=fStore.collection("users").document(userId);
        df.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {
                user.setText(value.getString("user"));
                password.setText(value.getString("Password"));

            }
        });

            }
}