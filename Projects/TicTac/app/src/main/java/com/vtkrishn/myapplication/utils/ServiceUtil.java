package com.vtkrishn.myapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.vtkrishn.myapplication.MyService;

/**
 * Created by vtkrishn on 1/20/2015.
 */
public class ServiceUtil {

    public static void startService(Context context, Activity activity){
        Intent service = new Intent(context, MyService.class);
        activity.startService(service);

    }
}
