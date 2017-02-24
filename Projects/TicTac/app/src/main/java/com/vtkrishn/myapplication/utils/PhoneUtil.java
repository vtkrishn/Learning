package com.vtkrishn.myapplication.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by vtkrishn on 1/18/2015.
 */
public class PhoneUtil {

    public static void callNumber(Activity activity, Uri phoneNumber){
        Intent callIntent = new Intent(Intent.ACTION_DIAL, phoneNumber);
        activity.startActivity(callIntent);
    }

}
