package com.example.servicetest;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import android.os.RemoteException;



public class AIDLService extends Service {

    private IBinder binder = new PersonQueryBinder();
    private String[] names = {"chubby","boy","girl","june","shaddy"};

    private String query(int num)
    {
        if(num > 0 && num < 6){
            return names[num - 1];
        }
        return null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final class PersonQueryBinder extends IPerson.Stub {
        @Override
        public String queryPerson(int num) throws RemoteException {
            return query(num);
        }
    }
}