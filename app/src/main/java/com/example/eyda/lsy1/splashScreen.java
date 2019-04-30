package com.example.eyda.lsy1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread splashThread;

        splashThread = new Thread(){
            @Override
            public void run() {
                try{
                    synchronized (this){
                        wait(4000);
                    }
                }catch (InterruptedException ex){

                }finally {
                    Intent intent = new Intent(splashScreen.this, WelcomeActivity.class);
                    //Burda splashScreen.this yerine getApplicationContext() de olur.
                    startActivity(intent);
                    finish();
                }
            }
        };

        splashThread.start();
    }
}
