package com.technocurl.www.zendernewdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.technocurl.www.zendernewdesign.quize.QuizeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FrameLayout chiness,blood,quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chiness=(FrameLayout) findViewById(R.id.chiness_main);
        blood=(FrameLayout) findViewById(R.id.blood_main);
        quiz=(FrameLayout) findViewById(R.id.play_quiz);
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
