package com.example.eyda.lsy1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TanitimScreen extends AppCompatActivity {

    TextView txtAd;
    Button btnKesfet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanitim_screen);

        txtAd = findViewById(R.id.textViewAdSoyad);
        btnKesfet = findViewById(R.id.btnKesif);

        txtAd.setText(getIntent().getExtras().getString("veri"));

    }

    public void Kesfet(View v){
        Intent i = new Intent(TanitimScreen.this, FirstScreen.class);
        startActivity(i);
        finish();
    }


}
