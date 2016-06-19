package com.technocurl.www.zendernewdesign;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dinesh on 4/18/16.
 */
public class ChinessActivity extends AppCompatActivity implements  OnItemClickListener, OnItemSelectedListener, View.OnClickListener {
    AutoCompleteTextView textView;
    private ArrayAdapter<String> adapter;
    Button btnWhat;
    String item[]={
            "January", "February", "March", "April",
            "May", "June", "July", "August",
            "September", "October", "November", "December"};

    final static int RQS_1 = 1;

    EditText mothrAge;
    Button calc;
    ImageView imbutton;
    private Handler mHandler = new Handler();
    int mProgressStatus=0;
    private ProgressBar progBar;
    LinearLayout ll;
    int dateconception;
    /** Called when the activity is first created. */


    public static Drawable getAssetImage(Context context, String filename) throws IOException {
        AssetManager assets = context.getResources().getAssets();
        InputStream buffer = new BufferedInputStream((assets.open("drawable/" + filename)));
        Bitmap bitmap = BitmapFactory.decodeStream(buffer);
        return new BitmapDrawable(context.getResources(), bitmap);
    }


    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.chiness_main);

        mothrAge = (EditText) findViewById(R.id.mothrAge);
        textView = (AutoCompleteTextView) findViewById(R.id.dateChick);
        calc = (Button) findViewById(R.id.calculate);
        progBar= (ProgressBar)findViewById(R.id.progressBar);
        /*ll=(LinearLayout) findViewById(R.id.chinessMain);

        try {
            if (Build.VERSION.SDK_INT >= 16) {
                ll.setBackground(getAssetImage(this, "background_drawable.jpg"));

            } else {
                ll.setBackgroundDrawable(getAssetImage(this, "background_drawable.jpg"));
            }


        } catch (IOException e) {
            e.printStackTrace();
        }*/

    final LinearLayout linearLayout=(LinearLayout) findViewById(R.id.linearLayoutchiness) ;
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout.setVisibility(View.GONE);
                dosomething();
            }
        });

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,item);

        textView.setAdapter(adapter);
        textView.setThreshold(1);
        textView.setOnItemSelectedListener(this);
        textView.setOnItemClickListener(this);

        textView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    textView.showDropDown();
                }
            }
        });
        textView.setInputType(textView.getInputType()| EditorInfo.TYPE_TEXT_FLAG_NO_SUGGESTIONS | EditorInfo.TYPE_TEXT_VARIATION_FILTER);
