package com.example.kalkausar.latihan;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class WisataActivity extends AppCompatActivity {

    TextView title_wisata, desc_wisata;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);
        setTitle("Wisata");

        title_wisata = findViewById(R.id.textview_title_wisata);
        desc_wisata = findViewById(R.id.textview_desc_wisata);

        Typeface customfont = Typeface.createFromAsset(getAssets(), "font/contb.ttf");
        title_wisata.setTypeface(customfont);

        Typeface customfont2 = Typeface.createFromAsset(getAssets(), "font/contm.ttf");
        desc_wisata.setTypeface(customfont2);
    }
}
