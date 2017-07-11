package com.ntl.seventh.newsapp;

import java.util.Date;

/**
 * Created by boody 2 on 03/07/2017.
 */

public class News {
    private String title;
    private String section;
    private String author;
    private Date date;
    private String url;

    public String getsection() {
        return section;
    }

    public void setsection(String section) {
        this.section = section;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
