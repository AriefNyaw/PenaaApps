package com.example.aplikasipencarianayatal_quran.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.API.Botreply;
import com.example.aplikasipencarianayatal_quran.API.ConfigRetrofit;
import com.example.aplikasipencarianayatal_quran.Adapter.PesanAdapter;
import com.example.aplikasipencarianayatal_quran.Adapter.SearchSurahAdapter;
import com.example.aplikasipencarianayatal_quran.Helper.SendMessageInBg;
import com.example.aplikasipencarianayatal_quran.MainActivity;
import com.example.aplikasipencarianayatal_quran.Model.DataPencarianSurahItem;
import com.example.aplikasipencarianayatal_quran.Model.Message;
import com.example.aplikasipencarianayatal_quran.Model.ResponseCariSurah;
import com.example.aplikasipencarianayatal_quran.R;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.dialogflow.v2.DetectIntentResponse;
import com.google.cloud.dialogflow.v2.QueryInput;
import com.google.cloud.dialogflow.v2.SessionName;
import com.google.cloud.dialogflow.v2.SessionsClient;
import com.google.cloud.dialogflow.v2.SessionsSettings;
import com.google.cloud.dialogflow.v2.TextInput;
import com.google.common.collect.Lists;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchAyatActivity extends AppCompatActivity implements Botreply {

    @BindView(R.id.RvListSearchSurah)
    RecyclerView RvListSearchSurah;
    @BindView(R.id.HintCari)
    TextView HintCari;
    @BindView(R.id.chatView)
    RecyclerView chatView;

    PesanAdapter pesanAdapter;
    List<Message> messageList = new ArrayList<>();

    String dataSearch,Query;

    //dialogFlow
    private SessionsClient sessionsClient;
    private SessionName sessionName;
    private final String uuid = UUID.randomUUID().toString();
    private final String TAG = "mainactivity";

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ayat);
        ButterKnife.bind(this);
        getSupportActionBar().setTitle("Pencarian");
        pesanAdapter = new PesanAdapter(this, messageList);
        chatView.setAdapter(pesanAdapter);
        dataSearch = getIntent().getStringExtra("cari");
        Query = getIntent().getStringExtra("query");

        //pengecekan data hasil passing
        if (dataSearch != null) {
//            hitDialogFlow(dataSearch);
            CariSurah(dataSearch);
        } else {
//            dataSearch = "sedih";
//            hitDialogFlow(dataSearch);
//            Log.d(TAG, "onCreate: pencarian tidak ditemukan");
        }
        setUpBot();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //menghubungkan dengan layout yang di targetkan
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);

        //ini untuk klik action search
        MenuItem searchItem = menu.findItem(R.id.searchAyat);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setQuery(Query, true);

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                RvListSearchSurah.setVisibility(View.GONE);
                HintCari.setText("Masukan kata kunci dengan mengklik tombol cari diatas\nContoh: Ketik kata kunci 'surga' atau 'saya sedang galau'");
                HintCari.setVisibility(View.VISIBLE);
                return false;
            }
        });


        //ini untuk menset hint ketika diketik
        searchView.setQueryHint("Ketik Disini...");
        //ini untuk button selesai pada soft keyboard
        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);

        //ini buat keyword pencarian ketika diketik
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String message) {
                RvListSearchSurah.setVisibility(View.GONE);
//                chatView.setVisibility(View.GONE);
                hitDialogFlow(message);
                searchView.setOnCloseListener(new SearchView.OnCloseListener() {
                    @Override
                    public boolean onClose() {
                        RvListSearchSurah.setVisibility(View.GONE);
                        HintCari.setText("Masukan kata kunci dengan mengklik tombol cari diatas\nContoh: Ketik kata kunci 'surga' atau 'saya sedang galau'");
                        HintCari.setVisibility(View.VISIBLE);
                        return false;
                    }
                });
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    //Method untuk menSetupBot dari file Raw
    private void setUpBot() {
        try {
            InputStream stream = this.getResources().openRawResource(R.raw.api_penaa);
            GoogleCredentials credentials = GoogleCredentials.fromStream(stream)
                    .createScoped(Lists.newArrayList("https://www.googleapis.com/auth/cloud-platform"));
            String projectId = ((ServiceAccountCredentials) credentials).getProjectId();

            SessionsSettings.Builder settingsBuilder = SessionsSettings.newBuilder();
            SessionsSettings sessionsSettings = settingsBuilder.setCredentialsProvider(
                    FixedCredentialsProvider.create(credentials)).build();
            sessionsClient = SessionsClient.create(sessionsSettings);
            sessionName = SessionName.of(projectId, uuid);

            Log.d(TAG, "projectId : " + projectId);
        } catch (Exception e) {
            Log.d(TAG, "setUpBot: " + e.getMessage());
        }
    }

    //    method untuk mengirim pesan ke class SendMessageInBG
    private void sendMessageToBot(String message) {

        QueryInput input = QueryInput.newBuilder()
                .setText(TextInput.newBuilder().setText(message).setLanguageCode("indonesian-id")).build();
        Log.d(TAG, "setToBot"+" "+ input);
        new SendMessageInBg((Botreply) this, sessionName, sessionsClient, input).execute();
    }

    // untuk memanggil hasil callback dari interface botreply yang sudah di prosses pada Class SendMessageInBg
    @Override
    public void callback(DetectIntentResponse returnResponse) {
        if (returnResponse != null) {
            String botReply = returnResponse.getQueryResult().getFulfillmentText();
            if (!botReply.isEmpty()) {
                messageList.add(new Message(botReply, true));
                pesanAdapter.notifyDataSetChanged();
                Objects.requireNonNull(chatView.getLayoutManager()).scrollToPosition(messageList.size() - 1);
                //memanggil method carisurah
                CariSurah(botReply);
            } else {
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "failed to connect!", Toast.LENGTH_SHORT).show();
        }
    }

    //Method Search Ayat
    private void CariSurah(String indoText) {
        final SearchProgressDialogActivity loading = new SearchProgressDialogActivity(SearchAyatActivity.this);
        loading.show();

        ConfigRetrofit.service.cariSurah(indoText).enqueue(new Callback<ResponseCariSurah>() {
            @Override
            public void onResponse(Call<ResponseCariSurah> call, Response<ResponseCariSurah> response) {
                loading.dismiss();
                if (response.isSuccessful()) {
                    int status = response.body().getStatus();
                    RvListSearchSurah.setVisibility(View.VISIBLE);
                    HintCari.setVisibility(View.GONE);
                    if (status == 1) {
                        List<DataPencarianSurahItem> cariSurah = response.body().getDataPencarianSurah();
                        SearchSurahAdapter searchAdapter = new SearchSurahAdapter(SearchAyatActivity.this, cariSurah);
                        RvListSearchSurah.setAdapter(searchAdapter);
                        RvListSearchSurah.setLayoutManager(new LinearLayoutManager(SearchAyatActivity.this));
                    } else {
                        RvListSearchSurah.setVisibility(View.GONE);
                        HintCari.setText("Maaf kata kunci tidak ditemukan, gunakan kata kunci lain Contoh: Ketik kata kunci 'surga' atau 'saya sedang galau'");
                        HintCari.setVisibility(View.VISIBLE);
                    }
                } else {
                    Toast.makeText(SearchAyatActivity.this, "Periksa Koneksi Kembali", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseCariSurah> call, Throwable t) {

            }
        });
    }

    private void hitDialogFlow(String message){
        RvListSearchSurah.setVisibility(View.GONE);
        chatView.setVisibility(View.GONE);
        if (!message.isEmpty()) {
            messageList.add(new Message(message, false));
            sendMessageToBot(message);
            Objects.requireNonNull(chatView.getAdapter()).notifyDataSetChanged();
            Objects.requireNonNull(chatView.getLayoutManager())
                    .scrollToPosition(messageList.size() - 1);
        } else {
            HintCari.setText("Masukan kata kunci dengan mengklik tombol cari diatas\nContoh: Ketik kata kunci 'surga' atau 'saya sedang galau'");
            HintCari.setVisibility(View.VISIBLE);
            RvListSearchSurah.setVisibility(View.GONE);
        }
    }
}