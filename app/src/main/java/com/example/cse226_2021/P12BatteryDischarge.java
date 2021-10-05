package com.example.cse226_2021;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.widget.Toast;

public class P12BatteryDischarge extends BroadcastReceiver {
    @Override
    //Whenever the event for which the receiver is registered occurs, onReceive() is called.
//in this the receiver is registered to Intent.ACTION_POWER_CONNECTED or Intent.ACTION_POWER_DISCONNECTED
// event. As soon as the Power connected or disconnected, this onReceive() method is called.

    public void onReceive(Context context, Intent intent) {
        System.out.println("on receive Methodd");


        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
        if(level<= 20)
        Toast.makeText(context, "Battery is low : " +level +"%" , Toast.LENGTH_SHORT).show();

    }
}
//in manifest <receiver android:name=".P12chargerconnected" android:exported="true"/>

