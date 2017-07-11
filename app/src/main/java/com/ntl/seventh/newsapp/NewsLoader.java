package com.ntl.seventh.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

//import android.support.v4.content.AsyncTaskLoader;

/**
 * Created by boody 2 on 08/07/2017.
 */

public class NewsLoader extends AsyncTaskLoader<ArrayList<News>> {

    ArrayList<News> storedNewsList;

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if (storedNewsList != null)
            super.deliverResult(storedNewsList);
        else
            forceLoad();
    }

    @Override
    protected ArrayList<News> onLoadInBackground() {
        return super.onLoadInBackground();
    }


    @Override
    public ArrayList<News> loadInBackground() {
        try {
            URL url = new URL("http://content.guardianapis.com/search?q=fashion&api-key=test");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer stringBuffer = new StringBuffer();

            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
            JsonParsing jsonParsing = new JsonParsing();
            storedNewsList = jsonParsing.parseJson(stringBuffer.toString());
            return storedNewsList;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public void deliverResult(ArrayList<News> data) {
        super.deliverResult(data);
    }

    @Override
    public void onContentChanged() {
        super.onContentChanged();
    }
}
