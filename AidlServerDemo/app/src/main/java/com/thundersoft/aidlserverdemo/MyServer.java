package com.thundersoft.aidlserverdemo;

import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

/**
 * Created by chenzd on 18-11-22.
 */
public class MyServer extends IMyAidlInterface.Stub {
    @Override
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString)
            throws RemoteException {
    }

    @Override
    public int getNumber(int a) throws RemoteException {
        return a+1;
    }

    @Override
    public String getStr() throws RemoteException {
        return "from Server app";
    }

}
