package com.example.aplikasipencarianayatal_quran.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ResponseIsiTopikQuran {

    @SerializedName("pesan")
    private String pesan;

    @SerializedName("Data Isi Topik Quran")
    private List<DataIsiTopikQuranItem> dataIsiTopikQuran;

    @SerializedName("status")
    private int status;

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }

    public String getPesan() {
        return pesan;
    }

    public void setDataIsiTopikQuran(List<DataIsiTopikQuranItem> dataIsiTopikQuran) {
        this.dataIsiTopikQuran = dataIsiTopikQuran;
    }

    public List<DataIsiTopikQuranItem> getDataIsiTopikQuran() {
        return dataIsiTopikQuran;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}