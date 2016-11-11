package com.technocurl.www.zendernewdesign.blood;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.technocurl.www.zendernewdesign.R;

/**
 * Created by root on 5/27/16.
 */
public class BloodActivityResultBoy  extends AppCompatActivity{
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blood_boy);
        Button boy=(Button) findViewById(R.id.btnBloodboy);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BloodActivityResultBoy.this,BloodActivity.class));
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(BloodActivityResultBoy.this,BloodActivity.class));
        super.onBackPressed();
    }
}
