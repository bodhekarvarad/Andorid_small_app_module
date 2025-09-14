package com.example.sendmessageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edit,edit1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.btn);
         edit=(EditText)findViewById(R.id.message);
         edit1=(EditText)findViewById(R.id.number);

        b.setOnClickListener(this);
    }
    public void onClick(View v) {

        String msg= edit.getText().toString();
        String number= edit1.getText().toString();

        SmsManager sms=SmsManager.getDefault();
        sms.sendTextMessage(number,null,msg,null,null);
        Toast.makeText(this,"Sending....",Toast.LENGTH_SHORT).show();


    }
}
