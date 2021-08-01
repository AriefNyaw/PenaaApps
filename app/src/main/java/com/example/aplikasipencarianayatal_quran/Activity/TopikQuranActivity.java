package com.example.aplikasipencarianayatal_quran.Activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.API.ConfigRetrofit;
import com.example.aplikasipencarianayatal_quran.Adapter.ItemTopikQuranAdapter;
import com.example.aplikasipencarianayatal_quran.Model.DataTopikQuranItem;
import com.example.aplikasipencarianayatal_quran.Model.ResponseTopikQuran;
import com.example.aplikasipencarianayatal_quran.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopikQuranActivity extends AppCompatActivity {

    @BindView(R.id.RvKategori)
    RecyclerView RvKategori;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topik_quran);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Topik Qur'an");
        TampilListKategori();
    }

    private void TampilListKategori() {
        final CustomProgressDialogActivity loading = new CustomProgressDialogActivity(TopikQuranActivity.this);
        loading.show();
        ConfigRetrofit.service.TopikQuran().enqueue(new Callback<ResponseTopikQuran>() {
            @Override
            public void onResponse(Call<ResponseTopikQuran> call, Response<ResponseTopikQuran> response) {
                loading.dismiss();
                int status = response.body().getStatus();
                if (status == 1) {
                    List<DataTopikQuranItem> listKategoriItems = response.body().getDataTopikQuran();
                    ItemTopikQuranAdapter kategoriAdapter = new ItemTopikQuranAdapter(TopikQuranActivity.this, listKategoriItems);
                    RvKategori.setAdapter(kategoriAdapter);
                    RvKategori.setLayoutManager(new LinearLayoutManager(TopikQuranActivity.this));
                } else {
                    Toast.makeText(TopikQuranActivity.this, "Kategri Tidak Ditemukan", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseTopikQuran> call, Throwable t) {

            }
        });
    }
}