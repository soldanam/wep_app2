package com.example.dasol.wep_app2;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class EtcFragment extends Fragment {

    private ArrayList<MyItem>data = null;
    static CoffeeAdapter coffeeAdapter;
    public EtcFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fv = inflater.inflate(R.layout.fragment_etc, container, false);
        data = new ArrayList<>();
        data.add(new MyItem(R.drawable.lemon,"레몬에이드","3000"));
        data.add(new MyItem(R.drawable.gra,"자몽에이드","3000"));
        data.add(new MyItem(R.drawable.bluel,"블루레몬에이드","3000"));
        data.add(new MyItem(R.drawable.citr,"유자에이드","3000"));
        data.add(new MyItem(R.drawable.cherry,"체리에이드","3000"));
        data.add(new MyItem(R.drawable.yb,"요거트버블티","4000"));
        data.add(new MyItem(R.drawable.cy,"쿠키바닐라버블티","4000"));
        data.add(new MyItem(R.drawable.sb,"딸기버블티","4000"));
        data.add(new MyItem(R.drawable.ab,"아몬드버블티","4000"));
        data.add(new MyItem(R.drawable.yb,"요거트버블티","4000"));

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
                Intent intent_end = new Intent(getActivity(),EndActivity.class);
                intent_end.putExtra("profileP",Integer.toString(data.get(position).getProfile()));
                intent_end.putExtra("name",data.get(position).getName());
            }
        });

        return fv;
    }



}
