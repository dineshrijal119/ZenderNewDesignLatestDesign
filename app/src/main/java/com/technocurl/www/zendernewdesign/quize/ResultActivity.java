package com.technocurl.www.zendernewdesign.quize;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.technocurl.www.zendernewdesign.MainActivity;
import com.technocurl.www.zendernewdesign.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener{
	ImageView imgQize;
	Button setOth;
	public static Drawable getAssetImage(Context context, String filename) throws IOException {
		AssetManager assets = context.getResources().getAssets();
		InputStream buffer = new BufferedInputStream((assets.open("drawable/" + filename)));
		Bitmap bitmap = BitmapFactory.decodeStream(buffer);
		return new BitmapDrawable(context.getResources(), bitmap);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result_quize);
		TextView t=(TextView)findViewById(R.id.textResult);
		imgQize=(ImageView) findViewById(R.id.quizeImage) ;
		ActionBar actionBar = getSupportActionBar();
		setOth=(Button) findViewById(R.id.setAnother);
		setOth.setOnClickListener(this);
		actionBar.setDisplayHomeAsUpEnabled(true);
		actionBar.setTitle("Quize Result");
		Bundle b = getIntent().getExtras();
		int score= b.getInt("score");


		LinearLayout ll = (LinearLayout) findViewById(R.id.activityResult);
		try {
			if (Build.VERSION.SDK_INT >= 16) {
				ll.setBackground(getAssetImage(this, "drawable/blur_red.jpg"));



			} else {
				ll.setBackgroundDrawable(getAssetImage(this, "drawable/blur_red.jpg"));
			}


		} catch (IOException e) {
			e.printStackTrace();
		}

		switch (score)
		{
		case 1:t.setText("cute girl !!");
			imgQize.setImageResource(R.drawable.female_new);
			break;
		case 2: t.setText("boy !!");
			imgQize.setImageResource(R.drawable.male_new_new);
		break;
		case 3:
			t.setText("boy !!");
			imgQize.setImageResource(R.drawable.male_new_new);
			break;
		case 4:t.setText("girl !!!");
			imgQize.setImageResource(R.drawable.female_new);
			break;
		case 5:t.setText("Twins !!");
			imgQize.setImageResource(R.drawable.twins);
		break;
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		onBackPressed();
		return super.onOptionsItemSelected(item);
	}
	@Override
	public void onBackPressed() {
		super.onBackPressed();
		Intent i = new Intent(ResultActivity.this, MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		finish();
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()){
			case R.id.setAnother:
				Intent intent= new Intent(ResultActivity.this,QuizeActivity.class);
				startActivity(intent);
				break;
		}
	}
}
