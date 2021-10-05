package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//this is called user created message to broadcast.
// for theory: https://alignminds.com/broadcast-announcements-broadcast-receiver-in-android/
//intent filters restrict a component to respond to only certain kinds of implicit intents
public class P11BroadCastManifest extends AppCompatActivity {
    IntentFilter intentFilter;
    P11UserDefinedMsgBroadcast receiver;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p11_broad_cast_manifest);
        b1 = (Button) findViewById(R.id.button);

        receiver = new P11UserDefinedMsgBroadcast();
        intentFilter = new IntentFilter("com.example.cse226_2021.SOME_ACTION");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent("com.example.cse226_2021.SOME_ACTION");
                sendBroadcast(intent);
            }
        });


    }
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(receiver);

    }


}

/*when we add this in manifest and create corresponding BroadcastReceiver(another class extends BroadcastReciever.
 This concept is called static Broadcast
 this is working on earlier versions of apk25 or we can say  not working on 26 and advance versions of 26.
 <receiver
            android:name=".P10ChargerConnectedReceiver"
            android:exported="true">
            <intent-filter>
                <action android:name="android.intent.action.ACTION_POWER_CONNECTED"></action>
                <action android:name="android.intent.action.ACTION_POWER_DISCONNECTED"></action>
            </intent-filter>

        </receiver>


 */
