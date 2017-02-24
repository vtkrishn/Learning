package com.vtkrishn.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vtkrishn.myapplication.places.SearchPlaces;
import com.vtkrishn.myapplication.places.StudentsProvider;
import com.vtkrishn.myapplication.utils.CameraUtil;
import com.vtkrishn.myapplication.utils.ConnectionUtil;
import com.vtkrishn.myapplication.utils.DisplayUtil;



public class MainActivity extends ActionBarActivity {
    private String latitude;
    private String longitude;
    private String API_KEY = "AIzaSyCUPirr0LBeGd3KWzehDfFAsaTi-1itBpY";
    private String URL_START = "https://maps.googleapis.com/maps/api/place/search/json";
    private String sensor;
    private String radius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new RefreshTask().execute();


        //AdView mAdView = (AdView) v.findViewById(R.id.ad);

        //to display a UP button in the home page
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //button
        Button button = (Button) findViewById(R.id.button);
        //button click
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SearchPlaces places = new SearchPlaces();
                //places.searchPlaces();

                //if connection exists
                if (ConnectionUtil.checkInternetConnection(getBaseContext()))
                    //Show the dialog
                    DisplayUtil.showAlertDialog(MainActivity.this, "Connection Status", "Interconnection exists");
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    public void showDialog(View view) {
        //call another dialog
        //DisplayUtil.showAlertDialog(MainActivity.this, "Show Msg", "Msg");
        //call another view
        //Intent intent = new Intent(this, SimpleMessageActivity.class);
        //startActivity(intent);

        //call the fragment

        //call the number
        //Uri number = Uri.parse("tel:4792761750");
        //PhoneUtil.callNumber(this,number);

        //start camera
        CameraUtil.startCamera(this);
    }


    public void onClickAddName(View view) {
        // Add a new student record
        ContentValues values = new ContentValues();

        values.put(StudentsProvider.NAME,
                ((EditText)findViewById(R.id.txtName)).getText().toString());

        values.put(StudentsProvider.POINTS,
                ((EditText)findViewById(R.id.txtGrade)).getText().toString());

        Uri uri = getContentResolver().insert(
                StudentsProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                uri.toString(), Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view) {
        // Retrieve student records
        String URL = "content://com.vtkrishn.provider.College/courses";
        Uri students = Uri.parse(URL);
        Cursor c = managedQuery(students, null, null, null, "name");
        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentsProvider.ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentsProvider.POINTS)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }

    class RefreshTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] params) {
            return null;
        }


    }
}
