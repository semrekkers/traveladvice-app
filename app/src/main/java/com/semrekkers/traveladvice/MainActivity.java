package com.semrekkers.traveladvice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";

    private ListView travelAdviceListView;

    private TravelAdviceApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        travelAdviceListView = (ListView) findViewById(R.id.travelAdviceListView);
        client = new TravelAdviceApiClient(this);

        populateTravelAdviceListView();
    }

    public void populateTravelAdviceListView() {
        client.requestTravelAdvices(new TravelAdviceApiClient.DataHandler() {
            @Override
            public void onDataReady(ArrayList<TravelAdvice> data) {
                Log.i(TAG, "Data is ready");
                travelAdviceListView.setAdapter(new TravelAdviceArrayAdapter(getApplicationContext(), data));
            }

            @Override
            public void onDataException(Exception ex) {
                handleException(ex);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handleException(error);
            }
        });

        travelAdviceListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TravelAdvice item = (TravelAdvice) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent(MainActivity.this, TravelAdviceDetailActivity.class);
                intent.putExtra(TravelAdviceDetailActivity.EXTRA_TRAVELADVICE_ITEM, item);
                startActivity(intent);
            }
        });
    }

    private void handleException(Exception ex) {
        Log.e(TAG, "Exception has occurred: " + ex.getMessage());
        ex.printStackTrace();
    }
}
