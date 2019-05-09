package com.example.eyda.lsy1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Home_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        return v;

        /*
        Bu şekilde Context nesnesi oluşturup onu joker eleman gibi
        kullanabiliriz. Bu daha rahat işlem yapmayı sağlar..

        Context c = v.getContext();
        Toast.makeText(c,"Deneme",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(c, Search_fragment.class);
        TextView tv = new TextView(c);
        ImageView iv = v.findViewById(R.id.btnKesif);
        */

    }


}
