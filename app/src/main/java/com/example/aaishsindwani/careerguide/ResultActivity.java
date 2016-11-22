package com.example.aaishsindwani.careerguide;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.RatingBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.mikepenz.materialize.color.Material;

import java.util.ArrayList;

public class ResultActivity extends Activity {
	int med_score=0,arts_scrore=0,engg_score=0,comm_score=0;
	float medp,artp,engp,comp;
	private String[] xdata={"Engineering","Medical","Commerce","Arts"};
	private float[] ydata;
	PieChart pieChart;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
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
		float sum=engg_score+med_score+comm_score+arts_scrore;
		engp=engg_score*100/sum;
		medp=med_score*100/sum;
		comp=comm_score*100/sum;
		artp=arts_scrore*100/sum;
		ydata= new float[]{engg_score,med_score,comm_score,arts_scrore};
		//display score
		pieChart=(PieChart)findViewById(R.id.firstchart);
		t.setText("medical= "+med_score+" engg= "+engg_score+" comm= "+comm_score+" arts= "+arts_scrore);
		pieChart.setRotationEnabled(true);
		pieChart.setHoleRadius(25f);
		pieChart.setDrawSliceText(true);
		pieChart.setTransparentCircleAlpha(0);
		pieChart.setHoleColor(Color.WHITE);
		pieChart.setCenterText("Branch Prediction");
		pieChart.setCenterTextSize(20);
		pieChart.setCenterTextColor(getResources().getColor(R.color.bgColor));
		pieChart.setCenterTextSize(12);
		pieChart.setEntryLabelTextSize(20);
		pieChart.setEntryLabelColor(Color.WHITE);
		pieChart.setUsePercentValues(true);
		pieChart.animateY(5000);
		addDataSet();
		/*pieChart.setOnChartValueSelectedListener(new OnChartValueSelectedListener() {
			@Override
			public void onValueSelected(Entry e, Highlight h) {

			}

			@Override
			public void onNothingSelected() {

			}
		});*/
	}

	private void addDataSet() {
		ArrayList<PieEntry> yEntrys=new ArrayList<>();
		ArrayList<String> xEntrys=new ArrayList<>();
		for(int i=0;i<ydata.length;i++){
			yEntrys.add(new PieEntry(ydata[i],xdata[i]));

		}
		for(int i=0;i<xdata.length;i++){
			xEntrys.add(xdata[i]);

		}

		PieDataSet piedataset=new PieDataSet(yEntrys,"Branch");
		piedataset.setSliceSpace(5);
		piedataset.setValueTextSize(30);
		piedataset.setValueTextColor(Color.WHITE);
		piedataset.setDrawValues(true);

		ArrayList<Integer> colors=new ArrayList<>();
		colors.add(getResources().getColor(R.color.regbg));
		colors.add(getResources().getColor(R.color.verifybg));
		colors.add(getResources().getColor(R.color.optselected));
		colors.add(getResources().getColor(R.color.bgColor));

		piedataset.setColors(colors);

/*		Legend legend=pieChart.getLegend();
		legend.setForm(Legend.LegendForm.CIRCLE);
		legend.setPosition(Legend.LegendPosition.LEFT_OF_CHART);*/

		PieData piedata=new PieData(piedataset);
		pieChart.setData(piedata);
		pieChart.invalidate();

	}

	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_result, menu);
		return true;
	}*/
}
