package com.example.kalkausar.latihan;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CarActivity extends AppCompatActivity {

    TextView title_car, desc_car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        setTitle("Sewa Mobil");

        title_car = findViewById(R.id.textview_title_car);
        desc_car = findViewById(R.id.textview_desc_car);

        Typeface customfont = Typeface.createFromAsset(getAssets(), "font/contb.ttf");
        title_car.setTypeface(customfont);

        Typeface customfont2 = Typeface.createFromAsset(getAssets(), "font/contm.ttf");
        desc_car.setTypeface(customfont2);
    }
}
