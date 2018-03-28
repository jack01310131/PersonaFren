package com.example.user.personafren;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends Activity implements View.OnClickListener {

    TextView Login,Back,ForgotPwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Back = (TextView) findViewById(R.id.back);
        Login = (TextView) findViewById(R.id.Login);
        ForgotPwd = (TextView) findViewById(R.id.ForgotPwd);

        Back.setOnClickListener(this);
        Login.setOnClickListener(this);
        ForgotPwd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.back:
                intent.setClass(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.Login:
                intent.setClass(LoginActivity.this, PairMainActivity.class);
                startActivity(intent);
                break;
            case R.id.ForgotPwd:
                intent.setClass(LoginActivity.this, ForgotPwdActivity.class);
                startActivity(intent);
                break;
        }
    }
}
