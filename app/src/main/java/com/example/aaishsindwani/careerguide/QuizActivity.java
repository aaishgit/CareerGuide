package com.example.aaishsindwani.careerguide;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.List;

public class QuizActivity extends Activity {
	List<Question> quesList;
	int score=0;
	int qid=0;
	Question currentQ;
	TextView txtQuestion;
	Button rda, rdb, rdc, rdd;
	Button butNext;
	String selected;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		//setTitle("Academic Quiz");
		DbHelper db=new DbHelper(this);
		quesList=db.getAllQuestions();
		currentQ=quesList.get(qid);
		txtQuestion=(TextView)findViewById(R.id.textView1);
		rda=(Button)findViewById(R.id.radio0);
		rdb=(Button)findViewById(R.id.radio1);
		rdc=(Button)findViewById(R.id.radio2);
		rdd=(Button)findViewById(R.id.radio3);
		rda.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rda.setBackgroundColor(getResources().getColor(R.color.regbg));
				rdb.setBackgroundColor(getResources().getColor(R.color.white_col));
				rdc.setBackgroundColor(getResources().getColor(R.color.white_col));
				rdd.setBackgroundColor(getResources().getColor(R.color.white_col));
				rda.setTextColor(Color.WHITE);
				rdb.setTextColor(getResources().getColor(R.color.bgColor));
				rdc.setTextColor(getResources().getColor(R.color.bgColor));
				rdd.setTextColor(getResources().getColor(R.color.bgColor));
				//selected=rda.getText().toString();
				selected="1";
			}
		});
		rdb.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rdb.setBackgroundColor(getResources().getColor(R.color.regbg));
				rda.setBackgroundColor(getResources().getColor(R.color.white_col));
				rdc.setBackgroundColor(getResources().getColor(R.color.white_col));
				rdd.setBackgroundColor(getResources().getColor(R.color.white_col));
				rdb.setTextColor(Color.WHITE);
				rda.setTextColor(getResources().getColor(R.color.bgColor));
				rdd.setTextColor(getResources().getColor(R.color.bgColor));
				rdc.setTextColor(getResources().getColor(R.color.bgColor));
				//selected=rdb.getText().toString();
				selected="2";
			}
		});
		rdc.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rdc.setBackgroundColor(getResources().getColor(R.color.regbg));
				rdb.setBackgroundColor(getResources().getColor(R.color.white_col));
				rda.setBackgroundColor(getResources().getColor(R.color.white_col));
				rdd.setBackgroundColor(getResources().getColor(R.color.white_col));
				rdc.setTextColor(Color.WHITE);
				rda.setTextColor(getResources().getColor(R.color.bgColor));
				rdb.setTextColor(getResources().getColor(R.color.bgColor));
				rdd.setTextColor(getResources().getColor(R.color.bgColor));
				//selected=rdc.getText().toString();
				selected="3";
			}
		});
		rdd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rdd.setBackgroundColor(getResources().getColor(R.color.regbg));
				rdb.setBackgroundColor(getResources().getColor(R.color.white_col));
				rdc.setBackgroundColor(getResources().getColor(R.color.white_col));
				rda.setBackgroundColor(getResources().getColor(R.color.white_col));
				rdd.setTextColor(Color.WHITE);
				rdb.setTextColor(getResources().getColor(R.color.bgColor));
				rda.setTextColor(getResources().getColor(R.color.bgColor));
				rdc.setTextColor(getResources().getColor(R.color.bgColor));
				//selected=rdd.getText().toString();
				selected="4";
			}
		});
		butNext=(Button)findViewById(R.id.button_nxt);
		setQuestionView();
		butNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
				//RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
				//Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
				if(currentQ.getANSWER().equals(selected))
				{
					score++;
					Log.d("score", "Your score"+score);
				}
				if(qid<5){					
					currentQ=quesList.get(qid);
					setQuestionView();
				}else{
					Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
					Bundle b = new Bundle();
					b.putInt("score", score); //Your score
					intent.putExtras(b); //Put your score to your next Intent
					startActivity(intent);
					finish();
				}
			}
		});
	}
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_quiz, menu);
		return true;
	}*/
	private void setQuestionView()
	{
		txtQuestion.setText(currentQ.getQUESTION());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		rdd.setText(currentQ.getOPTD());
		qid++;
	}

	/*public void showlogo(){
		getActionBar().setDisplayShowHomeEnabled(true);
		getActionBar().setLogo(R.mipmap.ic_launcher);
		getActionBar().setDisplayUseLogoEnabled(true);
	}*/
}
