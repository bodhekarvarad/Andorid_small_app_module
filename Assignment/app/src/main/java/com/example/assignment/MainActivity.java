package com.example.assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText sroll, sname, sbranch, smarks, sper;
    Button sub;
    TableLayout tb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sroll = (EditText) findViewById(R.id.eroll);
        sname = findViewById(R.id.ename);
        sbranch = findViewById(R.id.ebrach);
        smarks = findViewById(R.id.emarks);
        sper = findViewById(R.id.eper);
        sub = findViewById(R.id.b1);
        tb = findViewById(R.id.tb);

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentinformation();

            }
        });
    }

        public void studentinformation () {
            String roll = sroll.getText().toString();
            String name = sname.getText().toString();
            String branch = sbranch.getText().toString();
            String marks = smarks.getText().toString();
            String per = sper.getText().toString();

            //Create a table row
            TableRow row = new TableRow(this);
            TextView troll = new TextView(this);
            TextView tname = new TextView(this);
            TextView tbranch = new TextView(this);
            TextView tmarks = new TextView(this);
            TextView tper = new TextView(this);

            troll.setText(roll);
            troll.setPadding(8, 8, 8, 8);
            row.addView(troll);

            tname.setText(name);
            tname.setPadding(8, 8, 8, 8);
            row.addView(tname);

            tbranch.setText(branch);
            tbranch.setPadding(8, 8, 8, 8);
            row.addView(tbranch);

            tmarks.setText(marks);
            tmarks.setPadding(8, 8, 8, 8);
            row.addView(tmarks);

            tper.setText(per);
            tper.setPadding(8, 8, 8, 8);
            row.addView(tper);

            tb.addView(row);

            tb.setVisibility(View.VISIBLE);

        }
    }

