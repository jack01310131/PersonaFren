package com.example.user.personafren;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.personafren.item.DBConnector;
import com.example.user.personafren.item.PairItem;

import org.json.JSONArray;
import org.json.JSONObject;

public class PairMainActivity extends Activity implements View.OnClickListener {

    ImageView goRader,goMe,goPair;
    TextView text;
    Button start;
    String OtherPersonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pair_main);

        goRader = (ImageView) findViewById(R.id.goRader);
        goMe = (ImageView) findViewById(R.id.goMe);
        goPair = (ImageView) findViewById(R.id.goPair);

        goRader.setOnClickListener(this);
        goMe.setOnClickListener(this);
        goPair.setOnClickListener(this);

        text = (TextView) findViewById(R.id.text);
        start = (Button) findViewById(R.id.start);

        start.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()) {
            case R.id.goRader:
                intent.setClass(PairMainActivity.this, RaderMainActivity.class);
                startActivity(intent);
                break;
            case R.id.goMe:
                intent.setClass(PairMainActivity.this, MeMainActivity.class);
                startActivity(intent);
                break;
            case R.id.goPair:

                break;
            case R.id.start:
                PairItem PItem = new PairItem(1,1);
                OtherPersonName = PItem.ChoosePersonality();
                text.setText( OtherPersonName );
                break;
        }
    }

    private void connection() {
        try {
            String result = DBConnector.executeQuery("SELECT * FROM member" );
            System.out.println("aa "+result);
            /*
                    SQL 結果有多筆資料時使用JSONArray
                    只有一筆資料時直接建立JSONObject物件
                    JSONObject jsonData = new JSONObject(result);
                */
            JSONArray jsonArray = new JSONArray(result);
            System.out.println("jsonArray.length() "+jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonData = jsonArray.getJSONObject(i);
                text.setText(jsonData.getString("Name"));
            }
            Log.e("log_tag","123124");
                System.out.println("connect ok"+result);

        } catch(Exception e) {
             Log.e("log_tag", e.toString());
            System.out.println("connect failed");
        }
    }

}
