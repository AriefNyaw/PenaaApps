package com.example.aplikasipencarianayatal_quran.Activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.API.ConfigRetrofit;
import com.example.aplikasipencarianayatal_quran.Adapter.DetailSurahAdapter;
import com.example.aplikasipencarianayatal_quran.Model.DataAlQuranItem;
import com.example.aplikasipencarianayatal_quran.Model.ResponseAlquran;
import com.example.aplikasipencarianayatal_quran.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlquranActivity extends AppCompatActivity {

    @BindView(R.id.RvAyat)
    RecyclerView RvAyat;
    String surahId;
    String namaSurah;
    private static final String TAG = "Detail_surah_Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alquran);
        ButterKnife.bind(this);
        //terima data intent dari surah adapter
        surahId = getIntent().getStringExtra("idSura");
        namaSurah = getIntent().getStringExtra("namaSurah");
        getSupportActionBar().setTitle(namaSurah);

        //untuk melakukan pengecekan jika surah id yg di terima kosong
        if (surahId.isEmpty()) {
            surahId = "1";
            tampilDetailAyat();
            Log.d(TAG, "onCreate: surah id tidak ditemukan");
        } else {
            tampilDetailAyat();
        }

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    private void tampilDetailAyat() {
        final CustomProgressDialogActivity loading = new CustomProgressDialogActivity(AlquranActivity.this);
        loading.show();
        ConfigRetrofit.service.Alquran(surahId).enqueue(new Callback<ResponseAlquran>() {
            @Override
            public void onResponse(Call<ResponseAlquran> call, Response<ResponseAlquran> response) {
                loading.dismiss();
                int status = response.body().getStatus();
                if (status == 1) {
                    List<DataAlQuranItem> detailayat = response.body().getDataAlQuran();
                    DetailSurahAdapter adapterAyat = new DetailSurahAdapter(AlquranActivity.this, detailayat);
                    RvAyat.setAdapter(adapterAyat);
                    RvAyat.setLayoutManager(new LinearLayoutManager(AlquranActivity.this));
                } else {
                    Toast.makeText(AlquranActivity.this, "Surah Tidak Ada", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseAlquran> call, Throwable t) {

            }
        });
    }
}