package com.example.dasol.wep_app2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    static int act = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        Handler hd = new Handler();
        hd.postDelayed(new splashhandler(),3000);

    }
    private class splashhandler implements Runnable{
        @Override
        public void run() {
            startActivity(new Intent(getApplication(),LoginActivity.class));
            Splash.this.finish();
        }
    }
}
