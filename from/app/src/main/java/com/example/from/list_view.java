package com.example.from;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.*;


public class list_view extends AppCompatActivity {
    TextView tv;
    ListView lv;
    String []country={"India","France","Japan","Butan","Nepal"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);
        tv=findViewById(R.id.tv);
        lv=findViewById(R.id.lv);
        ArrayAdapter ad=new ArrayAdapter(getApplicationContext(),R.layout.list_view,R.id.tv,country);
        lv.setAdapter(ad);
    }
}