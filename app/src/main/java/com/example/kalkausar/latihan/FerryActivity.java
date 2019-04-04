package com.example.kalkausar.latihan;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FerryActivity extends AppCompatActivity {

    TextView title_ferry, desc_ferry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ferry);
        setTitle("Ferry");

        title_ferry = findViewById(R.id.textview_title_ferry);
        desc_ferry = findViewById(R.id.textview_desc_ferry);

        Typeface customfont = Typeface.createFromAsset(getAssets(), "font/contb.ttf");
        title_ferry.setTypeface(customfont);

        Typeface customfont2 = Typeface.createFromAsset(getAssets(), "font/contm.ttf");
        desc_ferry.setTypeface(customfont2);
    }
}
