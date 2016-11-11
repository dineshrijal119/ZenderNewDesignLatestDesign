package com.technocurl.www.zendernewdesign.blood;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.technocurl.www.zendernewdesign.R;

/**
 * Created by deadlydragger on 11/11/16.
 */

public class Bloodmainfragment extends Fragment implements View.OnClickListener {
    EditText momAgeConcp,dadAgeConcp;
    private double dadAgeDevided = 0.0d;
    private double momAgeDevided = 0.0d;
    Button calculation;
    LinearLayout linearLayout;
    private Handler mHandler = new Handler();
    int mProgressStatus=0;
    private ProgressBar progBar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        momAgeConcp=(EditText)view. findViewById(R.id.mothrBlood);
        dadAgeConcp=(EditText)view. findViewById(R.id.dadBlood);
        calculation=(Button) view.findViewById(R.id.bloodCalculate);
        progBar= (ProgressBar)view.findViewById(R.id.progressBarBlood);
        linearLayout=(LinearLayout)view. findViewById(R.id.bloodLinear);
        calculation.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.blood_main,container,false);
    }
    public void calculate(){
        int momAgeAtConception= Integer.parseInt(momAgeConcp.getText().toString());
        int dadAgeAtConception=Integer.parseInt(dadAgeConcp.getText().toString());
        dadAgeDevided = (((double) dadAgeAtConception) / 4.0d) - ((double) (dadAgeAtConception / 4));
        momAgeDevided = (((double) momAgeAtConception) / 3.0d) - ((double) (momAgeAtConception / 3));
        if (momAgeDevided < dadAgeDevided) {
            Intent intent =new Intent (getActivity(),BloodActivityResultGirl.class);
            startActivity(intent);
        } else {

            Intent intent =new Intent (getActivity(),BloodActivityResultBoy.class);
            startActivity(intent);

        }
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bloodCalculate:
                String checkmom=momAgeConcp.getText().toString();
                String checkDad=dadAgeConcp.getText().toString();
                if ((checkmom==null || checkmom.equals(""))  || (checkDad==null || checkDad.equals(""))) {
                    Snackbar snackbar = Snackbar.make(v, "Please enter input.. ", Snackbar.LENGTH_LONG);
                    View snackBarView = snackbar.getView();
                    snackBarView.setBackgroundColor(getResources().getColor(R.color.blood_button_pressed));
                    snackbar.setActionTextColor(getResources().getColor(R.color.chiness_button_pressed));
                    snackbar.show();
                }else {
                    int momAgeAtConception = Integer.parseInt(momAgeConcp.getText().toString());
                    int dadAgeAtConception = Integer.parseInt(dadAgeConcp.getText().toString());
                    if ((momAgeAtConception >= 16 && momAgeAtConception <= 60) && dadAgeAtConception >= 16 && dadAgeAtConception <= 70) {
                        dosomething();
                    } else {
                        Snackbar snackbar = Snackbar.make(v, "Please enter  valid input ", Snackbar.LENGTH_LONG);
                        View snackBarView = snackbar.getView();
                        snackBarView.setBackgroundColor(getResources().getColor(R.color.blood_button_pressed));
                        snackbar.setActionTextColor(getResources().getColor(R.color.chiness_button_pressed));
                        snackbar.show();
                    }

                }

                break;
        }

    }

    public void dosomething() {

        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus <= 100) {
                    mProgressStatus += 1;
                    mHandler.post(new Runnable() {
                        public void run() {
                            progBar.setVisibility(View.VISIBLE);
                            progBar.setProgress(mProgressStatus);
                            linearLayout.setVisibility(View.GONE);
//                            text.setText(""+mProgressStatus+"%");
                            if (mProgressStatus == 100){
                                calculate();

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
}
