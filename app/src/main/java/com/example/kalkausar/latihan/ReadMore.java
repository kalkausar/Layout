package com.example.kalkausar.latihan;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ReadMore extends AppCompatActivity {
TextView txt_judul;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_more);
        txt_judul = findViewById(R.id.txt_judul);

        Intent extra = getIntent();
        Bundle b = extra.getExtras();

        String judul = b.getString("judul");
        txt_judul.setText(judul);


    }
}
