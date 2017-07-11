package com.ntl.seventh.newsapp;


import android.app.LoaderManager;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ConnectivityManager cm;
    NetworkInfo activeNetwork;
    boolean isConnected;
    private ListView listView;
    private NewsAdapter adapter;
    private LoaderManager.LoaderCallbacks<ArrayList<News>> loaderCallbacks = new LoaderManager.LoaderCallbacks<ArrayList<News>>() {
        @Override
        public android.content.Loader<ArrayList<News>> onCreateLoader(int id, Bundle args) {
            return new NewsLoader(getApplicationContext());
        }

        @Override
        public void onLoadFinished(android.content.Loader<ArrayList<News>> loader, final ArrayList<News> newsArrayList) {

            adapter = new NewsAdapter(getApplicationContext(), R.layout.item_row, newsArrayList);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(newsArrayList.get(position).getUrl()));
                    startActivity(intent);
                }
            });
        }

        @Override
        public void onLoaderReset(android.content.Loader<ArrayList<News>> loader) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.ListView);
        cm = (ConnectivityManager) getApplicationContext().getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);
        activeNetwork = cm.getActiveNetworkInfo();
        isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (isConnected) {
            getLoaderManager().initLoader(1, null, loaderCallbacks);
        } else {
            Toast.makeText(getApplicationContext(), "Please check your internet connection", Toast.LENGTH_LONG).show();
        }

    }


}
