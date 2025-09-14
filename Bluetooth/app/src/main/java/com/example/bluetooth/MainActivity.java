package com.example.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    private static final int BR = 21;
    private static final int BD = 21;
    BluetoothAdapter  ba;
    Set<BluetoothDevice> pairedDevice;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ba=BluetoothAdapter.getDefaultAdapter();
        lv=findViewById(R.id.lv);
    }

    @SuppressLint("MissingPermission")
    public void list(View view) {
        pairedDevice=ba.getBondedDevices();
        ArrayList list=new ArrayList();
        for(BluetoothDevice b:pairedDevice){
            list.add(b.getName());
            Toast.makeText(this, "Showing paired Devices", Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,list);
        lv.setAdapter(adapter);
    }

    @SuppressLint("MissingPermission")
    public void discover(View view) {
        if(!ba.isDiscovering()){
            Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
            startActivityForResult(i,BD);
        }
    }

    @SuppressLint("MissingPermission")
    public void off(View view) {
        ba.disable();
    }

    @SuppressLint("MissingPermission")
    public void on(View view) {
        Intent i=new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(i,BR);
    }
}