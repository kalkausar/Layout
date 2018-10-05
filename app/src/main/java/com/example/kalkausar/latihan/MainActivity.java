package com.example.kalkausar.latihan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_pndh = findViewById(R.id.btn_pndh);
        btn_pndh.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Intent a = new Intent(MainActivity.this,Layout_Relative.class);
                startActivity(a);
            }
        });
    }
}
