package com.example.dasol.wep_app2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    final static String url = "http://10.0.2.2:3000/users/authenticate";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();

        Button loginBtn = (Button) findViewById(R.id.loginButton);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText login_ID = (EditText) findViewById(R.id.login_idText); //Title= ID 로 바꿈
                EditText login_PASSWORD = (EditText) findViewById(R.id.login_passwordText);//content = Password 로 바꿈

                JSONObject postDataParam_login = new JSONObject();//JSON생성 : JSONObject는 JSON형태의 데이터를 관리해 주는 메서드
                try {
                    postDataParam_login.put("username", login_ID.getText().toString());//데이터 집어넣기
                    postDataParam_login.put("password", login_PASSWORD.getText().toString());
                } catch (JSONException e) {
                    Log.e("TAG", "JSONEXception");
                }
                Splash.act=2;
                new InsertData(LoginActivity.this).execute(postDataParam_login);

            }
        });

       TextView registerButton = (TextView) findViewById(R.id.login_registerButton);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(register);
            }
        });



    }
}
