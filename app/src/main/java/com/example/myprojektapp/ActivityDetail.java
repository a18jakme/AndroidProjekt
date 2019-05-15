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

        String discname = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String stable = intent.getStringExtra(MainActivity.EXTRA_MESSAGE1);
        String price = intent.getStringExtra(MainActivity.EXTRA_MESSAGE2);
        String company = intent.getStringExtra(MainActivity.EXTRA_MESSAGE3);
        String type = intent.getStringExtra(MainActivity.EXTRA_MESSAGE4);
        Log.d("jacke", discname);
        Log.d("jacke", stable);
        Log.d("jacke", price);
        Log.d("jacke", company);
        Log.d("jacke", type);

        TextView dname =findViewById(R.id.DiscView);
        dname.setText(discname);
        TextView dprice =findViewById(R.id.PriceView);
        dprice.setText("Pris: "+price+"kr");
        TextView dtyp =findViewById(R.id.typeview);
        dtyp.setText("Typ av disc: "+type);
        TextView dcompany =findViewById(R.id.companyview);
        dcompany.setText("Företag:" +company);
        TextView dstable =findViewById(R.id.stableview);
        dstable.setText("Stabilitet: "+stable);

        ImageView bild1=findViewById(R.id. bild);


        if(type.equals("Putt")) {
            bild1.setImageResource(R.drawable.pinkgerb);

        }
        else if(type.equals("Distance Driver")) {
            bild1.setImageResource(R.drawable.pinkgerb);

        }



    }
}
