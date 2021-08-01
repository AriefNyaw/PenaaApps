package com.example.aplikasipencarianayatal_quran.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseDoa {

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("data Doa")
    private List<DataDoaItem> dataDoa;

    @SerializedName("status")
    private int status;

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public void setDataDoa(List<DataDoaItem> dataDoa) {
        this.dataDoa = dataDoa;
    }

    public List<DataDoaItem> getDataDoa() {
        return dataDoa;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}