/**
 * Unset the var whenever the user types. Validation will
 * then fail. This is how we enforce selecting from the list.
 */
        textView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                item = null;
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });

        /*btnWhat=(Button) findViewById(R.id.calculate);
        btnWhat.setOnClickListener(this);*/

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Chiness Method");
}
   @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
                               long arg3) {
        // TODO Auto-generated method stub
        //Log.d("AutocompleteContacts", "onItemSelected() position " + position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub

        InputMethodManager imm = (InputMethodManager) getSystemService(
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);

    }

    @Override
    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        // TODO Auto-generated method stub



    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            /*case R.id.imgBtn:

                AlertDialog alertDialog = new AlertDialog.Builder(ChinessActivity.this).create(); //Read Update
                alertDialog.setTitle("mom age");
                alertDialog.setMessage("this is my app");

                alertDialog.setButton("Continue..", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // here you can add functions
                    }
                });

                alertDialog.show();*/


        }
    }
    /*public void takeData() {
        int minimum = Integer.parseInt(mothrAge.getText().toString());
        String dateconceptionn=textView.getText().toString();
        if ((minimum >= 18 && minimum <= 45) && (dateconceptionn.equals("January")||dateconceptionn.equals("February")||dateconceptionn.equals("March")||dateconceptionn.equals("April")||dateconceptionn.equals("May")||dateconceptionn.equals("June")||dateconceptionn.equals("July")||dateconceptionn.equals("August")||dateconceptionn.equals("September")||dateconceptionn.equals("October")||dateconceptionn.equals("November")||dateconceptionn.equals("December") ) ) {

            String mother = mothrAge.getText().toString();

            String chick = textView.getText().toString();

            if (mother.equals("18")) {
                if ((chick.equals("January") || chick.equals("March"))) {
                   showGirl();
                } else {
                   showBoy();
                }
            } else if (mother.equals("19")) {
                if ((chick.equals("February") || chick.equals("April") || chick.equals("May") || chick.equals("November") || chick.equals("December"))) {
                   showGirl();
                } else {
                   showBoy();
                }
            } else if (mother.equals("20")) {
                if ((chick.equals("January")) || chick.equals("March") || chick.equals("October")) {
                   showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("21")) {
                if ((chick.equals("February")) || chick.equals("March") || chick.equals("April") || chick.equals("May") || chick.equals("June") || chick.equals("July") || chick.equals("August") || chick.equals("September") || chick.equals("October") || chick.equals("November") || chick.equals("December")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("22")) {

                if ((chick.equals("January")) || chick.equals("April") || chick.equals("June") || chick.equals("july") || chick.equals("September") || chick.equals("October") || chick.equals("November") || chick.equals("December")) {
                    showGirl();
                } else {
                   showBoy();
                }
            } else if (mother.equals("23")) {
                if ((chick.equals("March")) || chick.equals("June") || chick.equals("August") || chick.equals("December")) {
                  showGirl();

                } else {
                    showBoy();


                }
            } else if (mother.equals("24")) {
                if ((chick.equals("February")) || chick.equals("May") || chick.equals("August") || chick.equals("September") || chick.equals("October") || chick.equals("November") || chick.equals("December")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("25")) {
                if ((chick.equals("January")) || chick.equals("April") || chick.equals("May") || chick.equals("july")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("26")) {
                if ((chick.equals("February")) || chick.equals("April") || chick.equals("May") || chick.equals("july")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("27")) {
                if ((chick.equals("January")) || chick.equals("March") || chick.equals("May") || chick.equals("June") || chick.equals("November")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals(("28"))) {
                if (chick.equals("February") || chick.equals("April") || chick.equals("May") || chick.equals("June") || chick.equals("November") || chick.equals("December")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("29")) {
                if (chick.equals("January") || chick.equals("March") || chick.equals("April") || chick.equals("October") || chick.equals("November") || chick.equals("December")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("30")) {
                if (chick.equals("February") || chick.equals("March") || chick.equals("April") || chick.equals("May") || chick.equals("June") || chick.equals("July") || chick.equals("August") || chick.equals("September") || chick.equals("October")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if ((mother.equals("31"))) {
                if (chick.equals("February") || chick.equals("April") || chick.equals("May") || chick.equals("June") || chick.equals("july") || chick.equals("August") || chick.equals("September") || chick.equals("October") || chick.equals("November")) {
                    showGirl();
                } else {
                    showBoy();
                }


            } else if (mother.equals("32")) {
                if (chick.equals("February") || chick.equals("April") || chick.equals("May") || chick.equals("June") || chick.equals("July") || chick.equals("August") || chick.equals("September") || chick.equals("October") || chick.equals("November")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("33")) {
                if (chick.equals("January") || chick.equals("March") || chick.equals("May") || chick.equals("June") || chick.equals("July") || chick.equals("September") || chick.equals("October") || chick.equals("November")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("34")) {
                if (chick.equals("January") || chick.equals("April") || chick.equals("May") || chick.equals("June") || chick.equals("July") || chick.equals("September") || chick.equals("October")) {
                    showGirl();
                } else {
                    showBoy();
                }


            } else if (mother.equals("35")) {
                if (chick.equals("March") || chick.equals("May") || chick.equals("June") || chick.equals("July") || chick.equals("September") || chick.equals("October")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("36")) {
                if (chick.equals("January") || chick.equals("April") || chick.equals("June") || chick.equals("July") || chick.equals("August")) {
                    showGirl();
                } else {
                    showBoy();
                }

                } else if (mother.equals("37")) {
                if (chick.equals("February") || chick.equals("May") || chick.equals("June") || chick.equals("July") || chick.equals("September") || chick.equals("November")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("38")) {
                if (chick.equals("January") || chick.equals("March") || chick.equals("June") || chick.equals("August") || chick.equals("October") || chick.equals("December")) {
                    showGirl();
                } else {
                    showBoy();
                }

            } else if (mother.equals("39")) {
                if (chick.equals("February") || chick.equals("June") || chick.equals("July") || chick.equals("September") || chick.equals("November") || chick.equals("December")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("40")) {
                if (chick.equals("January") || chick.equals("March") || chick.equals("May") || chick.equals("August") || chick.equals("October") || chick.equals("December")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("41")) {
                if (chick.equals("January") || chick.equals("April") || chick.equals("June") || chick.equals("September") || chick.equals("November")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("42")) {
                if (chick.equals("January") || chick.equals("March") || chick.equals("May") || chick.equals("July") || chick.equals("October") || chick.equals("December")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("43")) {
                if (chick.equals("February") || chick.equals("April") || chick.equals("June") || chick.equals("August")) {
                    showGirl();
                } else {
                    showBoy();
                }*/

