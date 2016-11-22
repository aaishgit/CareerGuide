package com.example.aaishsindwani.careerguide;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity {
	int med_score=0,arts_scrore=0,engg_score=0,comm_score=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		//get rating bar object
		RatingBar bar=(RatingBar)findViewById(R.id.ratingBar1);
		bar.setNumStars(5);
		bar.setStepSize(0.5f);
		//get text view
		TextView t=(TextView)findViewById(R.id.textResult);
		//get score
		Bundle b = getIntent().getExtras();
		med_score=b.getInt("medi_score",0);
		arts_scrore=b.getInt("arts_score",0);
		comm_score=b.getInt("comm_score",0);
		engg_score=b.getInt("engg_score",0);
		Log.e("engg",String.valueOf(engg_score));
		Log.e("medi",String.valueOf(med_score));
		Log.e("comm",String.valueOf(comm_score));
		Log.e("arts",String.valueOf(arts_scrore));

		//display score
		bar.setRating(med_score);
		t.setText("medical= "+med_score+" engg= "+engg_score+" comm= "+comm_score+" arts= "+arts_scrore);
	}
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}*/
}
