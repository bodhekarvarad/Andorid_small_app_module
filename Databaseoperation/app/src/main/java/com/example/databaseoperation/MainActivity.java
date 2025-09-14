package com.example.databaseoperation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name,roll;
    MyDatabase mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdb=new MyDatabase(this);
        name=findViewById(R.id.edname);
        roll=findViewById(R.id.edroll);
    }

    public void Insert(View view) {
       String msg= mdb.insertData(roll.getText().toString(),name.getText().toString());
        Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT).show();

    }

    public void Read(View view) {
        String str=mdb.readData();
        Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

    }

    public void Update(View view) {
        if(roll.getText().toString().trim().isEmpty()||name.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this, "Not Updated", Toast.LENGTH_SHORT).show();

        }
        else {
            String msg=mdb.updateData(roll.getText().toString(),name.getText().toString());
            Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
        }
    }

    public void Delete(View view) {
        if(roll.getText().toString().trim().isEmpty())
        {
            Toast.makeText(this,"Not Deleted",Toast.LENGTH_SHORT).show();
        }
        else {
            String msg = mdb.deleteData(roll.getText().toString());
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}