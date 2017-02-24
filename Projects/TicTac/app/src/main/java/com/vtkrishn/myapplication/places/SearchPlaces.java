package com.vtkrishn.myapplication.places;

import android.os.AsyncTask;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by vtkrishn on 1/16/2015.
 */
public class SearchPlaces extends AsyncTask{

    //?location=-33.88471,151.218237&radius=100&sensor=true&key=API_KEY

    //method to take name as parameter

    public ArrayList searchPlaces(String item){


        StringBuffer urlString = new StringBuffer();

        ArrayList results = new ArrayList();
        String jsonOutput = null;
        String output = null;

        //construct the url
       // urlString = constructSearchURL(latitude, longitude, radius, sensor);
        //search using google api
        try {
            jsonOutput = search(urlString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //parse the output
       // results = parseJSON(rawJSONOutput);
        // send the result
        return results;
    }

    /*
    This is used to construct the Search URL
     */
    private StringBuffer constructSearchURL(String latitude, String longitude, String radius, String sensor) {
        StringBuffer urlString = new StringBuffer();
         //   urlString.append(URL_START);
            urlString.append("?location=");
            urlString.append(latitude +","+ longitude);
            urlString.append("&radius=");
            urlString.append(radius);
            urlString.append("&sensor=");
            urlString.append(sensor);
            urlString.append("&key=");
         //   urlString.append(API_KEY);
        return urlString;
    }

    private ArrayList parseJSON(String output){

        return null;
    }

    /*
    Search using the URL
     */
    private String search(String urlString) throws IOException {
        String data = "";
        String line = "";
        HttpsURLConnection urlConnection = null;
        InputStream iStream = null;
        try {
            URL url = new URL(urlString);
            urlConnection = (HttpsURLConnection)url.openConnection();
            urlConnection.connect();
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb  = new StringBuffer();

            while( ( line = br.readLine())  != null){
                sb.append(line);
            }
            data = sb.toString();
            br.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            iStream.close();
            urlConnection.disconnect();
        }

        return data;
    }

    @Override
    protected Object doInBackground(Object[] params) {

        return null;
    }
}
