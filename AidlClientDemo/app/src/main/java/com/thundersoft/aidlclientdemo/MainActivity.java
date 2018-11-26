package com.thundersoft.aidlclientdemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.thundersoft.aidlserverdemo.IMyAidlInterface;

/**
 * Created by chenzd on 18-11-22.
 */
public class MainActivity extends Activity {
    private IMyAidlInterface myServer = null;
    private boolean isConnected = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        Intent intent = new Intent("com.thundersoft.aidlserverdemo.MyServer");
        intent.setPackage("com.thundersoft.aidlserverdemo");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Toast.makeText(MainActivity.this, myServer.getStr() + "11", Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Log.wtf("Test", e);
                }
            }
        });
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.w("Test", "onServiceConnected");
            isConnected = true;
            myServer = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.w("Test", "onServiceDisconnected");
        }
    };

    @Override
    protected void onDestroy() {
        unbindService(mServiceConnection);
        super.onDestroy();
    }
}
