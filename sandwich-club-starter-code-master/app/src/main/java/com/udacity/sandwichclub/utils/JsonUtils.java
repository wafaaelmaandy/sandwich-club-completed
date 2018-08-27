package com.udacity.sandwichclub.utils;

import android.widget.Toast;

import com.udacity.sandwichclub.R;
import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
       Sandwich sandwich = null;
// All KEY names.
        final String KEY_NAME = "name",
                KEY_MAIN_NAME = "mainName",
                KEY_ALSO_KNOWN_AS = "alsoKnownAs",
                KEY_PLACE_OF_ORIGIN = "placeOfOrigin",
                KEY_DESCRIPTION = "description",
                KEY_IMAGE_URL = "image",
                KEY_INGREDIENTS = "ingredients";

        try {
            JSONObject rootJsonObject = new JSONObject(json) ;
            JSONObject   nameJsonObject = rootJsonObject.getJSONObject("name");

            String mainName=nameJsonObject.optString(KEY_MAIN_NAME);
            String placeOfOrigin = rootJsonObject.optString(KEY_PLACE_OF_ORIGIN);
            String description =rootJsonObject.optString(KEY_DESCRIPTION);
            String image= rootJsonObject.optString(KEY_IMAGE_URL);
            JSONArray alsoKnownAs1 =nameJsonObject.getJSONArray(KEY_ALSO_KNOWN_AS);
            List<String> alsoKnownAs = new ArrayList<String>();
            for (int i = 0; i < alsoKnownAs1.length(); i++) {
                alsoKnownAs.add( alsoKnownAs1.getString(i));
            }

            JSONArray ingredients1   =rootJsonObject.getJSONArray(KEY_INGREDIENTS);
            List<String> ingredients   = new ArrayList<String>();
            for (int i = 0; i < ingredients1.length(); i++) {
                ingredients.add( ingredients1.getString(i));
            }
             sandwich=new Sandwich(mainName, alsoKnownAs,  placeOfOrigin,  description,
                     image, ingredients);


        } catch (JSONException e) {
            e.printStackTrace();

        }

        return sandwich;
    }




}
