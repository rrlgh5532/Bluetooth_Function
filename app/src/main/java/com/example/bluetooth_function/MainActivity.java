package com.example.bluetooth_function;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public BluetoothAdapter mBtadapter;

    private Button btn_checkConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtadapter = BluetoothAdapter.getDefaultAdapter();

        btn_checkConnection = findViewById(R.id.btn_check_Connection);
        btn_checkConnection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,CheckConnectionAcitivity.class);
                startActivity(myIntent);
                finish();
            }
        });
    }
}