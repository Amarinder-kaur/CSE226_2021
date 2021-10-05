package com.example.cse226_2021;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class P12chargerconnected extends BroadcastReceiver {
    @Override
    //Whenever the event for which the receiver is registered occurs, onReceive() is called.
//in this the receiver is registered to Intent.ACTION_POWER_CONNECTED or Intent.ACTION_POWER_DISCONNECTED
// event. As soon as the Power connected or disconnected, this onReceive() method is called.
/*
 <receiver
            android:name=".P12BootCompletedStatic"
            android:enabled="true"
            android:exported="true">
            <intent-filter> <action android:name="android.intent.action.BOOT_COMPLETED" />     </intent-filter>
        </receiver>

 */
    public void onReceive(Context context, Intent intent) {
        System.out.println("on receive Methodd");


        String intentString = intent.getAction();
        switch (intentString) {
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Power Connected ", Toast.LENGTH_SHORT).show();
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Power Not Connected ", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
//in manifest <receiver android:name=".P12chargerconnected" android:exported="true"/>

