package com.technocurl.www.zendernewdesign.quize;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.technocurl.www.zendernewdesign.R;

import java.util.List;


public class QuizeActivity extends AppCompatActivity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc;
    Button butNext;
    private Handler mHandler = new Handler();
     int mProgressStatus=0;
    private ProgressBar progBar;
    LinearLayout quizeLinear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quize);
        DbHelper db=new DbHelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        progBar= (ProgressBar)findViewById(R.id.progressBarLayout);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        butNext=(Button)findViewById(R.id.button1);
        quizeLinear=(LinearLayout) findViewById(R.id.quize_iinearLayout);
        final RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (grp.getCheckedRadioButtonId() == -1){
                    Snackbar snackbar = Snackbar.make(v, "Please  select one", Snackbar.LENGTH_LONG);
                    View snackBarView = snackbar.getView();
                    snackBarView.setBackgroundColor(getResources().getColor(R.color.blood_button_pressed));
                    snackbar.setActionTextColor(getResources().getColor(R.color.chiness_button_pressed));
                    snackbar.show();
                }else {
                    RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                    if(currentQ.getANSWER().equals(answer.getText()))
                    {
                        score++;
                        Log.d("score", "Your score"+score);
                    }
                    if(qid<13){
                        currentQ=quesList.get(qid);
                        setQuestionView();
                    }else{
                        dosomething();
                    }

                    grp.clearCheck();
                }

            }
        });


    }

    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        qid++;
    }
    public void dosomething() {

        new Thread(new Runnable() {
            public void run() {
                while (mProgressStatus <= 100) {
                    mProgressStatus += 1;
                    mHandler.post(new Runnable() {
                        public void run() {
                            quizeLinear.setVisibility(View.GONE);
                            progBar.setVisibility(View.VISIBLE);
                            progBar.setProgress(mProgressStatus);
//                            text.setText(""+mProgressStatus+"%");
                            if (mProgressStatus == 100){
                                Intent intent = new Intent(QuizeActivity.this,ResultActivity.class);
                                Bundle b = new Bundle();
                                b.putInt("score", score); //Your score
                                intent.putExtras(b); //Put your score to your next Intent
                                startActivity(intent);
                                finish();
//                                startActivity(intent);
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