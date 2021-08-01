package com.example.aplikasipencarianayatal_quran.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://penaaApps.000webhostapp.com/Backend_Alquran/index.php/API_Alquran/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    public static ApiService service = retrofit.create(ApiService.class);
}
