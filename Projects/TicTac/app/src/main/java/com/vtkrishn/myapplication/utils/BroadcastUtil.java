package com.vtkrishn.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.vtkrishn.myapplication.MyService;

/**
 * Created by vtkrishn on 1/20/2015.
 */
public class BroadcastUtil {

    public static void broadcast(Activity activity){
        Intent broadcast = new Intent("com.vtkrishn.ACTIVATED");
        broadcast.putExtra("status","active");
        activity.sendBroadcast(broadcast);
    }

    public static void isPowerConnected(Activity activity){
        Intent broadcast = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        broadcast.putExtra("power","connected");
        activity.sendBroadcast(broadcast);
    }
}
