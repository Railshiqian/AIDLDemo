package com.thundersoft.aidlserverdemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.thundersoft.aidlserverdemo.IMyAidlInterface.Stub;

/**
 * Created by chenzd on 18-11-22.
 */
public class LocalService extends Service {

    private MyServer myServer = null;

    @Override
    public IBinder onBind(Intent intent) {
        Log.w("Test","onBind");
        myServer = new MyServer();
        return myServer;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
