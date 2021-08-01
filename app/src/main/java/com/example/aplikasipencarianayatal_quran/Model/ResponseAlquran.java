package com.example.aplikasipencarianayatal_quran.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseAlquran {

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("data Al Quran")
    private List<DataAlQuranItem> dataAlQuran;

    @SerializedName("status")
    private int status;

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public void setDataAlQuran(List<DataAlQuranItem> dataAlQuran) {
        this.dataAlQuran = dataAlQuran;
    }

    public List<DataAlQuranItem> getDataAlQuran() {
        return dataAlQuran;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}