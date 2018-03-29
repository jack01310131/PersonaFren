package com.example.user.personafren;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    ImageView FbLogin;
    TextView Login,Signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        FbLogin = (ImageView) findViewById(R.id.FbLogin);
        Login = (TextView) findViewById(R.id.Login);
        Signup = (TextView) findViewById(R.id.Signup);

        FbLogin.setOnClickListener(this);
        Login.setOnClickListener(this);
        Signup.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.FbLogin:
                intent.setClass(MainActivity.this, PairMainActivity.class);
                startActivity(intent);
                break;
            case R.id.Login:
                intent.setClass(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.Signup:
                intent.setClass(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
        }

    }
}
