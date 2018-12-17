package com.example.dasol.wep_app2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CoffeeFragment extends Fragment {
    private ArrayList<MyItem>data = null;
    static CoffeeAdapter coffeeAdapter;
    public CoffeeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fv = inflater.inflate(R.layout.fragment_coffee, container, false);
        data = new ArrayList<>();
        data.add(new MyItem(R.drawable.expresso,"에스프레소","1800"));
        data.add(new MyItem(R.drawable.americano,"아메리카노","1800"));
        data.add(new MyItem(R.drawable.haz,"헤이즐넛","2500"));
        data.add(new MyItem(R.drawable.capucino,"카푸치노","2500"));
        data.add(new MyItem(R.drawable.cafemocha1,"카페다크모카","3200"));
        data.add(new MyItem(R.drawable.cafemocha2,"카페카라멜모카","3200"));
        data.add(new MyItem(R.drawable.cara,"캬라멜마끼야또","3200"));

        coffeeAdapter= new CoffeeAdapter(getContext(), R.layout.item, data);
        ListView listView =(ListView)fv.findViewById(R.id.listView);
        listView.setAdapter(coffeeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ClickActivity.class);
                intent.putExtra("profile",Integer.toString(data.get(position).getProfile()));
                intent.putExtra("name",data.get(position).getName());
                intent.putExtra("cost",data.get(position).getCost());
                startActivity(intent);
               Intent intent_end = new Intent(getActivity(),EndActivity.class);
                intent_end.putExtra("profile",Integer.toString(data.get(position).getProfile()));
                intent_end.putExtra("name",data.get(position).getName());

            }
        });

        return fv;
    }


}
