package com.example.login;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CountryAdapter extends ArrayAdapter<Country> {
    Activity activity;
    int itemResourceId;
    List<Country> items;
    private TextView nameTV;
    private ImageView flagIV;

    public CountryAdapter(Activity activity, int itemResourceId, List<Country> items){
        super(activity, itemResourceId, items);
        this.activity = activity;
        this.itemResourceId = itemResourceId;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View layout = convertView;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            layout = inflater.inflate(itemResourceId, parent, false);
        }
        TextView nameTV = layout.findViewById(R.id.name);
        ImageView flagIV = layout.findViewById(R.id.flag);
        nameTV.setText(items.get(position).name);
        flagIV.setImageResource(items.get(position).flagResourceId);
        return layout;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        View layout = convertView;
        if (convertView == null) {
            LayoutInflater inflater = activity.getLayoutInflater();
            layout = inflater.inflate(itemResourceId, parent, false);
        }
        TextView nameTV = layout.findViewById(R.id.name);
        ImageView flagIV = layout.findViewById(R.id.flag);
        nameTV.setText(items.get(position).name);
        flagIV.setImageResource(items.get(position).flagResourceId);
        return layout;
    }


}
