package com.example.aplikasipencarianayatal_quran.Model;

import com.google.gson.annotations.SerializedName;

public class DataSubTopikQuranItem {

    @SerializedName("namasub_tema")
    private String namasubTema;

    @SerializedName("kategori_id")
    private String kategoriID;

    @SerializedName("subtema_id")
    private String subtemaID;

    public void setNamasubTema(String namasubTema) {
        this.namasubTema = namasubTema;
    }

    public String getNamasubTema() {
        return namasubTema;
    }

    public void setKategoriID(String kategoriID) {
        this.kategoriID = kategoriID;
    }

    public String getKategoriID() {
        return kategoriID;
    }

    public void setSubtemaID(String subtemaID) {
        this.subtemaID = subtemaID;
    }

    public String getSubtemaID() {
        return subtemaID;
    }
}