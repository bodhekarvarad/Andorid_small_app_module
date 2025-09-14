package com.example.medical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String[] list1={"sanidhya","anurag"};
    String[] list2={"vaibhav","shailesh"};
    AutoCompleteTextView autoCompleteTextView1;
    AutoCompleteTextView autoCompleteTextView2;

    ArrayAdapter<String> arrayItem;
    ArrayAdapter<String> arrayItem1;
    //below for recyclerview
    ArrayList<Contact_model> arrContacts=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    

        arrayItem = new ArrayAdapter<>(this, R.layout.dropdown, list1);
        arrayItem1 = new ArrayAdapter<>(this, R.layout.dropdown_1, list2);

        autoCompleteTextView1.setAdapter(arrayItem);
        autoCompleteTextView2.setAdapter(arrayItem1);
        //form 37 to 47 recyclerview

        RecyclerView recyclerView = findViewById(R.id.view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrContacts.add(new Contact_model(R.drawable.profile_orange, "ABC", "9999999999"));
        arrContacts.add(new Contact_model(R.drawable.images, "ABC", "9999999999"));
        arrContacts.add(new Contact_model(R.drawable.images_2, "ABC", "9999999999"));
        arrContacts.add(new Contact_model(R.drawable.images_3, "ABC", "9999999999"));

        RecyclerMedicalAdapter adapter = new RecyclerMedicalAdapter(this, arrContacts);
        recyclerView.setAdapter(adapter);
    }
}
