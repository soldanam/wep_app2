package com.example.dasol.wep_app2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    final static String url = "http://13.125.129.127:3000/users/regi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getSupportActionBar().hide();

        Button registerB = (Button) findViewById(R.id.registerButton);//회원가입
        registerB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gologin = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(gologin);

                EditText edit_ID = (EditText) findViewById(R.id.idText); //Title= ID 로 바꿈
                EditText edit_PASSWORD = (EditText) findViewById(R.id.passwordText);//content = Password 로 바꿈
                EditText edit_NAME = (EditText) findViewById(R.id.nameText); //Title= ID 로 바꿈
                EditText edit_EMAIL = (EditText) findViewById(R.id.emailText);//content = Password 로 바꿈

                JSONObject postDataParam = new JSONObject();//JSON생성 : JSONObject는 JSON형태의 데이터를 관리해 주는 메서드
                try {
                    postDataParam.put("name", edit_NAME.getText().toString());//데이터 집어넣기
                    postDataParam.put("email", edit_EMAIL.getText().toString());
                    postDataParam.put("username", edit_ID.getText().toString());//데이터 집어넣기
                    postDataParam.put("password", edit_PASSWORD.getText().toString());

                } catch (JSONException e) {
                    Log.e("TAG", "JSONEXception");
                }
                Splash.act = 1;
                new InsertData(RegisterActivity.this).execute(postDataParam); //ui 작업해주기 위해 asynctask 실행 insert에


            }
        });



    }
}