package com.example.bluetooth_function;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    public BluetoothAdapter mBtadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtadapter = BluetoothAdapter.getDefaultAdapter();
    }
}