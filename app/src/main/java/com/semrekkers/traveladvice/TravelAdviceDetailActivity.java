package com.semrekkers.traveladvice;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.webkit.WebView;

public class TravelAdviceDetailActivity extends AppCompatActivity {

    public static final String EXTRA_TRAVELADVICE_ITEM = "EXTRA_TRAVELADVICE_ITEM";

    private WebView detailWebView;
    private TravelAdvice travelAdvice;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_advice_detail);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        detailWebView = (WebView) findViewById(R.id.detailWebView);

        Intent intent = getIntent();
        travelAdvice = (TravelAdvice) intent.getSerializableExtra(EXTRA_TRAVELADVICE_ITEM);

        init();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void init() {
        detailWebView.loadUrl(travelAdvice.Canonical);
        actionBar.setTitle(travelAdvice.Title);
    }
}
