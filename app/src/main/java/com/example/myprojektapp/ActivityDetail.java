package com.example.myprojektapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ActivityDetail extends AppCompatActivity {

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
        Log.d("jacke", discnamn);
        Log.d("jacke", stabil);
        Log.d("jacke", pris);
        Log.d("jacke", tillverkare);
        Log.d("jacke", typ);

        TextView dname =findViewById(R.id.DiscView);
        dname.setText(discnamn);
        TextView dprice =findViewById(R.id.PriceView);
        dprice.setText("Pris: "+pris+"kr");
        TextView dtyp =findViewById(R.id.typeview);
        dtyp.setText("Typ av disc: "+typ);
        TextView dcompany =findViewById(R.id.companyview);
        dcompany.setText("Företag:" +tillverkare);
        TextView dstable =findViewById(R.id.stableview);
        dstable.setText("Stabilitet: "+stabil);

        ImageView bild1=findViewById(R.id. bild);


        if(typ.equals("Putt")) {
            bild1.setImageResource(R.drawable.pinkgerb);

        }
        else if(typ.equals("Distance Driver")) {
            bild1.setImageResource(R.drawable.pinkgerb);

        }



    }
}
