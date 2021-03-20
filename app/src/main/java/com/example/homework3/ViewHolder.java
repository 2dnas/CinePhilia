package com.example.homework3;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

class ViewHolder extends RecyclerView.ViewHolder {
    TextView cinemaName;
    ImageView poster;
    Button buyButton;

    public ViewHolder(View view) {
        super(view);
        // Define click listener for the ViewHolder's View

        poster = view.findViewById(R.id.idIVCourseImage);
        buyButton = view.findViewById(R.id.buyButton);
        cinemaName = view.findViewById(R.id.cardTV_cinema_name);
    }

    public TextView getCinemaName() {
        return cinemaName;
    }

    public ImageView getPoster() {
        return poster;
    }

    public Button getBuyButton() {
        return buyButton;
    }


}
