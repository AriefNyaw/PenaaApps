package com.example.aplikasipencarianayatal_quran.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.API.ConfigRetrofit;
import com.example.aplikasipencarianayatal_quran.Adapter.DetailIsiTopikQuranAdapter;
import com.example.aplikasipencarianayatal_quran.Model.DataIsiTopikQuranItem;
import com.example.aplikasipencarianayatal_quran.Model.ResponseIsiTopikQuran;
import com.example.aplikasipencarianayatal_quran.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IsiTopikQuranActivity extends AppCompatActivity {

    @BindView(R.id.RvIsiKategori)
    RecyclerView RvIsiKategori;
    String kid;
    String namaSub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_topik_quran);
        ButterKnife.bind(this);
        kid = getIntent().getStringExtra("KategoriId");
        namaSub = getIntent().getStringExtra("namaSub");
        getSupportActionBar().setTitle(namaSub);

        //cek isi id Kategori
        if (kid.isEmpty()) {
            kid = "1";
            tampilIsiKategori();
        } else {
            tampilIsiKategori();
        }
    }

    private void tampilIsiKategori() {
        final CustomProgressDialogActivity loading = new CustomProgressDialogActivity(IsiTopikQuranActivity.this);
        loading.show();
        ConfigRetrofit.service.DetailTopikQuran(kid).enqueue(new Callback<ResponseIsiTopikQuran>() {

            @Override
            public void onResponse(Call<ResponseIsiTopikQuran> call, Response<ResponseIsiTopikQuran> response) {
                loading.dismiss();
                int status = response.body().getStatus();
                if (status == 1) {
                    List<DataIsiTopikQuranItem> kategoriAyatItems = response.body().getDataIsiTopikQuran();
                    DetailIsiTopikQuranAdapter isiKAdapter = new DetailIsiTopikQuranAdapter(IsiTopikQuranActivity.this, kategoriAyatItems);
                    RvIsiKategori.setAdapter(isiKAdapter);
                    RvIsiKategori.setLayoutManager(new LinearLayoutManager(IsiTopikQuranActivity.this));
                } else {
                    Toast.makeText(IsiTopikQuranActivity.this, "Isi Kategori Tidak Ada", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseIsiTopikQuran> call, Throwable t) {

            }
        });
    }
}