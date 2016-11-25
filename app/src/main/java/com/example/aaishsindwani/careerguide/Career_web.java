package com.example.aaishsindwani.careerguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Career_web extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_career_web);
        WebView webView=new WebView(this);
        setContentView(webView);
        webView.loadUrl("http://www.studymads.com/what-stream-to-choose-after-10th-class/");
    }
}
