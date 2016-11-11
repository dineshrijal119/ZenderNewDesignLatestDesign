package com.technocurl.www.zendernewdesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import com.technocurl.www.zendernewdesign.blood.BloodActivity;
import com.technocurl.www.zendernewdesign.quize.QuizeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout chiness,blood,quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chiness=(LinearLayout) findViewById(R.id.chiness_main);
        blood=(LinearLayout) findViewById(R.id.blood_main);
        quiz=(LinearLayout) findViewById(R.id.play_quiz);
        chiness.setOnClickListener(this);
        blood.setOnClickListener(this);
        quiz.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chiness_main:
               startActivity(new Intent(MainActivity.this,ChinessActivity.class));
                break;
            case R.id.blood_main:
                startActivity(new Intent(MainActivity.this,BloodActivity.class));
                break;
            case R.id.play_quiz:
                startActivity(new Intent(MainActivity.this,QuizeActivity.class));
                break;
        }
    }
}
