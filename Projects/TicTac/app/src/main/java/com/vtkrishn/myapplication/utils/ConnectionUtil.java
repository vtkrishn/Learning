package com.vtkrishn.myapplication.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


/**
 * Created by vtkrishn on 1/17/2015.
 */
public final class ConnectionUtil {
    /**
     * Check if the connection is available for the mobile
     */
    public static boolean checkInternetConnection(Context context){
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivity != null){
            NetworkInfo[] network = connectivity.getAllNetworkInfo();
            if(network != null){
                for(int i=0;i<network.length; i++){
                    if(network[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
