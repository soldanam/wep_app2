package com.example.dasol.wep_app2;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        getSupportActionBar().hide();

        Intent intent = getIntent();
       // String a;
        final ImageView profile = (ImageView)findViewById(R.id.end_image);
        final TextView name =(TextView)findViewById(R.id.end_name);
        final TextView time =(TextView)findViewById(R.id.end_time);
        Button btn = (Button)findViewById(R.id.button);

        profile.setImageResource(intent.getExtras().getInt("img"));
        ImageView p=(ImageView)findViewById(R.id.end_image);
        name.setText(intent.getStringExtra("name"));
        time.setText("수령 시간"+intent.getStringExtra("time"));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EndActivity.this, OrderActivity.class);
                startActivity(intent);
            }
        });



    }
}
