package com.example.cse226_2021;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
/*this is static Broadcast receiver because Registering is don ein manifest
so when  ur system will complete its boot process then run this onReceive method
and run the intent part and display the P3CustomGridViewImages
*/
public class P12BootCompletedStatic extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if(action != null) {
            if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)){
                Toast.makeText(context,"Welcome after Boot Process",Toast.LENGTH_LONG).show();
                Intent i = new Intent(context, P3CustomGridViewImages.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
        }

        }
    }


}
