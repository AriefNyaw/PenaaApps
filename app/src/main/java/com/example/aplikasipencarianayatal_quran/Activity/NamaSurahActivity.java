package com.example.aplikasipencarianayatal_quran.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.API.ConfigRetrofit;
import com.example.aplikasipencarianayatal_quran.Adapter.namaSurahAdapter;
import com.example.aplikasipencarianayatal_quran.Model.DataNamaSurahItem;
import com.example.aplikasipencarianayatal_quran.Model.ResponseNamaSurah;
import com.example.aplikasipencarianayatal_quran.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NamaSurahActivity extends AppCompatActivity {

    @BindView(R.id.RvSurah)
    RecyclerView RvSurah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nama_surah);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Daftar Surah");
        tampilListSurah();
    }

    private void tampilListSurah() {
        final CustomProgressDialogActivity loading = new CustomProgressDialogActivity(NamaSurahActivity.this);
        loading.show();
        ConfigRetrofit.service.NamaSurah().enqueue(new Callback<ResponseNamaSurah>() {
            @Override
            public void onResponse(Call<ResponseNamaSurah> call, Response<ResponseNamaSurah> response) {
                loading.dismiss();
                int status = response.body().getStatus();
                if (status == 1) {
                    List<DataNamaSurahItem> listsurah = response.body().getDataNamaSurah();
                    namaSurahAdapter adapterSurah = new namaSurahAdapter(NamaSurahActivity.this, listsurah);
                    RvSurah.setAdapter(adapterSurah);
                    RvSurah.setLayoutManager(new LinearLayoutManager(NamaSurahActivity.this));
                } else {
                    Toast.makeText(NamaSurahActivity.this, "Surah Tidak Ada", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseNamaSurah> call, Throwable t) {
                Toast.makeText(NamaSurahActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}