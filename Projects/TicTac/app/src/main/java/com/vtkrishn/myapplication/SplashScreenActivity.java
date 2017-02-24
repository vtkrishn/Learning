package com.vtkrishn.myapplication;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;


public class SplashScreenActivity extends Activity {

    private static int SPLASH_TIME_OUT=1000;
    private ProgressBar progressBar;
    private int progressStatus = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                try {

                    Intent intent = new Intent(SplashScreenActivity.this, landingActivity.class);
                    startActivity(intent);
                    //end this activity

                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
                , SPLASH_TIME_OUT);

//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(progressBar.getProgress()<100){
//                    progressStatus = 10;
//                    progressStatus++;
//                }
//            }
//        }
//        );
//
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                progressBar.setProgress(progressStatus);
//            }
//        });

        //LoadingTask.execute(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash_screen, menu);
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class LoadingTask extends AsyncTask<Void, Integer,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            try{
                synchronized (this){
                    int counter = 0;
                    while(counter < 4){
                        counter ++;
                        this.wait(500);
                        publishProgress(counter*30);
                    }

                }

            }
            catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            progressBar.setProgress(0);
            progressBar.setMax(100);
        }

        @Override
        protected void onProgressUpdate(Integer[] values) {
            progressBar.setProgress((Integer)values[0]);
        }

        @Override
        protected void onPostExecute(Void o) {
            //progressBar.dismiss();
            setContentView(R.layout.activity_landing);
        }
    }

}
