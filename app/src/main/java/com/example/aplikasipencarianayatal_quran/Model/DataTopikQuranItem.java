package com.example.aplikasipencarianayatal_quran.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DataTopikQuranItem {

    @SerializedName("nama_tema")
    private String namaTema;

    @SerializedName("tema_id")
    private String temaID;

    @SerializedName("data Sub Topik Quran")
    private List<DataSubTopikQuranItem> dataSubTopikQuran;

    public void setNamaTema(String namaTema) {
        this.namaTema = namaTema;
    }

    public String getNamaTema() {
        return namaTema;
    }

    public void setTemaID(String temaID) {
        this.temaID = temaID;
    }

    public String getTemaID() {
        return temaID;
    }

    public void setDataSubTopikQuran(List<DataSubTopikQuranItem> dataSubTopikQuran) {
        this.dataSubTopikQuran = dataSubTopikQuran;
    }

    public List<DataSubTopikQuranItem> getDataSubTopikQuran() {
        return dataSubTopikQuran;
    }
}