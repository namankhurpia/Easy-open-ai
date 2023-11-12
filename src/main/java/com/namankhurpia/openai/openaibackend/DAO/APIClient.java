package com.namankhurpia.openai.openaibackend.DAO;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.namankhurpia.openai.openaibackend.Interfaces.EndPoints.BASE_URL;

public class APIClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient(){

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit =new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        return  retrofit;
    }

}
