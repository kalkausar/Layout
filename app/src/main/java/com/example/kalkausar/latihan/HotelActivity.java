package com.example.kalkausar.latihan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

public class HotelActivity extends AppCompatActivity {
    private ProgressBar progressHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        setTitle("Hotel");
        progressHotel = (ProgressBar) findViewById(R.id.progressBar_hotel);
        progressHotel.setVisibility(View.INVISIBLE);
    }
}
