package com.example.kalkausar.latihan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class Layout_Relative extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout__relative);

        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v){
                Intent a = new Intent(Layout_Relative.this,MainActivity.class);
                startActivity(a);
            }
        });

        Button btn_cls = findViewById(R.id.btn_cls);
        btn_cls.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                finish();
                moveTaskToBack(true);
            }
        });
    }
}
