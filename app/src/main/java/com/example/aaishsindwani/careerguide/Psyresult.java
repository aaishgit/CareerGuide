package com.example.aaishsindwani.careerguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hanks.htextview.HTextView;
import com.hanks.htextview.HTextViewType;

public class Psyresult extends AppCompatActivity {
    int score;
    TextView stdata;
    HTextView head;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psyresult);
        Bundle b = getIntent().getExtras();
        score=b.getInt("score",0);
        head=(HTextView) findViewById(R.id.text_animate_psy);
        head.setAnimateType(HTextViewType.LINE);
        stdata=(TextView)findViewById(R.id.data);
        if ((score>=0)&&(score<8)){
            head.animateText("Analytical Occupations");
            stdata.setText("These include Detective, Technical Writer" +
                    ", Banking, Insurance, Accounts, Charted Accountant, Company Secretary, Foreign Languages Teacher, Stock Broker etc.");
        }
        else if ((score>=8)&&(score<16)){
            head.animateText("Pragmatic Occupations");
            stdata.setText("These include  Veterinary Surgeons, Fire Fighters, Audio and Video Technicians, Farm Workers, Journalist," +
                    " Agriculture Technician, Archaeologist, Anthropologist, Criminologist, Lawyer," +
                    " Dairy Farmers, Poultry Farmers, Horticulturist etc.");
        }
        else if ((score>=16)&&(score<24)){
            head.animateText("Social Occupations");
            stdata.setText("These include Social Workers, Teachers, Nurses, Therapists, Psychiatrist, Psycgologist etc");
        }
        else if ((score>=24)&&(score<32)){
            head.animateText("Artistic Occupations");
            stdata.setText("These include Painters, Singer, Musician, Actor, Dancer, Fashion Designer, Photographer, " +
                    "Modeling, Theatre, Jewelery Designer, Interior Decorator, Beautician etc.");
        }
        else if ((score>=32)&&(score<40)){
            head.animateText("Enterprising Occupations");
            stdata.setText("These include Entrepreneurs, Lawyers, CEO, Public Relation Office, Program Directors, " +
                    "Chef, Hospitality and Retail Managers, Vastu and Feng Shui Expert etc.");
        }
        else if ((score>=40)&&(score<49)){
            head.animateText("Conventional Occupations");
            stdata.setText("These include Doctor, Lecturer, Engineer, Scientist, Armed Forces, and IAS/IES/IPS, " +
                    "Charted Accountant, Company Secretary, Lawyers etc.");
        }
    }
}
