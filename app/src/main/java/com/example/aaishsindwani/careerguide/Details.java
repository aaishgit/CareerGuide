package com.example.aaishsindwani.careerguide;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bhargavms.dotloader.DotLoader;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Details extends AppCompatActivity implements View.OnClickListener {
    ImageView detail_img;
    Button submit;
    EditText name;
    //TextView branch;
    TextView year;
    //TextView program;
    String[] opt;
    String name_str, year_str, uid;
    //String branch_str, program_str;
    AlertDialog.Builder ad;
    FirebaseAuth currauth;
    FirebaseUser curruser;
    Fielddetails fielddetails;
    DotLoader dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e("Activity: ","details");
        setContentView(R.layout.activity_details);
        detail_img = (ImageView)findViewById(R.id.imageView_det);
        detail_img.setImageResource(R.mipmap.details2);
        name = (EditText) findViewById(R.id.editText_name);
        dots=(DotLoader)findViewById(R.id.text_dot_loader_det);
        dots.setVisibility(View.INVISIBLE);
        //program = (TextView) findViewById(R.id.editText6);
        //branch = (TextView) findViewById(R.id.editText7);
        year = (TextView) findViewById(R.id.textview_class);
        submit = (Button) findViewById(R.id.button9);
        submit.setOnClickListener(this);
        //year.setVisibility(View.INVISIBLE);
        year.setOnClickListener(this);
        //branch.setOnClickListener(this);
        //program.setOnClickListener(this);
        year.setEnabled(true);
        year.setVisibility(View.VISIBLE);
        currauth = FirebaseAuth.getInstance();
        curruser = currauth.getCurrentUser();
        uid = curruser.getUid().toString();
        fielddetails = new Fielddetails();
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "Not allowed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            /*case R.id.editText6:
                ad = new AlertDialog.Builder(this);
                ad.setTitle("Select Type");
                ad.setIcon(R.mipmap.program);
                opt = new String[]{"Student", "Teacher"};
                ad.setItems(opt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        program_str = opt[i];
                        program.setText(program_str);
                        if (program_str == opt[0]) {
                            year.setVisibility(View.VISIBLE);
                        } else {
                            year.setVisibility(View.INVISIBLE);
                            year_str = "0";
                        }
                    }
                });
                ad.show();
                break;
            case R.id.editText7:
                ad = new AlertDialog.Builder(this);
                ad.setTitle("Select Department");
                ad.setIcon(R.mipmap.branch);
                opt = new String[]{"Computer Science", "Chemical", "Civil", "Biotechnology", "Electronics and Comm.",
                        "Electrical and Instrumentation", "Mechanical"};
                ad.setItems(opt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        branch_str = opt[i];
                        branch.setText(branch_str);
                    }
                });
                ad.show();
                break;*/
            case R.id.textview_class:
                ad = new AlertDialog.Builder(this);
                ad.setTitle("Select Class");
                ad.setIcon(R.mipmap.calendar2);
                opt = new String[]{"8", "9", "10", "11"};
                ad.setItems(opt, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        year_str = opt[i];
                        year.setText(year_str);
                    }
                });
                ad.show();
                break;
            case R.id.button9:
                dots.setVisibility(View.VISIBLE);
                name_str = name.getText().toString();
                if (TextUtils.isEmpty(year_str) || /*TextUtils.isEmpty(branch_str) || TextUtils.isEmpty(program_str) ||*/ TextUtils.isEmpty(name_str)) {
                    Toast.makeText(this, "Enter all details", Toast.LENGTH_SHORT).show();
                    dots.setVisibility(View.INVISIBLE);
                } else {
                    fielddetails.setName(name_str);
                    //fielddetails.setDept(branch_str);
                    fielddetails.setYear(year_str);
                    //fielddetails.setType(program_str);
                    FirebaseDatabase userRef = FirebaseDatabase.getInstance();
                    final DatabaseReference userDb = userRef.getReference("users").child(uid);
                    DatabaseReference setdetails = userDb.child("details");
                    setdetails.setValue(fielddetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(Details.this, "Error:Check your internet connection or Restart the app", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Details.this, "Details updated", Toast.LENGTH_SHORT).show();
                                DatabaseReference isdetails = userDb.child("check_details");
                                isdetails.setValue(true).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (!task.isSuccessful()) {
                                            Toast.makeText(Details.this, "Error:Check your internet connection or Restart the app", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Intent home1 = new Intent(Details.this, Home.class);
                                            startActivity(home1);
                                            dots.setVisibility(View.INVISIBLE);
                                            finish();
                                        }
                                    }
                                });
                            }
                        }
                    });
                }
        }
    }
}
