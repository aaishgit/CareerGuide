package com.example.aaishsindwani.careerguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class marks extends AppCompatActivity implements View.OnClickListener {
    TextView maths,science,sst,eng,hindi;
    Button submit;
    ImageView marks_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);
        maths=(TextView)findViewById(R.id.textview_maths_marks);
        science=(TextView)findViewById(R.id.textview_maths_science);
        sst=(TextView)findViewById(R.id.textview_maths_sst);
        eng=(TextView)findViewById(R.id.textview_english_marks);
        hindi=(TextView)findViewById(R.id.textview_hindi_marks);
        submit=(Button)findViewById(R.id.button9_marks);
        submit.setOnClickListener(this);
        marks_back=(ImageView)findViewById(R.id.imageView_marks);
        marks_back.setImageResource(R.mipmap.marks_back);
        maths.setOnClickListener(this);
        science.setOnClickListener(this);
        sst.setOnClickListener(this);
        eng.setOnClickListener(this);
        hindi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
