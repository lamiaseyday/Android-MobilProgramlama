package com.example.eyda.lsy1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    Button butonGiris, butonKayit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        butonGiris = findViewById(R.id.btnGiris);
        butonKayit = findViewById(R.id.btnKaydol);
    }

    public void Giris(View v){
        Intent i = new Intent(WelcomeActivity.this, loginActivity.class);
        startActivity(i);
        finish();
    }

    public void Kayit(View v){
        Intent i = new Intent(WelcomeActivity.this, RecordPage.class);
        startActivity(i);
        finish();
    }
}
