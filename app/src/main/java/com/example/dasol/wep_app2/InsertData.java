package com.example.dasol.wep_app2;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;


public class InsertData extends PostRequest {
    public InsertData(Activity activity) {
        super(activity);
    }

    @Override
    protected void onPreExecute() {
        String serverURLStr="";
        if(Splash.act == 1){
            serverURLStr = RegisterActivity.url.toString();

        }
        else if(Splash.act==2){
            serverURLStr = LoginActivity.url.toString();
        }
        else if(Splash.act==3){
            serverURLStr=ClickActivity.url.toString();
        }
        try {
            url = new URL(serverURLStr);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

}
