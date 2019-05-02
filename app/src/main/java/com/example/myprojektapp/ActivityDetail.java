package com.example.myprojektapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

public class ActivityDetail extends AppCompatActivity {

    public ArrayAdapter<Disc> detailadapter;
    public Array discarray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();

        String discnamn = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String stabil = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String pris = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        String tillverkare = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String typ = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);



        Disc d=new Disc(discnamn);

        detailadapter.add(d);

        Log.d("jacke", discnamn);
        Log.d("jacke", stabil);
        Log.d("jacke", pris);

        detailadapter=new ArrayAdapter<Disc>(this,R.layout.listtext_view,R.id.detail_listview);
        ListView myListView = (ListView)findViewById(R.id.detail_listview);
        myListView.setAdapter(detailadapter);
    }
}
