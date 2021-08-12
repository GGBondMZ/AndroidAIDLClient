package com.mz.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.mz.myapplication.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {

    private IMyAidlInterface mIMyAidlInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        //intent.setPackage("com.mz.myapplication");
        intent.setClassName("com.mz.myapplication", "com.mz.myapplication.MyService");
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);

    }

    ServiceConnection mServiceConnection;

    {
        mServiceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mIMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
                Log.e("MAZHUANG","MAZHUANG" + mIMyAidlInterface);
                try {
                    Log.e("MAZHUANG",mIMyAidlInterface.getName());
                    Log.e("MAZHUANG",mIMyAidlInterface.getName());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {

            }
        };
    }
}