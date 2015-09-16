package com.shadeland.mapmemo;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONException;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity{

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.

    ArrayList<Place> places= new ArrayList<Place>();

    private static final String TAG = MapsActivity.class.getSimpleName();


    void populatePlaces() throws JSONException {
        Log.v(TAG,places.size()+"Number of foolan");

/*
Json Dummy Data To Check The Functionality
TODO    FileLoader For now !
*/
        places = PlaceLab.loadJson("[{\n" +
               "\t\t\"name\": \"Castelluccio Valmaggiore\",\n" +
               "\t\t\"lat\": \"43.63301\",\n" +
               "\t\t\"lng\": \"65.77033\"\n" +
               "\t},\n" +
               "\t{\n" +
               "\t\t\"name\": \"Port Augusta\",\n" +
               "\t\t\"lat\": \"-53.63728\",\n" +
               "\t\t\"lng\": \"73.93548\"\n" +
               "\t},\n" +
               "\t{\n" +
               "\t\t\"name\": \"Thorold\",\n" +
               "\t\t\"lat\": \"11.56913\",\n" +
               "\t\t\"lng\": \"-14.48823\"\n" +
               "\t}\n" +
               "]");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        try {
            populatePlaces();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setUpMapIfNeeded();
    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        for(Place p: places){
            mMap.addMarker(new MarkerOptions().position(new LatLng(p.getLat(), p.getLng())).title(p.getName()));
        }

    }
}
