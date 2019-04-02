package com.example.kalkausar.latihan;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    TextView textView1, textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        textView1 = findViewById(R.id.textview_title);
        textView2 = findViewById(R.id.textview_desc);

        Typeface customfont = Typeface.createFromAsset(getAssets(), "font/contb.ttf");
        textView1.setTypeface(customfont);

        Typeface customfont2 = Typeface.createFromAsset(getAssets(), "font/contm.ttf");
        textView2.setTypeface(customfont2);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if (getIntent().hasExtra("Title")) {

            String title = getIntent().getStringExtra("Title");
            setTitle(title);
        }
    }
}
