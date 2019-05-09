package com.example.eyda.lsy1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FirstScreen extends AppCompatActivity {

    public void changeFragment(Fragment fragment){
        FragmentTransaction selectedFragment = getSupportFragmentManager().beginTransaction();
        selectedFragment.replace(R.id.fragment,fragment);
        selectedFragment.commit();
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        changeFragment(new Home_fragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {




            switch (item.getItemId()) {
                case R.id.navigation_home:
                    changeFragment(new Home_fragment());
                    break;

                case R.id.navigation_profil:
                    changeFragment(new Profil_fragment());
                    break;
                case R.id.navigation_search:
                    changeFragment(new Search_fragment());
                    break;
            }

            /*getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment, selecetedFragment).commit();*/

            return true;
        }
    };


    public void kullaniciListesi(View view){
        Intent i = new Intent(FirstScreen.this, Kullanici_list.class);
        startActivity(i);
        finish();
    }

    //ÇALIŞMIYOOORRRR....
    @Override
    public void onBackPressed() {
        // Çalışmasını istediğiniz kodu buraya yazacağız
        super.onBackPressed();
        Intent in = new Intent(FirstScreen.this, TanitimScreen.class);
        startActivity(in);
        finish();


    }

}
