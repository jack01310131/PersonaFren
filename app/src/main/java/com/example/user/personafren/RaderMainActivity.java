package com.example.user.personafren;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class RaderMainActivity extends Activity implements View.OnClickListener {

    ImageView goRader,goMe,goPair,conditionButton,goBeacon,goGPS;
    LinearLayout conditionLayout;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rader_main);
        goRader = (ImageView) findViewById(R.id.goRader);
        goMe = (ImageView) findViewById(R.id.goMe);
        goPair = (ImageView) findViewById(R.id.goPair);
        goBeacon = (ImageView) findViewById(R.id.goBeacon);
        conditionButton = (ImageView) findViewById(R.id.conditionButton);
        conditionLayout = (LinearLayout) findViewById(R.id.conditionLayout);
        submit = (Button) findViewById(R.id.submit);

        goRader.setOnClickListener(this);
        goMe.setOnClickListener(this);
        goPair.setOnClickListener(this);
        goBeacon.setOnClickListener(this);
        conditionButton.setOnClickListener(this);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.goRader:

                break;
            case R.id.goMe:
                intent.setClass(RaderMainActivity.this, MeMainActivity.class);
                startActivity(intent);
                break;
            case R.id.goPair:
                intent.setClass(RaderMainActivity.this, PairMainActivity.class);
                startActivity(intent);
                break;
            case R.id.goBeacon:
                setBeacon();
                break;
            case R.id.goGPS:
                setGPS();
                break;
            case R.id.conditionButton:
                conditionLayout.setVisibility(View.VISIBLE);
                break;
            case R.id.submit:
                conditionLayout.setVisibility(View.GONE);
                break;
        }
    }

    public void setBeacon(){
        setContentView(R.layout.activity_rader_beacon);
        goRader = (ImageView) findViewById(R.id.goRader);
        goMe = (ImageView) findViewById(R.id.goMe);
        goPair = (ImageView) findViewById(R.id.goPair);
        goGPS = (ImageView) findViewById(R.id.goGPS);
        conditionButton = (ImageView) findViewById(R.id.conditionButton);
        conditionLayout = (LinearLayout) findViewById(R.id.conditionLayout);
        submit = (Button) findViewById(R.id.submit);

        goRader.setOnClickListener(this);
        goMe.setOnClickListener(this);
        goPair.setOnClickListener(this);
        goGPS.setOnClickListener(this);
        conditionButton.setOnClickListener(this);
        submit.setOnClickListener(this);
    }
    public void setGPS(){
        setContentView(R.layout.activity_rader_main);
        goRader = (ImageView) findViewById(R.id.goRader);
        goMe = (ImageView) findViewById(R.id.goMe);
        goPair = (ImageView) findViewById(R.id.goPair);
        goBeacon = (ImageView) findViewById(R.id.goBeacon);
        conditionButton = (ImageView) findViewById(R.id.conditionButton);
        conditionLayout = (LinearLayout) findViewById(R.id.conditionLayout);
        submit = (Button) findViewById(R.id.submit);

        goRader.setOnClickListener(this);
        goMe.setOnClickListener(this);
        goPair.setOnClickListener(this);
        goBeacon.setOnClickListener(this);
        conditionButton.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

}
