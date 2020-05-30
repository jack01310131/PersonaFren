package com.example.user.personafren;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.personafren.AbilityModel;
import com.example.user.personafren.AbilityView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AbilityPActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ability_p);

        String[] titles = {"第一型", "第二型", "第三型", "第四型", "第五型", "第六型", "第七型", "第八型", "第九型"};

        AbilityView av_test = (AbilityView) findViewById(R.id.av_test);
        List<AbilityModel> models = new ArrayList<AbilityModel>();
        Random random = new Random();

        for (int i = 0; i < titles.length; i++) {
            AbilityModel model = null;
            model = new AbilityModel(titles[i], (random.nextInt(5) + 4) / 10f);
            models.add(model);
        }
        av_test.setTitleSize(16);//设置标题文字大小
        av_test.setValueSize(12);//设置数值文字大小
        av_test.setLayer_count(5);//设置圆环层数
        av_test.setData(models, this);
    }
}
