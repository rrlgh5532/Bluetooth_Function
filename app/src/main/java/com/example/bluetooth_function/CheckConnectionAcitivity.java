//////

package com.example.bluetooth_function;

import static com.example.bluetooth_function.MainActivity.mBtadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CheckConnectionAcitivity extends AppCompatActivity {

    private ListView listView = null;
    private String seletedItemsName[];
    private boolean seletedItemsflag[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_connection_acitivity);


        listView = findViewById(R.id.lv_check_connection_paird_items);
        List<String> list = new ArrayList<>();


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("hello","position"+position);
                if(seletedItemsflag[position]==false){
                    seletedItemsflag[position]=true;
                    view.setBackgroundColor(Color.YELLOW);
                }else{
                    seletedItemsflag[position]=false;
                    view.setBackgroundColor(Color.WHITE);
                }
            }
        });

        if (mBtadapter == null) {
            // device doesn't support bluetooth
        } else {

            // bluetooth is off, ask user to on it.
            if (!mBtadapter.isEnabled()) {
                Intent enableAdapter = new Intent(mBtadapter.ACTION_REQUEST_ENABLE);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH_CONNECT) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivityForResult(enableAdapter, 0);
            }

            // Do whatever you want to do with your bluetoothAdapter
            Set<BluetoothDevice> all_devices = mBtadapter.getBondedDevices();

            if (all_devices.size() > 0) {
                int i =0;
                seletedItemsName = new String[all_devices.size()+3];
                seletedItemsflag = new boolean[all_devices.size()+3];
                for (BluetoothDevice currentDevice : all_devices) {
                    //log.i("Device Name " + currentDevice.getName());
                    list.add(currentDevice.getName());
                    seletedItemsName[i] = currentDevice.getName();
                }
            }
            list.add("test1");
            list.add("test2");
            list.add("test3");
            adapter.notifyDataSetChanged();
        }

    }
}