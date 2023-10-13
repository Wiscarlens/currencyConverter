package com.example.currencyconverter;

import android.util.Log;

import org.json.JSONObject;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ExchangeAPI {
    public static final String ACCESS_KEY = "1c68bf08cb6304d8719c408a1eda9af3";
    public static final String BASE_URL = "http://api.currencylayer.com/";
    public static final String ENDPOINT = "live";
    static OkHttpClient httpClient = new OkHttpClient();

    public static void sendLiveRequest(final String baseValue, final String convertedValue, final ExchangeCallback callback) {
        // Build the URL
        String url = BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY;

        new Thread(new Runnable() {
            @Override
            public void run() {
                JSONObject exchangeRates;

                try {
                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    Response response = httpClient.newCall(request).execute();
                    ResponseBody responseBody = response.body();

                    // Parse the JSON response
                    assert responseBody != null;
                    exchangeRates = new JSONObject(responseBody.string());

                    if (callback != null) {
                        double rate = exchangeRates.getJSONObject("quotes").getDouble(baseValue + convertedValue);
                        callback.onSuccess(rate);
                    }
                } catch (Exception e) {
                    Log.e("Error", e.toString());
                    if (callback != null) {
                        callback.onError(e);
                    }
                }
            }
        }).start();
    }

    public interface ExchangeCallback {
        void onSuccess(double rate);
        void onError(Exception e);
    }
}
