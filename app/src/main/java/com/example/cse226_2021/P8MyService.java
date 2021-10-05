package com.example.cse226_2021;
//for more details: https://www.tutorialspoint.com/android/android_services.htm
//and https://www.javatpoint.com/android-service-tutorial


//to add overriding methods which are not compulasary as following
//right click--> generate--> override methods
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;
/* add <service android:name=".P8MyService"/> in manifest*/
public class P8MyService extends Service {
    MediaPlayer m1;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;// started service
    }
    @Override
    public void onCreate() {
        super.onCreate();
        m1= MediaPlayer.create(this,R.raw.sun);
        m1.setLooping(false);
    }
    //in latest  versions onStartCommand inspite of onStart
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        m1.start();
        return super.onStartCommand(intent, flags, startId);
    }
  /* below code of old versions
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        m1.start();
    }*/

    @Override
    public void onDestroy() {
        super.onDestroy();
        m1.stop();
    }
}
