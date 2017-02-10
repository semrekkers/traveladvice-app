package com.semrekkers.traveladvice;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import java.util.ArrayList;

/**
 * Created by Sem Rekkers on 9-1-2017.
 */

public class TravelAdviceApiClient {
    public static final String ENDPOINT = "https://opendata.rijksoverheid.nl/v1/sources/rijksoverheid/infotypes/traveladvice?output=json";

    private Context context;
    private RequestQueue queue;

    public TravelAdviceApiClient(Context context) {
        this.context = context;
        queue = Volley.newRequestQueue(context);
    }

    public JsonArrayRequest requestTravelAdvices(final DataHandler handler, Response.ErrorListener errorListener) {
        JsonArrayRequest req = new JsonArrayRequest(Request.Method.GET, ENDPOINT, null,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        ArrayList<TravelAdvice> list = new ArrayList<>();
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                list.add(new TravelAdvice(response.getJSONObject(i)));
                            }
                        }
                        catch (Exception ex) {
                            handler.onDataException(ex);
                        }
                        handler.onDataReady(list);
                    }

                }, errorListener);

        queue.add(req);
        return req;
    }

    public interface DataHandler {
        void onDataReady(ArrayList<TravelAdvice> data);
        void onDataException(Exception ex);
    }
}
