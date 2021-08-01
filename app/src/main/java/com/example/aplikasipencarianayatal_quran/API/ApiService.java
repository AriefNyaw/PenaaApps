package com.example.aplikasipencarianayatal_quran.API;

import com.example.aplikasipencarianayatal_quran.Model.ResponseAlquran;
import com.example.aplikasipencarianayatal_quran.Model.ResponseCariSurah;
import com.example.aplikasipencarianayatal_quran.Model.ResponseDoa;
import com.example.aplikasipencarianayatal_quran.Model.ResponseIsiTopikQuran;
import com.example.aplikasipencarianayatal_quran.Model.ResponseNamaSurah;
import com.example.aplikasipencarianayatal_quran.Model.ResponseTopikQuran;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("getNamaSurah")
    Call<ResponseNamaSurah> NamaSurah();

    @GET("getAlquranID")
    Call<ResponseAlquran> Alquran(@Query("sura_id") String suraId);

    @GET("getCariSurah")
    Call<ResponseCariSurah> cariSurah(@Query("indo_text") String indoText);

    @GET("getDoa")
    Call<ResponseDoa> Doa();

    @GET("getTopikQuran")
    Call<ResponseTopikQuran> TopikQuran();

    @GET("getIsiTopikQuran")
    Call<ResponseIsiTopikQuran> DetailTopikQuran(@Query("kategori_id") String kid);
}
