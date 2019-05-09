package com.example.eyda.lsy1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Kullanici_list extends AppCompatActivity {

    ListView listKul;
    List<Users> liste = new ArrayList<Users>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kullanici_list);

        liste.add(new Users("Gözde"));
        liste.add(new Users("Hüseyin"));
        liste.add(new Users("Seda"));
        liste.add(new Users("Fatih"));

        listKul = findViewById(R.id.listviewKullanici);

        custom_listView_home adapterHome = new custom_listView_home(Kullanici_list.this, liste);
        listKul.setAdapter(adapterHome);

    }
}
