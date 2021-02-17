package com.example.covid19tracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    // Create the object of TextView Class
    TextView tvCases;
    TextView tvRecovered;
    TextView tvCritical;
    TextView tvActive;
    TextView tvTodayCases;
    TextView tvTotalDeaths;
    TextView tvTodayDeaths;
    TextView tvAffectedCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the object by id from the xml
        tvCases = findViewById(R.id.tvCases);
        tvRecovered = findViewById(R.id.tvRecovered);
        tvCritical = findViewById(R.id.tvCritical);
        tvActive = findViewById(R.id.tvActive);
        tvTodayCases = findViewById(R.id.tvTodayCases);
        tvTotalDeaths = findViewById(R.id.tvTotalDeaths);
        tvTodayDeaths = findViewById(R.id.tvTodayDeaths);
        tvAffectedCountries = findViewById(R.id.tvAffectedCountries);
        // Creating a method fetchdata()
        fetchdata();
    }

    //Get the data from 3rd party services
    private void fetchdata()
    {
        //Refer to url of 3rd party services JSON data
        String url = "https://corona.lmao.ninja/v2/all";

        StringRequest request
                = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse( String response)
                    {
        // Handle the JSON object and handle it inside try and catch

                        try {
                            // Creating object of JSONObject
                            JSONObject jsonObject
                                    = new JSONObject(
                                    response.toString());

                            tvCases.setText(
                                    jsonObject.getString("cases"));
                            tvRecovered.setText(
                                    jsonObject.getString("recovered"));
                            tvCritical.setText(
                                    jsonObject.getString("critical"));
                            tvActive.setText(
                                    jsonObject.getString("active"));
                            tvTodayCases.setText(
                                    jsonObject.getString("todayCases"));
                            tvTotalDeaths.setText(
                                    jsonObject.getString("deaths"));
                            tvTodayDeaths.setText(
                                    jsonObject.getString("todayDeaths"));
                            tvAffectedCountries.setText(
                                    jsonObject.getString("affectedCountries"));
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(
                            VolleyError error)
                    {
                        Toast.makeText(MainActivity.this,
                                error.getMessage(),
                                Toast.LENGTH_SHORT)
                                .show();
                    }
                });

        RequestQueue requestQueue
                = Volley.newRequestQueue(this);
        requestQueue.add(request);
    }

    public void chip4Button(View view) {
        Intent intent =  new Intent(MainActivity.this, CountryDetailsActivity.class);
        Button button = findViewById(R.id.chip4);
        finish();
        startActivity(intent);
    }
}