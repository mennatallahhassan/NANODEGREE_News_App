package com.ntl.seventh.newsapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by boody 2 on 03/07/2017.
 */


public class JsonParsing {
    public ArrayList<News> parseJson(String buffered) {
        try {

            JSONObject jObject = new JSONObject(buffered).getJSONObject("response");
            JSONArray jArray = jObject.getJSONArray("results");

            ArrayList<News> newsArrayList = new ArrayList<>();
            News news;
            for (int i = 0; i < jArray.length(); i++) {
                news = new News();
                jObject = jArray.getJSONObject(i);
                news.setTitle(jObject.getString("webTitle").toString());
                news.setsection(jObject.getString("sectionName").toString());
                news.setUrl(jObject.getString("webUrl").toString());

                newsArrayList.add(news);
            }
            return newsArrayList;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
