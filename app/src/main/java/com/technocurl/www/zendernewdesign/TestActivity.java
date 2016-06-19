package com.technocurl.www.zendernewdesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by dinesh on 5/20/16.
 */
public class TestActivity extends AppCompatActivity implements View.OnClickListener {
    EditText one ,two;
    Button click;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        one=(EditText) findViewById(R.id.testone);
        two=(EditText) findViewById(R.id.testtwo);
        click=(Button) findViewById(R.id.btn);
        click.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn:
               String onenew=one.getText().toString();
                String twonew=two.getText().toString();
                Toast.makeText(getApplicationContext(),onenew+twonew,Toast.LENGTH_LONG).show();
                break;
        }
    }
}
