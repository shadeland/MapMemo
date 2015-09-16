package com.shadeland.mapmemo;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by adel on 9/15/15.
 */
public class Place  {
    String name;
    long lat;
    long lng;

    public Place() {

    }
    public Place(JSONObject json) throws JSONException{
        name = json.getString("name");
        lat = json.getLong("lat");
        lng = json.getLong("lng");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public long getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }


}
