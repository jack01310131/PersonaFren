package com.example.user.personafren;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SignUpActivity extends Activity implements View.OnClickListener {

    TextView Submit,Back,birthday_TextView;
    RelativeLayout birlayput;
    Button getbir;
    DatePicker birpicker;
    int day,month,year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Back = (TextView) findViewById(R.id.back4);
        Submit = (TextView) findViewById(R.id.submit3);
        birthday_TextView = (TextView) findViewById(R.id.birthday_TextView);
        birlayput =(RelativeLayout) findViewById(R.id.birlayput);
        birpicker = (DatePicker) findViewById(R.id.birpicker);
        getbir = (Button) findViewById(R.id.getbir);

        Back.setOnClickListener(this);
        Submit.setOnClickListener(this);
        birthday_TextView.setOnClickListener(this);
        getbir.setOnClickListener(this);
        birlayput.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.back:
                intent.setClass(SignUpActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.submit3:
                intent.setClass(SignUpActivity.this, PairMainActivity.class);
                startActivity(intent);
                break;
            case R.id.birthday_TextView:
                birlayput.setVisibility(view.VISIBLE);
                break;
            case R.id.getbir:
                day = birpicker.getDayOfMonth();
                month = birpicker.getMonth() + 1;
                year = birpicker.getYear();
                birthday_TextView.setText(year+"/"+month+"/"+day);
                birlayput.setVisibility(view.GONE);
                break;
        }
    }
}
