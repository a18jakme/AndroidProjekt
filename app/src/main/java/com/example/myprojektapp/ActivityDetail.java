package com.example.myprojektapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ActivityDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        String discnamn = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String stabil = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String pris = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);

        Log.d("jacke", discnamn);
        Log.d("jacke", stabil);
        Log.d("jacke", pris);
    }
}
