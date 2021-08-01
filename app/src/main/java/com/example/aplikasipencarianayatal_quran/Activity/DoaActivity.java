package com.example.aplikasipencarianayatal_quran.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.API.ConfigRetrofit;
import com.example.aplikasipencarianayatal_quran.Adapter.DoaAdapter;
import com.example.aplikasipencarianayatal_quran.Model.DataDoaItem;
import com.example.aplikasipencarianayatal_quran.Model.ResponseDoa;
import com.example.aplikasipencarianayatal_quran.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoaActivity extends AppCompatActivity {

    @BindView(R.id.RvDoa)
    RecyclerView RvDoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doa);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Doa Harian");
        TampilDoa();
    }

    private void TampilDoa() {
        RvDoa.setVisibility(View.GONE);
        final CustomProgressDialogActivity loading = new CustomProgressDialogActivity(DoaActivity.this);
        loading.show();
        ConfigRetrofit.service.Doa().enqueue(new Callback<ResponseDoa>() {
            @Override
            public void onResponse(Call<ResponseDoa> call, Response<ResponseDoa> response) {
                loading.dismiss();
                if (response.isSuccessful()) {
                    int status = response.body().getStatus();
                    RvDoa.setVisibility(View.VISIBLE);
                    if (status == 1) {
                        List<DataDoaItem> doaItem = response.body().getDataDoa();
                        DoaAdapter doaAdapter = new DoaAdapter(DoaActivity.this, doaItem);
                        RvDoa.setAdapter(doaAdapter);
                        RvDoa.setLayoutManager(new LinearLayoutManager(DoaActivity.this));
                    } else {
                        RvDoa.setVisibility(View.GONE);
                    }
                } else {
                    Toast.makeText(DoaActivity.this, "doa Tidak Ada Di Database", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDoa> call, Throwable t) {
                Toast.makeText(DoaActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
