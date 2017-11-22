package com.example.busko.androidref;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class PlayerService extends Service {
    public PlayerService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        //throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        play();
        return START_NOT_STICKY;

    }

    //falta implementar stop() y stopMusic();



    private void play(){
        Log.i(getClass().getSimpleName(),"Service_play");
    }

    private void stop(){
        Log.i(getClass().getSimpleName(),"Service_stop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(getClass().getSimpleName(),"Service_destroy");
        stopSelf();
    }




}
