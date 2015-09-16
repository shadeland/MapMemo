package com.shadeland.mapmemo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by adel on 9/15/15.
 */
public class PlaceLab {

    static ArrayList<Place> loadJson(String jsontxt)throws JSONException{
        ArrayList<Place> placeArr=new ArrayList<Place>();
        JSONArray places = new JSONArray(jsontxt);

        for(int i=0; i<places.length();i++){


            Place p = new Place(places.getJSONObject(i));
            placeArr.add(p);

        }
        return placeArr;
    }
}
