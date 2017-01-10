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

    private ReisAdviesApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        travelAdviceListView = (ListView) findViewById(R.id.travelAdviceListView);
        client = new ReisAdviesApiClient(this);

        populateTravelAdviceListView();

        /* For populating the ListView with dummy data */
        //populateTravelAdviceListViewDummy();
    }

    public void populateTravelAdviceListView() {
        client.requestAdviezen(new ReisAdviesApiClient.DataHandler() {
            @Override
            public void onDataReady(ArrayList<ReisAdviesItem> data) {
                Log.i(TAG, "Data is ready");
                travelAdviceListView.setAdapter(new ReisAdviesArrayAdapter(getApplicationContext(), data));
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
                ReisAdviesItem item = (ReisAdviesItem) adapterView.getAdapter().getItem(i);
                Intent intent = new Intent(MainActivity.this, ReisAdviesDetailActivity.class);
                intent.putExtra(ReisAdviesDetailActivity.EXTRA_TRAVELADVICE_ITEM, item);
                startActivity(intent);
            }
        });
    }

    public void populateTravelAdviceListViewDummy() {
        ArrayList<ReisAdviesItem> data = ReisAdviesItem.getDummyData();
        travelAdviceListView.setAdapter(new ReisAdviesArrayAdapter(getApplicationContext(), data));
    }

    private void handleException(Exception ex) {
        Log.e(TAG, "Exception has occurred: " + ex.getMessage());
        ex.printStackTrace();
    }
}
