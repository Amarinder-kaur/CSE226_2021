package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

public class P12ChargerConnectedBatteryLevelDynamicBroadcast extends AppCompatActivity {
    private BroadcastReceiver mReceiver,mreceiverBattery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p12_charger_connected_dynamic_broadcast);
        mReceiver = new P12chargerconnected();
        mreceiverBattery= new P12BatteryDischarge();
    }
    @Override
    protected void onStart() {
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_POWER_DISCONNECTED));
        registerReceiver(mreceiverBattery,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }
    @Override
    protected void onStop() {
        System.out.println("Onstopp");
        unregisterReceiver(mReceiver);
        unregisterReceiver(mreceiverBattery);
        super.onStop();
    }
}

