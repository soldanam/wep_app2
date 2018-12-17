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
public class LatteFragment extends Fragment {

    private ArrayList<MyItem>data = null;
    static CoffeeAdapter coffeeAdapter;
    public LatteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fv = inflater.inflate(R.layout.fragment_latte, container, false);
        data = new ArrayList<>();
        data.add(new MyItem(R.drawable.latte,"라뗴","2500"));
        data.add(new MyItem(R.drawable.van,"바닐라라뗴","2800"));
        data.add(new MyItem(R.drawable.green,"그린티라뗴","2800"));
        data.add(new MyItem(R.drawable.darkcho,"다크초코라떼","3100"));
        data.add(new MyItem(R.drawable.whitecho,"화이트초코라떼","3100"));
        data.add(new MyItem(R.drawable.sp,"자색고구마라떼","2800"));
        data.add(new MyItem(R.drawable.milkte,"밀크티라떼","2800"));
        data.add(new MyItem(R.drawable.blacktea,"블랙시리얼라떼","3100"));

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
