package com.halcyonmobile.techinterview.src.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.halcyonmobile.techinterview.R;

public class CongratulationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_congratulations );
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
    }
}
