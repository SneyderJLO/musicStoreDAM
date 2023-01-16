package com.example.musicstore.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit = null;
    public static Retrofit getClient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://603c-157-100-112-154.ngrok.io/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
