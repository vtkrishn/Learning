package com.vtkrishn.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Random;


public class landingActivity extends Activity {

    final int MAX=8;
    ImageView crossBG;
    Button newGame;

    static boolean userTurnFlag;

    ImageView[] xImage = new ImageView[MAX+1];
    ImageView[] oImage = new ImageView[MAX+1];

    char[][] charValue = new char[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_landing);

        //clear the values
        for (int m = 0; m <= 2; m++) {
            for (int n = 0; n <= 2; n++) {
                charValue[m][n] = '0';
            }
        }

        for (int i = 0; i <= MAX; i++)
        {
            xImage[i] = new ImageView(this);
            oImage[i] = new ImageView(this);

            xImage[i].setBackgroundResource(R.drawable.mark);
            oImage[i].setBackgroundResource(R.drawable.circle);

            xImage[i].setVisibility(View.INVISIBLE);
            oImage[i].setVisibility(View.INVISIBLE);
         }
//        //get the resources
//        Resources resources = getResources();
//        //get the package information
//        String name = getPackageName();
//
//
//        //loop the x,y image id
//        for(int i = 0; i <= MAX; i++)
//        {
//            ImageView x= (ImageView)findViewById(resources.getIdentifier("x" + i,"id",name));
//            ImageView y = (ImageView)findViewById(resources.getIdentifier("y" + i,"id",name));
//
//            xImage[i] = x;
//            oImage[i] = y;
//        }
        //new game click listener
        newGame = (Button)findViewById(R.id.newGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create the cross background
                crossBG.setVisibility(View.VISIBLE);
                crossBG.bringToFront();

                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                placeInitCircle(relativeLayout, params);
            }
        });

        crossBG = (ImageView)findViewById(R.id.crossBG);
        crossBG.setVisibility(View.INVISIBLE);
        crossBG.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                placeXMark(relativeLayout, params, event);
                placeInitCircle(relativeLayout, params);
                return true;
            }
        });
    }

    private void placeXMark(RelativeLayout relativeLayout, RelativeLayout.LayoutParams params, MotionEvent event) {
        //get the x co-ordinate
        int x = (int) event.getX();
        //get the y co-ordinate
        int y = (int) event.getY();
        //place the image 'X' on touch coordinates if there is no 'O' present already
        String matrix = getMatrix(x,y);

        int count = 0;
        String[] s = new String[9];
        for (int m = 0; m <= 2; m++) {
            for (int n = 0; n <= 2; n++) {
                if(charValue[m][n] == 'O'){
                    s[count] = m+","+n;
                    count++;
                }
            }
        }

        if(matrix.equals("0,0")){
            placeXMark(relativeLayout, params, 700, 0, 0);
            charValue[0][0] ='X';
        }
        else if(matrix.equals("0,1")){
            placeXMark(relativeLayout, params, 700, 350, 1);
            charValue[0][1] ='X';
        }
        else if(matrix.equals("0,2")){
            placeXMark(relativeLayout, params, 700, 700, 2);
            charValue[0][2] ='X';
        }
        else if(matrix.equals("1,0")){
            placeXMark(relativeLayout, params, 1050, 0, 3);
            charValue[1][0] ='X';
        }
        else if(matrix.equals("1,1")){
            placeXMark(relativeLayout, params, 1050, 350, 4);
            charValue[1][1] ='X';
        }
        else if(matrix.equals("1,2")){
            placeXMark(relativeLayout, params, 1050, 700, 5);
            charValue[1][2] ='X';
        }
        else if(matrix.equals("2,0")){
            placeXMark(relativeLayout, params, 1400, 0, 6);
            charValue[2][0] ='X';
        }
        else if(matrix.equals("2,1")){
            placeXMark(relativeLayout, params, 1400, 350, 7);
            charValue[2][1] ='X';
        }
        else if(matrix.equals("2,2")){
            placeXMark(relativeLayout, params, 1400, 700, 8);
            charValue[2][2] ='X';
        }

    }

    private void placeInitCircle(RelativeLayout relativeLayout, RelativeLayout.LayoutParams params) {
        //random for x co-ordinate
        int randX = (new Random()).nextInt(1066);
        //random for y co-ordinate
        int randY = (new Random()).nextInt(1100);

        String matrix = getMatrix(randX,randY);

        int count = 0;
        String[] s = new String[9];
        for (int m = 0; m <= 2; m++) {
            for (int n = 0; n <= 2; n++) {
                if(charValue[m][n] == 'X'){
                    s[count] = m+","+n;
                    count++;
                }
            }
        }

        if(matrix.equals("0,0")){
            placeOMark(relativeLayout, params, 700, 0, 0);
            charValue[0][0] ='O';
        }
        else if(matrix.equals("0,1")){
            placeOMark(relativeLayout, params, 700, 350, 1);
            charValue[0][1] ='O';
        }
        else if(matrix.equals("0,2")){
            placeOMark(relativeLayout, params, 700, 700, 2);
            charValue[0][2] ='O';
        }
        else if(matrix.equals("1,0")){
            placeOMark(relativeLayout, params, 1050, 0, 3);
            charValue[1][0] ='O';
        }
        else if(matrix.equals("1,1")){
            placeOMark(relativeLayout, params, 1050, 350, 4);
            charValue[1][1] ='O';
        }
        else if(matrix.equals("1,2")){
            placeOMark(relativeLayout, params, 1050, 700, 5);
            charValue[1][2] ='O';
        }
        else if(matrix.equals("2,0")){
            placeOMark(relativeLayout, params, 1400, 0, 6);
            charValue[2][0] ='O';
        }
        else if(matrix.equals("2,1")){
            placeOMark(relativeLayout, params, 1400, 350, 7);
            charValue[2][1] ='O';
        }
        else if(matrix.equals("2,2")){
            placeOMark(relativeLayout, params, 1400, 700, 8);
            charValue[2][2] ='O';
        }

    }

    private void placeXMark(RelativeLayout relativeLayout, RelativeLayout.LayoutParams params, int topMargin, int leftMargin, int index) {
        if(userTurnFlag) {
            params.topMargin = topMargin;
            params.leftMargin = leftMargin;
            xImage[index].setLayoutParams(params);
            xImage[index].setVisibility(View.VISIBLE);
            relativeLayout.removeView(xImage[index]);
            relativeLayout.addView(xImage[index]);
            userTurnFlag = false;
        }
    }

    private void placeOMark(RelativeLayout relativeLayout, RelativeLayout.LayoutParams params, int topMargin, int leftMargin, int index) {
        if(!userTurnFlag) {
            params.topMargin = topMargin;
            params.leftMargin = leftMargin;
            oImage[index].setLayoutParams(params);
            oImage[index].setVisibility(View.VISIBLE);
            relativeLayout.removeView(oImage[index]);
            relativeLayout.addView(oImage[index]);
            userTurnFlag = true;
        }
    }

    private String getMatrix(int x, int y){
        String value="";
        if (y <=350 && x <= 350){
            value =  "0,0";
        }
        else if(y <=350 && x >= 350 && x <=700){
            value = "0,1";
        }
        else if(y <=350 && x >= 700){
            value = "0,2";
        }
        else if (y >= 350 && y <=700 && x <= 350){
            value = "1,0";
        }
        else if(y >= 350 && y <=700 && x >= 350 && x <= 700){
            value = "1,1";
        }
        else if(y >= 350 && y <=700 && x >= 700){
            value = "1,2";
        }
        else if (y >= 700  && x <= 350){
            value = "2,0";
        }
        else if(y >= 700  && x >= 350 && x <= 700){
            value = "2,1";
        }
        else if(y >= 700 && x >= 700){
            value = "2,2";
        }

        return value;
    }

}
