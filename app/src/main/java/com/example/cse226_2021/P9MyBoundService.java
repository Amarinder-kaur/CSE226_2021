package com.example.cse226_2021;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class P9MyBoundService extends Service {
//create our binder interface, give any name to your binder class for example 'binder' and initialize this using our local binder class.
    IBinder binder = new MyBinder();

    public P9MyBoundService() {
    }
//return this instance(binder) from onBind method
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }
   // using binder to indentify the method to invoke and pass the arguments between processes
    // Return this instance of P9BoundService so clients can call public methods
    class MyBinder extends Binder {
        P9MyBoundService getService1() {
            return new P9MyBoundService();
        }
    }
    public String getMsg1() {
        return "My msg1";
    }
   // public String getMsg2() {
     //   return "My msg2";
    //}
}

