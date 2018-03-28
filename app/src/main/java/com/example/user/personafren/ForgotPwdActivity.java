package com.example.user.personafren;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ForgotPwdActivity extends Activity implements View.OnClickListener {

    TextView Back,submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_pwd);

        Back = (TextView) findViewById(R.id.back2);
        submit = (TextView) findViewById(R.id.submit);

        Back.setOnClickListener(this);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.back2:
                intent.setClass(ForgotPwdActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.submit:
                intent.setClass(ForgotPwdActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
