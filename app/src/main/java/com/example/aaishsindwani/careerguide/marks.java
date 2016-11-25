package com.example.aaishsindwani.careerguide;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class marks extends AppCompatActivity implements View.OnClickListener {
    TextView maths, science, sst, eng;
    int mathopt=10,sciopt=10,engopt=10,sstopt=10;
    Button submit;
    marks_pojo mymarks=new marks_pojo();
    ImageView marks_back;
    FirebaseAuth myauth;
    FirebaseUser myuser;
    Bundle b2;
    String uid;
    FirebaseDatabase mydatabase;
    DatabaseReference dataref;
    int where2;
    int med_score, comm_score, arts_scrore, engg_score;
    String opt[]={"Above 90%","Between 75% to 89%","Between 60% to 74%","Between 50% to 59%","Between 33% to 49%","Below 33%"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marks);
        maths = (TextView) findViewById(R.id.textview_maths_marks);
        science = (TextView) findViewById(R.id.textview_maths_science);
        sst = (TextView) findViewById(R.id.textview_maths_sst);
        eng = (TextView) findViewById(R.id.textview_english_marks);
        //hindi = (TextView) findViewById(R.id.textview_hindi_marks);
        submit = (Button) findViewById(R.id.button9_marks);
        submit.setOnClickListener(this);
        marks_back = (ImageView) findViewById(R.id.imageView_marks);
        marks_back.setImageResource(R.mipmap.marks_back);
        maths.setOnClickListener(this);
        science.setOnClickListener(this);
        sst.setOnClickListener(this);
        eng.setOnClickListener(this);
        //hindi.setOnClickListener(this);
        b2 = getIntent().getExtras();
        where2 = b2.getInt("where2");
        myauth = FirebaseAuth.getInstance();
        myuser = myauth.getCurrentUser();
        uid = myuser.getUid().toString();
        mydatabase = FirebaseDatabase.getInstance();
        dataref = mydatabase.getReference("users").child(uid).child("marks_set");
        dataref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean val = dataSnapshot.getValue(boolean.class);
                if (val == true) {
                    DatabaseReference oldmarks=mydatabase.getReference("users").child(uid).child("marks");
                    oldmarks.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            marks_pojo old=new marks_pojo();
                            old=dataSnapshot.getValue(marks_pojo.class);
                            mathopt=old.getMath();
                            sciopt=old.getSci();
                            engopt=old.getEng();
                            sstopt=old.getSst();
                            maths.setText(opt[mathopt]);
                            science.setText(opt[sciopt]);
                            sst.setText(opt[sstopt]);
                            eng.setText(opt[engopt]);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(marks.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else {

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(marks.this,"Error in reading data",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder ald = new AlertDialog.Builder(marks.this);
        switch (v.getId()){
            case R.id.textview_maths_marks:
                ald.setTitle("Select your marks in MATHS");
                ald.setIcon(R.mipmap.maths_logo);
                ald.setItems(opt, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    mathopt=i;
                    maths.setText(opt[mathopt]);
                }
            });
                ald.show();
                break;
            case R.id.textview_maths_science:
                ald.setTitle("Select your marks in SCIENCE");
                ald.setIcon(R.mipmap.science_logo);
                ald.setItems(opt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sciopt=i;
                        science.setText(opt[sciopt]);
                    }
                });
                ald.show();
                break;
            case R.id.textview_english_marks:
                ald.setTitle("Select your marks in ENGLISH");
                ald.setIcon(R.mipmap.english_logo);
                ald.setItems(opt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        engopt=i;
                        eng.setText(opt[engopt]);
                    }
                });
                ald.show();
                break;
            /*case R.id.textview_hindi_marks:
                break;*/
            case R.id.textview_maths_sst:
                ald.setTitle("Select your marks in SOCIAL SCIENCE");
                ald.setIcon(R.mipmap.sst2);
                ald.setItems(opt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        sstopt=i;
                        sst.setText(opt[sstopt]);
                    }
                });
                ald.show();
                break;
            case R.id.button9_marks:
                if((mathopt==10)||(sciopt==10)||(sstopt==10)||(engopt==10)){
                    Toast.makeText(this,"Enter all data",Toast.LENGTH_SHORT).show();
                }
                else{
                    mymarks.setEng(engopt);
                    mymarks.setMath(mathopt);
                    mymarks.setSci(sciopt);
                    mymarks.setSst(sstopt);
                    DatabaseReference mymarksref=mydatabase.getReference("users").child(uid).child("marks");
                    mymarksref.setValue(mymarks).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(marks.this,"Error in uploading marks",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                dataref.setValue(true).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if(!task.isSuccessful()){
                                            Toast.makeText(marks.this,"Error in updating marks_set",Toast.LENGTH_SHORT).show();
                                        }
                                        else {
                                            if (where2 == 3) {
                                                med_score = b2.getInt("medi_score", 0);
                                                arts_scrore = b2.getInt("arts_score", 0);
                                                comm_score = b2.getInt("comm_score", 0);
                                                engg_score = b2.getInt("engg_score", 0);
                                                med_score=med_score*4;
                                                arts_scrore=arts_scrore*4;
                                                engg_score=engg_score*4;
                                                comm_score=comm_score*4;
                                                switch (sciopt){
                                                    case 0:
                                                        med_score=med_score+10;
                                                        engg_score=engg_score+4;
                                                        break;
                                                    case 1:
                                                        med_score=med_score+8;
                                                        engg_score=engg_score+3;
                                                        break;
                                                    case 2:
                                                        med_score=med_score+6;
                                                        engg_score=engg_score+2;
                                                        break;
                                                    case 3:
                                                        med_score=med_score+5;
                                                        engg_score=engg_score+1;
                                                        break;
                                                    case 4:
                                                        med_score=med_score+3;
                                                        engg_score=engg_score+1;
                                                        break;
                                                    case 5:
                                                        med_score=med_score+1;
                                                        engg_score=engg_score+0;
                                                        break;
                                                }
                                                switch (mathopt){
                                                    case 0:
                                                        engg_score=engg_score+6;
                                                        comm_score=comm_score+7;
                                                        break;
                                                    case 1:
                                                        engg_score=engg_score+5;
                                                        comm_score=comm_score+6;
                                                        break;
                                                    case 2:
                                                        engg_score=engg_score+4;
                                                        comm_score=comm_score+5;
                                                        break;
                                                    case 3:
                                                        engg_score=engg_score+3;
                                                        comm_score=comm_score+4;
                                                        break;
                                                    case 4:
                                                        engg_score=engg_score+2;
                                                        comm_score=comm_score+2;
                                                        break;
                                                    case 5:
                                                        engg_score=engg_score+1;
                                                        comm_score=comm_score+1;
                                                        break;
                                                }
                                                switch (sstopt){
                                                    case 0:
                                                        arts_scrore=arts_scrore+7;
                                                        comm_score=comm_score+3;
                                                        break;
                                                    case 1:
                                                        arts_scrore=arts_scrore+6;
                                                        comm_score=comm_score+2;
                                                        break;
                                                    case 2:
                                                        arts_scrore=arts_scrore+5;
                                                        comm_score=comm_score+2;
                                                        break;
                                                    case 3:
                                                        arts_scrore=arts_scrore+4;
                                                        comm_score=comm_score+2;
                                                        break;
                                                    case 4:
                                                        arts_scrore=arts_scrore+3;
                                                        comm_score=comm_score+1;
                                                        break;
                                                    case 5:
                                                        arts_scrore=arts_scrore+1;
                                                        comm_score=comm_score+0;
                                                        break;
                                                }
                                                switch (engopt){
                                                    case 0:
                                                        arts_scrore=arts_scrore+3;
                                                        break;
                                                    case 1:
                                                        arts_scrore=arts_scrore+3;
                                                        break;
                                                    case 2:
                                                        arts_scrore=arts_scrore+2;
                                                        break;
                                                    case 3:
                                                        arts_scrore=arts_scrore+2;
                                                        break;
                                                    case 4:
                                                        arts_scrore=arts_scrore+1;
                                                        break;
                                                    case 5:
                                                        arts_scrore=arts_scrore+0;
                                                        break;
                                                }
                                                Bundle toresult=new Bundle();
                                                toresult.putInt("engg_score", engg_score);
                                                toresult.putInt("medi_score", med_score);
                                                toresult.putInt("comm_score", comm_score);
                                                toresult.putInt("arts_score", arts_scrore);
                                                Intent next=new Intent(marks.this,ResultActivity.class);
                                                next.putExtras(toresult);
                                                startActivity(next);
                                            }
                                            else if (where2 == 4) {
                                                finish();
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(marks.this,"Not Allowed",Toast.LENGTH_SHORT).show();
    }
}