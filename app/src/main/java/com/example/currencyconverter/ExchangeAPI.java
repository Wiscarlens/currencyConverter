package com.example.currencyconverter;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ExchangeAPI {
    // essential URL structure is built using constants
    public static final String ACCESS_KEY = "1c68bf08cb6304d8719c408a1eda9af3";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    static OkHttpClient httpClient = new OkHttpClient();

    // sendLiveRequest() function is created to request and retrieve the data
    public static double sendLiveRequest(String baseValue, String convertedValue)
            throws JSONException {

        // Build the URL
        String url = BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY;

//        JSONObject exchangeRates = null;

        JSONObject exchangeRates = null;
        try {
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            Response response = httpClient.newCall(request).execute();
            ResponseBody responseBody = response.body();

            if (responseBody != null) {
                // Parse the JSON response
                exchangeRates = new JSONObject(responseBody.string());
                //return exchangeRates.getJSONObject("quotes").getDouble(baseValue + convertedValue);
            }

        } catch (Exception e) {
            Log.e("Exception", Objects.requireNonNull(e.getMessage()));
        }

        if (exchangeRates != null) {
            return exchangeRates.getJSONObject("quotes").getDouble(baseValue + convertedValue);
        } else {
            return 0.0; // Handle error case appropriately
        }
//        return 0.0;
    }
}
