package com.example.aplikasipencarianayatal_quran;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;

import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.API.Botreply;
import com.example.aplikasipencarianayatal_quran.Activity.SearchProgressDialogActivity;
import com.example.aplikasipencarianayatal_quran.Activity.TopikQuranActivity;
import com.example.aplikasipencarianayatal_quran.Activity.NamaSurahActivity;
import com.example.aplikasipencarianayatal_quran.Activity.SearchAyatActivity;
import com.example.aplikasipencarianayatal_quran.Activity.DoaActivity;
import com.example.aplikasipencarianayatal_quran.Adapter.PesanAdapter;
import com.example.aplikasipencarianayatal_quran.Helper.SendMessageInBg;
import com.example.aplikasipencarianayatal_quran.Model.Message;
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
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Botreply {


    @BindView(R.id.cardQuran)
    CardView cardQuran;
    @BindView(R.id.edtSearch)
    EditText edtSearch;
    @BindView(R.id.cardTopik)
    CardView cardTopik;
    @BindView(R.id.cardDoa)
    CardView cardDoa;

    RecyclerView chatView;

    PesanAdapter pesanAdapter;
    List<Message> messageList = new ArrayList<>();


    //dialogFlow
    private SessionsClient sessionsClient;
    private SessionName sessionName;
    private final String uuid = UUID.randomUUID().toString();
    private final String TAG = "mainactivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        chatView =findViewById(R.id.chatView);
        pesanAdapter = new PesanAdapter(this, messageList);
        chatView.setAdapter(pesanAdapter);


        //untuk mensubmit editText menggunakan soft keyboard
        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH
                        || i == EditorInfo.IME_ACTION_DONE
                        || keyEvent.getAction() == KeyEvent.ACTION_DOWN
                        && keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    hitDialogFlow(edtSearch.getText().toString());

//                    Intent intent = new Intent(MainActivity.this, SearchAyatActivity.class);
//                    intent.putExtra("cari", edtSearch.getText().toString());
//                    startActivity(intent);
//                    edtSearch.setText("");
                    return true;
                }
                return false;
            }
        });
        setUpBot();
    }

    @OnClick({R.id.cardQuran, R.id.cardTopik, R.id.cardDoa})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cardQuran:
                startActivity(new Intent(this, NamaSurahActivity.class));
                break;
            case R.id.cardTopik:
                startActivity(new Intent(this, TopikQuranActivity.class));
                break;
            case R.id.cardDoa:
                startActivity(new Intent(this, DoaActivity.class));
                break;
        }
    }

    private void hitDialogFlow(String message){
        chatView.setVisibility(View.GONE);
        if (!message.isEmpty()) {
            messageList.add(new Message(message, false));
            sendMessageToBot(message);
            Objects.requireNonNull(chatView.getAdapter()).notifyDataSetChanged();
            Objects.requireNonNull(chatView.getLayoutManager())
                    .scrollToPosition(messageList.size() - 1);
        }
    }

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

    @Override
    public void callback(DetectIntentResponse returnResponse) {
        if (returnResponse != null) {
            String botReply = returnResponse.getQueryResult().getFulfillmentText();
            if (!botReply.isEmpty()) {
                messageList.add(new Message(botReply, true));
                pesanAdapter.notifyDataSetChanged();
                Objects.requireNonNull(chatView.getLayoutManager()).scrollToPosition(messageList.size() - 1);

                Intent intent = new Intent(MainActivity.this, SearchAyatActivity.class);
                intent.putExtra("cari", botReply);
                intent.putExtra("query", edtSearch.getText().toString());
                startActivity(intent);
                edtSearch.setText("");

            } else {
                Toast.makeText(this, "something went wrong", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "failed to connect!", Toast.LENGTH_SHORT).show();
        }
    }
}