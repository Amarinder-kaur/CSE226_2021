package com.example.cse226_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
/*Android service is a component that is used to perform operations on the
background such as playing music, handle network transactions, interacting content
 providers etc. It doesn't has any UI (user interface). The service runs in the
  background indefinitely even if application is destroyed
 */
/* A started service is one that another component starts by calling startService(),
   which results in a call to the service's onStart() method.

When a service is started, it has a lifecycle that's independent of the
component that started it.The service can run in the background indefinitely,
 even if the component that started it is destroyed. As such, the service
 should stop itself when its job is complete by calling stopSelf(),
 or another component can stop it by calling stopService().*/


//for theory read from https://developer.android.com/guide/components/services
//add service in menifest

// sequence of methods followed by program: onCreate (main activity)
//After click on button(onStartService method called)
//--> onCreate(extends service activity)--> onStart (extends service activity)
// --> click on stop button(onStopService method called)
// -->onStop -->ondestroy

/*Started service

A service is "started" when an application component (such as an activity)
starts it by calling startService(). Once started, a service can run in the
 background indefinitely, even if the component that started it is destroyed.
 Usually, a started service performs a single operation and does not return a
  result to the caller. For example, it might download or upload a file over
   the network. When the operation is done, the service should stop itself.

Bound service
A service is "bound" when an application component binds to it by calling
bindService(). A bound service offers a client-server interface that allows
 components to interact with the service, send requests, get results, and
 even do so across processes with interprocess communication (IPC).
 A bound service runs only as long as another application component is bound
 to it. Multiple components can bind to the service at once, but when all of
 them unbind, the service is destroyed.


 */




/*
You can start a service from an activity or other application component by passing an Intent to startService().
 The Android system calls the service's onStartCommand() method and passes it the Intent , which specifies which service to start.
  */
public class P8MusicService extends AppCompatActivity {
    Button bStart,bStop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p8_music_service);

        bStart=(Button) findViewById(R.id.button2);
        bStop= (Button) findViewById(R.id.button3);
        bStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Start service",Toast.LENGTH_SHORT).show();
                startService(new Intent(getApplicationContext(),P8MyService.class));
            }
        });
        bStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Stop service",Toast.LENGTH_SHORT).show();
                stopService(new Intent(getApplicationContext(),P8MyService.class));
            }
        });


    }
}
