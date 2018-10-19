package com.quicksilver.getmydrivercard.http;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHttpRequester implements HttpRequester {

    public OkHttpHttpRequester() {

    }

    @Override
    public String get(String url) throws IOException {
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();
        String body = response.body().string();

        return body;
    }


    @Override
    public String post(String url, String body) throws IOException {
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"), body
        );

        Request request = new Request.Builder()
                .post(requestBody)
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        return responseBody;
    }

    @Override
    public String put(String url, String body) throws IOException {
        RequestBody requestBody = RequestBody.create(
                MediaType.parse("application/json"), body
        );

        Request request = new Request.Builder()
                .put(requestBody)
                .url(url)
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();
        String responseBody = response.body().string();

        return responseBody;
    }
}
