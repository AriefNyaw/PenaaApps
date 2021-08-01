package com.example.aplikasipencarianayatal_quran.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseNamaSurah {

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("data Nama Surah")
    private List<DataNamaSurahItem> dataNamaSurah;

    @SerializedName("status")
    private int status;

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public void setDataNamaSurah(List<DataNamaSurahItem> dataNamaSurah) {
        this.dataNamaSurah = dataNamaSurah;
    }

    public List<DataNamaSurahItem> getDataNamaSurah() {
        return dataNamaSurah;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}