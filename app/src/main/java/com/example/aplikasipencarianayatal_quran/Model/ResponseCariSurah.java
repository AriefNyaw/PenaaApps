package com.example.aplikasipencarianayatal_quran.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseCariSurah {

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("Data Pencarian Surah")
    private List<DataPencarianSurahItem> dataPencarianSurah;

    @SerializedName("status")
    private int status;

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public void setDataPencarianSurah(List<DataPencarianSurahItem> dataPencarianSurah) {
        this.dataPencarianSurah = dataPencarianSurah;
    }

    public List<DataPencarianSurahItem> getDataPencarianSurah() {
        return dataPencarianSurah;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}