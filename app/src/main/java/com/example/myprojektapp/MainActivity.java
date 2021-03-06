package com.example.myprojektapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ArrayAdapter<Disc> discadapter;
    public static final String EXTRA_MESSAGE = "com.example.myprojektapp.extra.MESSAGE";
    public static final String EXTRA_MESSAGE1 = "com.example.myprojektapp.extra.MESSAGE1";
    public static final String EXTRA_MESSAGE2 = "com.example.myprojektapp.extra.MESSAGE2";
    public static final String EXTRA_MESSAGE3 = "com.example.myprojektapp.extra.MESSAGE3";
    public static final String EXTRA_MESSAGE4 = "com.example.myprojektapp.extra.MESSAGE4";
    public static final String EXTRA_MESSAGE5 = "com.example.myprojektapp.extra.MESSAGE5";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        new FetchData().execute();

        discadapter=new ArrayAdapter<Disc>(this,R.layout.listtext_view,R.id.my_textview);
        ListView myListView = (ListView)findViewById(R.id.my_listview);
        myListView.setAdapter(discadapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String discname = discadapter.getItem(position).toString();
                String stable= discadapter.getItem(position).getStable();
                String price= discadapter.getItem(position).getCost();
                String company= discadapter.getItem(position).getCompany();
                String type= discadapter.getItem(position).getType();
                String value=discadapter.getItem(position).getValue();
                message(view, discname, stable, price, company, type, value);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.Uppdateraknapp) {
            discadapter.clear();
            new FetchData().execute();

            return true;
        }
        if (id == R.id.infoknapp) {
            Intent intent = new Intent(getApplicationContext(), OmActivity.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class FetchData extends AsyncTask<Void,Void,String> {



        @Override
        protected String doInBackground(Void... params) {
            // These two variables need to be declared outside the try/catch
            // so that they can be closed in the finally block.
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            // Will contain the raw JSON response as a Java string.
            String jsonStr = null;

            try {
                // Construct the URL for the Internet service
                URL url = new URL("http://wwwlab.iit.his.se/brom/kurser/mobilprog/dbservice/admin/getdataasjson.php?type=a18jakme");

                // Create the request to the PHP-service, and open the connection
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // Read the input stream into a String
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null) {
                    // Nothing to do.
                    return null;
                }
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                    // But it does make debugging a *lot* easier if you print out the completed
                    // buffer for debugging.
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) {
                    // Stream was empty.  No point in parsing.
                    return null;
                }
                jsonStr = buffer.toString();
                return jsonStr;
            } catch (IOException e) {
                Log.e("PlaceholderFragment", "Error ", e);
                // If the code didn't successfully get the weather data, there's no point in
                // attempting to parse it.
                return null;
            } finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e("Network error", "Error closing stream", e);
                    }
                }
            }
        }
        @Override
        protected void onPostExecute(String o) {

            super.onPostExecute(o);
            Log.d("jacke","DataFetched:"+o);

            try {

                JSONArray json1 = new JSONArray(o);
                for (int i = 0; i < json1.length(); i++){
                    JSONObject a = json1.getJSONObject(i);
                    Disc n = new Disc(a.getString("name")+ ": " + a.getString("category") + "");
                    n.setStable(a.getString("location"));
                    n.setCost(a.getInt("cost"));
                    n.setCompany(a.getString("company"));
                    n.setType(a.getString("category"));
                    n.setValue(a.getString("auxdata"));
                    discadapter.add(n);


                }

            } catch (JSONException e) {
                Log.e("kalas","E:"+e.getMessage());
            }
            try {

                JSONArray json1 = new JSONArray(o);
                for (int i = 0; i < json1.length(); i++){
                    JSONObject a = json1.getJSONObject(i);
                    Disc n = new Disc(a.getString("name")+ ": " + a.getString("category") + "");
                    n.setStable(a.getString("location"));
                    n.setCost(a.getInt("cost"));
                    n.setCompany(a.getString("company"));
                    n.setType(a.getString("category"));
                    n.setValue(a.getString("auxdata"));
                    discadapter.add(n);


                }

            } catch (JSONException e) {
                Log.e("kalas","E:"+e.getMessage());
            }
        }

    }
    public void message (View view, String discname, String stable, String price, String company, String type, String value){
        Intent iNtent = new Intent(getApplicationContext(), ActivityDetail.class);
        iNtent.putExtra(EXTRA_MESSAGE, discname);
        iNtent.putExtra(EXTRA_MESSAGE1, stable);
        iNtent.putExtra(EXTRA_MESSAGE2, price);
        iNtent.putExtra(EXTRA_MESSAGE3, company);
        iNtent.putExtra(EXTRA_MESSAGE4, type);
        iNtent.putExtra(EXTRA_MESSAGE5, value);
        startActivity(iNtent);
    }
}
