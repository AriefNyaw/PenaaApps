package com.example.aplikasipencarianayatal_quran.API;

import com.google.cloud.dialogflow.v2.DetectIntentResponse;

public interface Botreply {
    void callback(DetectIntentResponse returnResponse);
}
