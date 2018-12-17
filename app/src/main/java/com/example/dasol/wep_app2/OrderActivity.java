package com.example.dasol.wep_app2;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class OrderActivity extends AppCompatActivity {
    private Button coffee,latte,smoothie,tea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().show();
        getSupportActionBar().setTitle("전체주문");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1d809f")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        coffee =(Button)findViewById(R.id.coffee);
        smoothie=(Button)findViewById(R.id.smoothie);
        tea=(Button)findViewById(R.id.tea);
        latte=(Button)findViewById(R.id.latte);
        switchFragment(1);
        smoothie.setBackgroundColor(Color.LTGRAY);
        tea.setBackgroundColor(Color.LTGRAY);
        latte.setBackgroundColor(Color.LTGRAY);
        coffee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smoothie.setBackgroundColor(Color.LTGRAY);
                tea.setBackgroundColor(Color.LTGRAY);
                latte.setBackgroundColor(Color.LTGRAY);
                coffee.setBackgroundColor(Color.rgb(29,128,159));
                switchFragment(1);
            }
        });
        smoothie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coffee.setBackgroundColor(Color.LTGRAY);
                tea.setBackgroundColor(Color.LTGRAY);
                latte.setBackgroundColor(Color.LTGRAY);
                smoothie.setBackgroundColor(Color.rgb(29,128,159));
                switchFragment(2);
            }
        });
        tea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smoothie.setBackgroundColor(Color.LTGRAY);
                coffee.setBackgroundColor(Color.LTGRAY);
                latte.setBackgroundColor(Color.LTGRAY);
                tea.setBackgroundColor(Color.rgb(29,128,159));
                switchFragment(3);
            }
        });
        latte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                smoothie.setBackgroundColor(Color.LTGRAY);
                tea.setBackgroundColor(Color.LTGRAY);
                coffee.setBackgroundColor(Color.LTGRAY);
                latte.setBackgroundColor(Color.rgb(29,128,159));
                switchFragment(4);
            }
        });

    }
    final CoffeeFragment coffeeFragment =new CoffeeFragment();
    final LatteFragment latteFragment=new LatteFragment();
    final SmoothieFragment smoothieFragment= new SmoothieFragment();
   final EtcFragment etcFragment = new EtcFragment();

    protected void switchFragment(int id){
        final FragmentTransaction fragmentTransaction =getSupportFragmentManager().beginTransaction();
        if(id==1)
            fragmentTransaction.replace(R.id.fragment,coffeeFragment);
        else if(id==4)
            fragmentTransaction.replace(R.id.fragment,smoothieFragment);
        else if(id==3)
            fragmentTransaction.replace(R.id.fragment,etcFragment);
        else
           fragmentTransaction.replace(R.id.fragment,latteFragment);
        fragmentTransaction.commit();
    }


}
