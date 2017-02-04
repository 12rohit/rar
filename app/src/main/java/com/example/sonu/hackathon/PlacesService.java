package com.example.sonu.hackathon;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sonu on 04-02-2017.
 */

public class PlacesService {

    private String API_KEY;

    public PlacesService(String apikey) {
        this.API_KEY = apikey;
    }

    public void setApiKey(String apikey) {
        this.API_KEY = apikey;
    }

    public List<Place> findPlaces(double latitude, double longitude, String placeSpacification)
    {
        Log.d("ravi","findPlaces called ");

        String urlString = makeUrl(latitude, longitude,placeSpacification);

        Log.d("ravi","url=>"+urlString);

        try {
            String json = getJSON(urlString);

            //System.out.println(json);
            Log.d("ravi","json=> "+json);
            JSONObject object = new JSONObject(json);
            JSONArray array = object.getJSONArray("results");


            ArrayList<Place> arrayList = new ArrayList<Place>();
            for (int i = 0; i < array.length(); i++) {
                try {
                    Place place = Place.jsonToPontoReferencia((JSONObject) array.get(i));

                    Log.d("ravi", ""+place);


                    arrayList.add(place);
                } catch (Exception e) {

                }
            }
            return arrayList;
        } catch (JSONException ex) {
            //Logger.getLogger(PlacesService.class.getName()).log(Level.SEVERE, null, ex);
            Log.d("ravi","json Exception=> "+ex);

        } catch (Exception ex) {
            //Logger.getLogger(PlacesService.class.getName()).log(Level.SEVERE, null, ex);
            Log.d("ravi","Exception "+ex);

        }
        return null;
    }
    //https://maps.googleapis.com/maps/api/place/search/json?location=28.632808,77.218276&radius=500&types=atm&sensor=false&key=apikey
    private String makeUrl(double latitude, double longitude,String place) {
        StringBuilder urlString = new StringBuilder("https://maps.googleapis.com/maps/api/place/search/json?");

        if (place.equals("")) {
            urlString.append("&location=");
            urlString.append(Double.toString(latitude));
            urlString.append(",");
            urlString.append(Double.toString(longitude));
            urlString.append("&radius=1000");
            //   urlString.append("&types="+place);
            urlString.append("&sensor=false&key=" + API_KEY);
        } else {
            urlString.append("&location=");
            urlString.append(Double.toString(latitude));
            urlString.append(",");
            urlString.append(Double.toString(longitude));
            urlString.append("&radius=1000");
            urlString.append("&types="+place);
            urlString.append("&sensor=false&key=" + API_KEY);
        }


        return urlString.toString();
    }

    protected String getJSON(String url) {
        return getUrlContents(url);
    }

    private String getUrlContents(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()), 8);
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }

            bufferedReader.close();
        }

        catch (Exception e)
        {

            e.printStackTrace();

        }

        return content.toString();
    }
}
