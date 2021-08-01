package com.example.aplikasipencarianayatal_quran.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseTopikQuran {

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("data Topik Quran")
    private List<DataTopikQuranItem> dataTopikQuran;

    @SerializedName("status")
    private int status;

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public void setDataTopikQuran(List<DataTopikQuranItem> dataTopikQuran) {
        this.dataTopikQuran = dataTopikQuran;
    }

    public List<DataTopikQuranItem> getDataTopikQuran() {
        return dataTopikQuran;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}