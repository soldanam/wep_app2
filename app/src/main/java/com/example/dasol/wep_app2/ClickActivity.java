package com.example.dasol.wep_app2;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.channels.CancelledKeyException;
import java.util.ArrayList;

import static android.graphics.Color.WHITE;

public class ClickActivity extends AppCompatActivity {
    private  int img;
    private  String name1;
    private  NumberPicker num;
    final static String url = "http://13.125.129.127:3000/orders/ord";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click);
        Intent intent = getIntent();
        getSupportActionBar().setTitle("메뉴 상세");
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1d809f")));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ImageView profile = (ImageView)findViewById(R.id.img_prof);
        final TextView name =(TextView)findViewById(R.id.tv_nm);
        final TextView cost=(TextView)findViewById(R.id.tv_cs);

        num = (NumberPicker)findViewById(R.id.num);
        num.setMinValue(1);
        num.setMaxValue(6);
        num.setWrapSelectorWheel(false);


        img = Integer.parseInt(intent.getStringExtra("profile"));
        profile.setImageResource(img);


       name1=intent.getStringExtra("name");
        name.setText(intent.getStringExtra("name"));
        cost.setText(intent.getStringExtra("cost"));

        num.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                int aw=Integer.parseInt(getIntent().getStringExtra("cost"))*newVal;
                cost.setText(String.valueOf(aw)+"원");

            }
        });




        Button orderBtn = (Button)findViewById(R.id.order);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePicker timePicker = (TimePicker)findViewById(R.id.time);
                CheckBox checkBox = (CheckBox)findViewById(R.id.takeout);
                //checkbox 체크
                String result;


                Intent intent = new Intent(ClickActivity.this,EndActivity.class);
                intent.putExtra("img", img);
                intent.putExtra("name",name1+"  "+String.valueOf(num.getValue())+"개");
                intent.putExtra("time",timePicker.getCurrentHour()+"시"+timePicker.getCurrentMinute()+"분");
                startActivity(intent);

                if (checkBox.isChecked()) result = checkBox.getText().toString();
                else result = "x";
                JSONObject postDataParam = new JSONObject();//JSON생성 : JSONObject는 JSON형태의 데이터를 관리해 주는 메서드
                try {
                    postDataParam.put("username",local.username);
                    postDataParam.put("timeofarrival",String.valueOf(timePicker.getCurrentHour()+"시"+timePicker.getCurrentMinute()+"분"));//데이터 집어넣기
                    postDataParam.put("menu",name1);
                    postDataParam.put("number",String.valueOf(num.getValue()));
                    postDataParam.put("takeout",result);
                } catch (JSONException e) {
                    Log.e("TAG", "JSONEXception");
                }
                Splash.act=3;
                new InsertData(ClickActivity.this).execute(postDataParam);

            }
        });

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();

        }
        return (super.onOptionsItemSelected(item));
    }
}
