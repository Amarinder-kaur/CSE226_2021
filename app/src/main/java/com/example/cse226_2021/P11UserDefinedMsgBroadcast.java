package com.example.cse226_2021;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class P11UserDefinedMsgBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("API12333333",""+intent.getAction());
        if(intent.getAction().equals("com.example.cse226_2021.SOME_ACTION"))
            Toast.makeText(context, "SOME_ACTION is received", Toast.LENGTH_LONG).show();
    }

}
//https://alexzh.com/android-battery-status-use-broadcastreceiver/
