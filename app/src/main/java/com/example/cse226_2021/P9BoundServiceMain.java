package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Toast;
//youtube video music app+bounded service
//https://www.youtube.com/watch?v=r7jIalkrSCw
// for details: https://www.stechies.com/bound-service-example-android/
/*In the onStart() method of the MainActivity class, you start the bound service using
 the bindService() method. You need to pass an Intent instance, a ServiceConnection
 instance, and a binding flag.
 With the intent object, you can specify the bound service to start and data to be
 passed to the service.

 The ServiceConnection object create a connection between the MainActivity and the
    BoundService. You can get the BoundService instance from the ServiceConnection object.
     As a sequence, you are able to call the downloadFile() of the bound service in the MainActivity.

      The BIND_AUTO_CREATE tells the system to create the service instance automatically
       as long as the binding exists.

     In the onStop() method, you call the unbindService() method to unbind the activity
     from the service when the activity stops.
  */


public class P9BoundServiceMain extends AppCompatActivity {
    // Binder given to clients
    P9MyBoundService boundService;
    //boolean variable to keep a check on service bind and unbind event
    boolean flag = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p9_bound_service_main);
    //    Intent i2 = new Intent(this, P9MyBoundService.class);
        //start service with binding
      //  bindService(i2, sc, Context.BIND_AUTO_CREATE);
    }
    public void firstmsg(View view)
    {
        Toast.makeText(P9BoundServiceMain.this, boundService.getMsg1(), Toast.LENGTH_SHORT).show();
   }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (flag) {
            //unbind service
            unbindService(sc);
            flag = false;
        }
    }
//ServiceConnection Interface for monitoring the state of an application service.
    ServiceConnection sc = new ServiceConnection() {
        /*we need to write some code and in the first line you need to create our lower binder
         object and cast it lower binder with the service instance. And in the 'onservice disconnected' method we want to make our
         flag variable as false.
         */
      //Called when a connection to the Service has been established, with the IBinder of the communication channel to the Service.
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            P9MyBoundService.MyBinder myBinder = (P9MyBoundService.MyBinder) iBinder;
            boundService = myBinder.getService1();
            flag = true;
        }
        //Called when a connection to the Service has been lost.
        @Override
        public void onServiceDisconnected(ComponentName componentName)
        {
            flag = false;
        }
    };
}