/*
                (dateconceptionn.equals("January")){
                    dateconception = 1;
                }else if(dateconceptionn.equals("February")){
                    dateconception=2;
                }else if (dateconceptionn.equals("March")){
                    dateconception=3;
                }else if (dateconceptionn.equals("April")){
                    dateconception=4;
                }else if (dateconceptionn.equals("May")){
                    dateconception=5;
                }else if (dateconceptionn.equals("June")){
                    dateconception=6;
                }else if(dateconceptionn.equals("July")){
                    dateconception=7;
                }else if (dateconceptionn.equals("August")){
                    dateconception=8;
                }else if (dateconceptionn.equals("September")){
                    dateconception=9;
                }else if (dateconceptionn.equals("October")){
                    dateconception=10;
                }else if(dateconceptionn.equals("November")){
                    dateconception=11;
                }else if (dateconceptionn.equals("December")){
                    dateconception=12;

            } else if (mother.equals("44")) {
                if (chick.equals("March") || chick.equals("July") || chick.equals("September") || chick.equals("November") || chick.equals("December")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else if (mother.equals("45")) {
                if (chick.equals("January") || chick.equals("April") || chick.equals("May") || chick.equals("June") || chick.equals("August") || chick.equals("October")) {
                    showGirl();
                } else {
                    showBoy();
                }
            } else {
                Snackbar snackbar = Snackbar.make(ll, "Please enter  valid input ", Snackbar.LENGTH_LONG);
                View snackBarView = snackbar.getView();
                snackBarView.setBackgroundColor(getResources().getColor(R.color.blood_button_pressed));
                snackbar.setActionTextColor(getResources().getColor(R.color.chiness_button_pressed));
                snackbar.show();
            }


        }else {
            Snackbar snackbar = Snackbar.make(ll, "Please enter  valid input ", Snackbar.LENGTH_LONG);
            View snackBarView = snackbar.getView();
            snackBarView.setBackgroundColor(getResources().getColor(R.color.blood_button_pressed));
            snackbar.setActionTextColor(getResources().getColor(R.color.chiness_button_pressed));
            snackbar.show();
        }
    }
*/

    public void dosomething() {

        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus <= 100) {
                    mProgressStatus += 1;
                    mHandler.post(new Runnable() {
                        public void run() {
                            progBar.setVisibility(View.VISIBLE);
                            progBar.setProgress(mProgressStatus);
                            if (mProgressStatus == 100){
                                progBar.setVisibility(View.GONE);
//                                takeData();


                            }

                        }
                    });
                    try {



                        Thread.sleep(50);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        }).start();

    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent( event );
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        /*super.*/onBackPressed();
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(ChinessActivity.this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
        finish();
    }
   /* public void showBoy(){


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    Intent intent =new Intent (ChinessActivity.this,BloodActivity.class);
                    startActivity(intent);
                }
            });
        }
        AlertDialog dialog = builder.create();
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.blood_boy, null);

        dialog.setView(dialogLayout);
        //Controlling width and height.
        Button bloodBoy=(Button)dialogLayout.findViewById(R.id.btnBloodboy);
        bloodBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (ChinessActivity.this,ChinessActivity.class);
                startActivity(intent);
            }
        });

//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = dialog.getWindow();
        window.setLayout(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();

    }
    public void showGirl(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            builder*//*.setPositiveButton("Check Again", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    }).setNegativeButton("No thanks", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })*//*.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    Intent intent =new Intent (ChinessActivity.this,ChinessActivity.class);
                    startActivity(intent);
                }
            });
        }
        AlertDialog dialog = builder.create();
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayout = inflater.inflate(R.layout.blood_girl, null);
        dialog.setView(dialogLayout);
        Button bloodGirl=(Button)dialogLayout.findViewById(R.id.btnBloodgirl);
        bloodGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent (ChinessActivity.this,ChinessActivity.class);
                startActivity(intent);
            }
        });
//                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        dialog.show();
    }*/
    }
