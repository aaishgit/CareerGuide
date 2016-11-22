package com.example.aaishsindwani.careerguide;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

/**
 * Created by aaishsindwani on 22/11/16.
 */
public class Details_fragment extends Fragment implements View.OnClickListener {
    ImageView detail_img;
    Button submit;
    EditText name;
    //TextView branch;
    TextView year;
    Context context;
    //TextView program;
    String[] opt;
    String name_str, year_str, uid;
    //String branch_str, program_str;
    FirebaseAuth currauth;
    FirebaseUser curruser;
    FirebaseDatabase userDb;
    DatabaseReference useRef;
    Fielddetails fielddetails;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View detailsview = inflater.inflate(R.layout.details_fragment, container, false);
        context = this.getActivity().getApplicationContext();
        detail_img = (ImageView)detailsview.findViewById(R.id.imageView_frag_det);
        detail_img.setImageResource(R.mipmap.details_new);
        name = (EditText) detailsview.findViewById(R.id.editText_frag_name);
        //program = (TextView) findViewById(R.id.editText6);
        //branch = (TextView) findViewById(R.id.editText7);
        year = (TextView) detailsview.findViewById(R.id.textview_frag_class);
        submit = (Button) detailsview.findViewById(R.id.button9_frag);
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
        userDb = FirebaseDatabase.getInstance();
        useRef = userDb.getReference("users").child(uid).child("details");
        useRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                fielddetails = dataSnapshot.getValue(Fielddetails.class);
                name.setText(fielddetails.getName());
                year.setText(fielddetails.getYear());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show();
            }
        });
        return detailsview;
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
            case R.id.textview_frag_class:
                final AlertDialog.Builder ad = new AlertDialog.Builder(getContext());
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
            case R.id.button9_frag:
                name_str = name.getText().toString();
                if (TextUtils.isEmpty(year_str) || /*TextUtils.isEmpty(branch_str) || TextUtils.isEmpty(program_str) ||*/ TextUtils.isEmpty(name_str)) {
                    Toast.makeText(context, "Enter all details", Toast.LENGTH_SHORT).show();
                } else {
                    fielddetails.setName(name_str);
                    //fielddetails.setDept(branch_str);
                    fielddetails.setYear(year_str);
                    //fielddetails.setType(program_str);
                    userDb = FirebaseDatabase.getInstance();
                    useRef = userDb.getReference("users").child(uid);
                    DatabaseReference setdetails = useRef.child("details");
                    setdetails.setValue(fielddetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(context, "Error:Check your internet connection or Restart the app", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(context, "Details updated", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
        }
    }
}
