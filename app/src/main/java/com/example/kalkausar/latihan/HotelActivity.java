package com.example.kalkausar.latihan;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class HotelActivity extends AppCompatActivity {

    TextView Text_tile, Text_desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);
        setTitle("Hotel");
        
        Text_tile = findViewById(R.id.textview_title_Hotel);
        Text_desc = findViewById(R.id.textview_desc_hotel);

        Typeface customfont = Typeface.createFromAsset(getAssets(), "font/contb.ttf");
        Text_tile.setTypeface(customfont);

        Typeface customfont2 = Typeface.createFromAsset(getAssets(), "font/contm.ttf");
        Text_desc.setTypeface(customfont2);
    }
}
