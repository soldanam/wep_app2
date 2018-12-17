package com.example.dasol.wep_app2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CoffeeAdapter extends BaseAdapter {
    private Context mContext;
    private int mResource;
    private ArrayList<MyItem> mItems = new ArrayList<MyItem>();

    public CoffeeAdapter(Context context, int resource, ArrayList<MyItem> items) {
        mContext = context;
        mItems = items;
        mResource = resource;
    }
    
    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mResource, parent,false);
        }
        // Set Icon
        ImageView icon = (ImageView) convertView.findViewById(R.id.iconItem);
        icon.setImageResource(mItems.get(position).mIcon);

        // Set Text 01
        TextView name = (TextView) convertView.findViewById(R.id.textItem1);
        name.setText(mItems.get(position).nName);

        // Set Text 02
        TextView age = (TextView) convertView.findViewById(R.id.textItem2);
        age.setText(mItems.get(position).ncost);

        return convertView;
    }
}

 class MyItem {
    int mIcon; // image resource
    String nName; // text
    String ncost;  // text

    public int getProfile() {
        return mIcon;
    }

    public String getName() {
        return nName;
    }

    public String getCost() {
        return ncost;
    }

   MyItem(int aIcon, String aName, String aAge) {
        mIcon = aIcon;
        nName = aName;
        ncost = aAge;
    }
}
