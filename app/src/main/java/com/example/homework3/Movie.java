package com.example.homework3;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class Movie {

    public String title;

    public int imageUrl;

    public Movie(String title, int imageUrl){
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}
