package com.example.dasol.wep_app2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SmoothieFragment extends Fragment {
    private ArrayList<MyItem>data = null;
    static CoffeeAdapter coffeeAdapter;

    public SmoothieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fv = inflater.inflate(R.layout.fragment_smoothie, container, false);

        data = new ArrayList<>();
        data.add(new MyItem(R.drawable.str,"딸기요거트스무디","1900"));
        data.add(new MyItem(R.drawable.blue,"블루베리요거트스무디","1900"));
        data.add(new MyItem(R.drawable.mango,"망고요거트스무디","1900"));
        data.add(new MyItem(R.drawable.kiw,"키위요거트스무디","1900"));
        data.add(new MyItem(R.drawable.youja,"유자요거트스무디","1900"));
        data.add(new MyItem(R.drawable.plain,"플레인요거트스무디","1900"));
        data.add(new MyItem(R.drawable.min,"민트초코프라페","1900"));
        data.add(new MyItem(R.drawable.moca,"모카프라페","1900"));
        data.add(new MyItem(R.drawable.car,"카라멜프라페","1900"));
        data.add(new MyItem(R.drawable.oo,"오곡프라페","1900"));
        data.add(new MyItem(R.drawable.greentea,"그린티프라페","1900"));
        data.add(new MyItem(R.drawable.ja,"자색고구마프라페","1900"));


        coffeeAdapter= new CoffeeAdapter(getContext(), R.layout.item, data);
        ListView listView =(ListView)fv.findViewById(R.id.listView);
        listView.setAdapter(coffeeAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getContext(),ClickActivity.class);
                intent.putExtra("profile",Integer.toString(data.get(position).getProfile()));
                intent.putExtra("name",data.get(position).getName());
                intent.putExtra("cost",data.get(position).getCost());
                startActivity(intent);
                final Intent intent_end = new Intent(getActivity(),EndActivity.class);
                intent_end.putExtra("profile",Integer.toString(data.get(position).getProfile()));
                intent_end.putExtra("name",data.get(position).getName());
            }
        });


        return fv;
    }

}
