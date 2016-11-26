package com.example.aaishsindwani.careerguide;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.serhatsurguvec.continuablecirclecountdownview.ContinuableCircleCountDownView;

import java.util.ArrayList;
import java.util.List;

public class psychometric extends Activity {
    List<String> quesList;
    CountDownTimer cdt;
    //int score=0;
    int qid=0;
    TextView txtQuestion;
    Button rda, rdb, rdc;
    Button butNext;
    String selected;
    int score=0;
    ContinuableCircleCountDownView mCountDownView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psychometric);
        mCountDownView = (ContinuableCircleCountDownView) findViewById(R.id.circleCountDownView_p);
        //setTitle("Academic Quiz");
        quesList = new ArrayList<String>();
        quesList.add("I like to solve mathematical or scientific problems");
        quesList.add("I like to work with machines and tools");
        quesList.add("I like to help people, like teaching, first aid, or giving information");
        quesList.add("I like to do creative activities like art, drama, crafts, dance, music, or creative writing.");
        quesList.add("I like to lead and persuade people, and can sell ideas and things.");
        quesList.add("I like to work with numbers, records, or machines in a set, orderly way.");
        quesList.add("I am good at understanding and solving science and math problems.");
        quesList.add("I have good skills in working with tools, mechanical drawings, machines, or animals.");
        quesList.add("I am good at teaching, counseling, nursing, or giving information.");
        quesList.add("I have good artistic abilities -- in creative writing, drama, crafts, music, or art.");
        quesList.add("I am good at leading people and selling things or ideas.");
        quesList.add("I am good at maintaining written records and numbers in a systematic, orderly way.");
        quesList.add("I am precise, scientific, and intellectual.");
        quesList.add("I am practical, mechanical, and realistic.");
        quesList.add("I am helpful, friendly, and trustworthy.\n");
        quesList.add("I am artistic, imaginative, original, and independent.");
        quesList.add("I am energetic, ambitious, and sociable.");
        quesList.add("I am orderly and good at following a set plan.");
        quesList.add("I value science.");
        quesList.add("I value practical things and making better.");
        quesList.add("I value helping people and solving social problems.");
        quesList.add("I value creative arts like drama, music, art, or the works of creative writers.");
        quesList.add("I value success in politics, leadership, or business.");
        quesList.add("I value success in business.\n");
        txtQuestion=(TextView)findViewById(R.id.textView1_p);
        rda=(Button)findViewById(R.id.radio0_p);
        rdb=(Button)findViewById(R.id.radio1_p);
        rdc=(Button)findViewById(R.id.radio2_p);
        mCountDownView.setTimer(30000);
        mCountDownView.start();
        mCountDownView.setListener(new ContinuableCircleCountDownView.OnCountDownCompletedListener() {
            @Override
            public void onTick(long passedMillis) {

            }

            @Override
            public void onCompleted() {
                mCountDownView.cancel();
                nextscreen();
            }
        });
        rda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    rda.setBackground(getResources().getDrawable(R.drawable.selected_btn));
                    rdb.setBackground(getResources().getDrawable(R.drawable.button));
                    rdc.setBackground(getResources().getDrawable(R.drawable.button));
                    //rdd.setBackground(getResources().getDrawable(R.drawable.button));
                }
                else{
                    rda.setBackgroundColor(getResources().getColor(R.color.optselected));
                    rdb.setBackgroundColor(getResources().getColor(R.color.white_col));
                    rdc.setBackgroundColor(getResources().getColor(R.color.white_col));
                    //rdd.setBackgroundColor(getResources().getColor(R.color.white_col));
                }
                rda.setTextColor(Color.BLACK);
                rdb.setTextColor(getResources().getColor(R.color.bgColor));
                rdc.setTextColor(getResources().getColor(R.color.bgColor));
                //rdd.setTextColor(getResources().getColor(R.color.bgColor));
                //selected=rda.getText().toString();
                selected="1";
            }
        });
        rdb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    rdb.setBackground(getResources().getDrawable(R.drawable.selected_btn));
                    rda.setBackground(getResources().getDrawable(R.drawable.button));
                    rdc.setBackground(getResources().getDrawable(R.drawable.button));
                    //rdd.setBackground(getResources().getDrawable(R.drawable.button));
                }
                else {
                    rdb.setBackgroundColor(getResources().getColor(R.color.optselected));
                    rda.setBackgroundColor(getResources().getColor(R.color.white_col));
                    rdc.setBackgroundColor(getResources().getColor(R.color.white_col));
                    //rdd.setBackgroundColor(getResources().getColor(R.color.white_col));
                }
                rdb.setTextColor(Color.BLACK);
                rda.setTextColor(getResources().getColor(R.color.bgColor));
                //rdd.setTextColor(getResources().getColor(R.color.bgColor));
                rdc.setTextColor(getResources().getColor(R.color.bgColor));
                //selected=rdb.getText().toString();
                selected="2";
            }
        });
        rdc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    rdc.setBackground(getResources().getDrawable(R.drawable.selected_btn));
                    rdb.setBackground(getResources().getDrawable(R.drawable.button));
                    rda.setBackground(getResources().getDrawable(R.drawable.button));
                    //rdd.setBackground(getResources().getDrawable(R.drawable.button));
                }
                else {
                    rdc.setBackgroundColor(getResources().getColor(R.color.optselected));
                    rdb.setBackgroundColor(getResources().getColor(R.color.white_col));
                    rda.setBackgroundColor(getResources().getColor(R.color.white_col));
                    //rdd.setBackgroundColor(getResources().getColor(R.color.white_col));
                }
                rdc.setTextColor(Color.BLACK);
                rda.setTextColor(getResources().getColor(R.color.bgColor));
                rdb.setTextColor(getResources().getColor(R.color.bgColor));
                //rdd.setTextColor(getResources().getColor(R.color.bgColor));
                //selected=rdc.getText().toString();
                selected="3";
            }
        });
        /*rdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    rdd.setBackground(getResources().getDrawable(R.drawable.selected_btn));
                    rdb.setBackground(getResources().getDrawable(R.drawable.button));
                    rdc.setBackground(getResources().getDrawable(R.drawable.button));
                    rda.setBackground(getResources().getDrawable(R.drawable.button));
                }
                else{
                    rdd.setBackgroundColor(getResources().getColor(R.color.optselected));
                    rdb.setBackgroundColor(getResources().getColor(R.color.white_col));
                    rdc.setBackgroundColor(getResources().getColor(R.color.white_col));
                    rda.setBackgroundColor(getResources().getColor(R.color.white_col));
                }
                rdd.setTextColor(Color.BLACK);
                rdb.setTextColor(getResources().getColor(R.color.bgColor));
                rda.setTextColor(getResources().getColor(R.color.bgColor));
                rdc.setTextColor(getResources().getColor(R.color.bgColor));
                //selected=rdd.getText().toString();
                selected="4";
            }
        });*/
        butNext=(Button)findViewById(R.id.button_nxt_p);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCountDownView.cancel();
                nextscreen();
            }

        });
    }
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}*/
	/*private void start(){
		cdt=new CountDownTimer(15 * 1000, 1000) {
			@Override
			public void onTick(long millisUntilFinished) {

			}

			@Override
			public void onFinish() {

			}
		};

	}*/

    @Override
    public void onBackPressed() {
        AlertDialog.Builder abd = new AlertDialog.Builder(psychometric.this);
        abd.setTitle("Exit Quiz Confirmation");
        abd.setIcon(R.mipmap.quiz_exit);
        abd.setMessage("Do you want to exit this Quiz");
        abd.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                mCountDownView.cancel();
                Intent back=new Intent(psychometric.this,Home.class);
                startActivity(back);
                finish();
            }
        });
        abd.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        abd.show();
    }
    /*public void showlogo(){
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setLogo(R.mipmap.ic_launcher);
        getActionBar().setDisplayUseLogoEnabled(true);
    }*/
    public void nextscreen(){
        RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            //rdd.setBackground(getResources().getDrawable(R.drawable.button));
            rdb.setBackground(getResources().getDrawable(R.drawable.button));
            rdc.setBackground(getResources().getDrawable(R.drawable.button));
            rda.setBackground(getResources().getDrawable(R.drawable.button));
        }
        else{
            //rdd.setBackgroundColor(getResources().getColor(R.color.white_col));
            rdb.setBackgroundColor(getResources().getColor(R.color.white_col));
            rdc.setBackgroundColor(getResources().getColor(R.color.white_col));
            rda.setBackgroundColor(getResources().getColor(R.color.white_col));
        }
        //rdd.setTextColor(getResources().getColor(R.color.bgColor));
        rdb.setTextColor(getResources().getColor(R.color.bgColor));
        rda.setTextColor(getResources().getColor(R.color.bgColor));
        rdc.setTextColor(getResources().getColor(R.color.bgColor));
        //RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
        //Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
        switch (Integer.valueOf(selected)){
            case 1:
                score=score+2;
                break;
            case 2:
                score++;
                break;
            case 3:
                break;
        }
        if(qid<24){
            setQuestionView();
        }else{
            Intent intent = new Intent(psychometric.this, Psyresult.class);
            Bundle b = new Bundle();
            b.putInt("score",score);
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }
        selected="0";
    }

    private void setQuestionView()
    {   txtQuestion.setText(quesList.get(qid));
        //rdd.setText(currentQ.getOPTD());
        qid++;
        mCountDownView.setTimer(30000);
        mCountDownView.start();
    }

}
