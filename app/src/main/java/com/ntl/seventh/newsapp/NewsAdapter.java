package com.ntl.seventh.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

/**
 * Created by boody 2 on 03/07/2017.
 */

public class NewsAdapter extends ArrayAdapter {

    ArrayList<News> newsArrayList;
    Context context;


    public NewsAdapter(Context context, int resource, ArrayList<News> newsArrayList) {
        super(context, resource, newsArrayList);
        this.newsArrayList = newsArrayList;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
            viewHolder = new NewsViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (NewsViewHolder) convertView.getTag();
        }
        News news = newsArrayList.get(position);
        viewHolder.title.setText("Title: " + news.getTitle().toString());
        viewHolder.section.setText("Section: " + news.getsection().toString());

        return convertView;
    }


}




