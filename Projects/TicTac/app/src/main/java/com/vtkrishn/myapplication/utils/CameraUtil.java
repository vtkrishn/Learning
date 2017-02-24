package com.vtkrishn.myapplication.utils;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

/**
 * Created by vtkrishn on 1/18/2015.
 */
public class CameraUtil {

    public static void startCamera(Activity activity){
        Intent callIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activity.startActivity(callIntent);
    }

    public static void startSecureCamera(Activity activity){
        Intent callIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
        activity.startActivity(callIntent);
    }

    public static void startVideoCamera(Activity activity){
        Intent callIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        activity.startActivity(callIntent);
    }

}
