package com.example.eyda.lsy1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TanitimScreen extends AppCompatActivity {

    TextView txtEmail;
    Button btnKesfet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tanitim_screen);

        txtEmail = findViewById(R.id.textViewAdSoyad);
        btnKesfet = findViewById(R.id.btnKesif);

        txtEmail.setText(getIntent().getExtras().getString("veri"));

    }

}
