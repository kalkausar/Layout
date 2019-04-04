package com.example.kalkausar.latihan;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

    TextView title_event1,desc_event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        setTitle("Event Aceh");

        title_event1 = findViewById(R.id.textview_title_event);
        desc_event = findViewById(R.id.textview_desc_event);

        Typeface customfont = Typeface.createFromAsset(getAssets(), "font/contb.ttf");
        title_event1.setTypeface(customfont);

        Typeface customfont2 = Typeface.createFromAsset(getAssets(), "font/contm.ttf");
        desc_event.setTypeface(customfont2);
    }
}
