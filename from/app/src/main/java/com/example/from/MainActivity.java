package com.example.from;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    ImageButton ca,al;
    DatePickerDialog datePickerDialog;
    EditText date,time;
    TimePickerDialog tp;
    Button country;
   // GridView gv;
    Spinner Sem;
String []sem={"Sem1","Sem2","Sem3","Sem4","Sem5","Sem6"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ca=findViewById(R.id.ca);
        date=findViewById(R.id.Edt1);
        al=findViewById(R.id.alram);
        time=findViewById(R.id.Edt2);

        Sem=findViewById(R.id.sp);
        ArrayAdapter a=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,sem);
        a.setDropDownViewResource(com.google.android.material.R.layout.support_simple_spinner_dropdown_item);
        Sem.setAdapter(a);


        ca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c=Calendar.getInstance();
                int year=c.get(Calendar.YEAR);
                int month=c.get(Calendar.MONTH);
                int Day=c.get(Calendar.DAY_OF_MONTH);
                datePickerDialog=new DatePickerDialog(getApplicationContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        date.setText(dayOfMonth+"/"+month+"/"+year);
                    }
                }, year, month,Day);
                datePickerDialog.show();
            }
        });
        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c=Calendar.getInstance();
                int hour=c.get(Calendar.HOUR);
                int min=c.get(Calendar.MINUTE);
                tp=new TimePickerDialog(getApplicationContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        time.setText(hourOfDay+":"+minute);

                    }
                }, hour,min,true);
                tp.show();




            }
        });


    }

    public void country(View view) {
        Intent i=new Intent(this,list_view.class);
       startActivity(i);
    }

    public void send(View view) {
        ProgressDialog pd=new ProgressDialog(this);
        pd.setIndeterminate(false);
        pd.setProgressStyle(1);
        pd.setProgress(0);
        pd.setMax(100);
        pd.setMessage("Sending a file");
        pd.show();
        Thread d=new Thread()
        {
            int i=0;
            int total=100;
            public void run()
            {
                while (i<total)
                {
                    i=i+2;
                    pd.setProgress(i);
                    if(i==50)
                    {
                        pd.setMessage("Please Wait");
                    }
                    if(i==100) {
                        pd.setMessage("SucessFully");

                    }
                    try{
                        Thread.sleep(200);
                    }
                    catch (Exception e)
                    {

                    }
                }
            }

        };
        d.start();

    }

    public void toggle(View view) {
        LayoutInflater in=getLayoutInflater();
        View v=in.inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.toast));
        Toast t=new Toast(getApplicationContext());
       // t.setText("Hello World");
        t.setDuration(Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER,5,5);
        t.setView(v);
        t.show();
    }


    public void Gallery(View view) {
        Intent i=new Intent(getApplicationContext(),Grid_View.class);
        startActivity(i);
    }


}