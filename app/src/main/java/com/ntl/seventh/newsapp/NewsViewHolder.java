package com.ntl.seventh.newsapp;

import android.view.View;
import android.widget.TextView;

/**
 * Created by boody 2 on 11/07/2017.
 */

public class NewsViewHolder {
    TextView section;
    TextView title;

    public NewsViewHolder(View itemView) {
        this.title = (TextView) itemView.findViewById(R.id.title);
        this.section = (TextView) itemView.findViewById(R.id.story);
    }
}
