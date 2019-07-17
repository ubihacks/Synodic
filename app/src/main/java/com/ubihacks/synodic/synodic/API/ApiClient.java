package com.ubihacks.synodic.synodic.API;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Atiq on 4/10/2018.
 */

public class ApiClient {

    private static final String API_BASE_URL = "http://track.gatsan.com/api/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient() {
        if (retrofit==null) {

            OkHttpClient client = new OkHttpClient();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();

            builder.addInterceptor(new AddCookiesInterceptor()); // VERY VERY IMPORTANT
            builder.addInterceptor(new ReceivedCookiesInterceptor()); // VERY VERY IMPORTANT
            client = builder.build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}