package com.example.eyda.lsy1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class custom_listView_home extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<Users> kullaniciListesi;

    public custom_listView_home(Activity activity, List<Users> kullaniciListesi) {
        layoutInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE
        );
        this.kullaniciListesi = kullaniciListesi;
    }

    //Not: getCount ve getItem vs. BaseAdapter sınıfının metodlarından bir
    //tanesini boş bırakınca listview çalışmaz!.

    @Override
    public int getCount() {
        return kullaniciListesi.size();
        //return 0;
    }

    @Override
    public Object getItem(int position) {
        return kullaniciListesi.get(position);
        //return 0;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View lineView;
       lineView = layoutInflater.inflate(R.layout.listview_design, null);
       TextView txtUsername = lineView.findViewById(R.id.textViewListDesign);
       ImageView image1 = lineView.findViewById(R.id.imageViewListDesign1);
       ImageView image2 = lineView.findViewById(R.id.imageViewListDesign2);

       Users user = kullaniciListesi.get(position);
       txtUsername.setText(user.getUsername());
       image1.setImageResource(R.drawable.checked);
       image2.setImageResource(R.drawable.listres);

        return lineView;

    }
}
