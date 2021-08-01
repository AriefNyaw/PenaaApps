package com.example.aplikasipencarianayatal_quran.Model;

import com.google.gson.annotations.SerializedName;

public class DataAlQuranItem {

    @SerializedName("kategori_id")
    private Object kategoriID;

    @SerializedName("verse_id")
    private String verseID;

    @SerializedName("ayah_text")
    private String ayahText;

    @SerializedName("read_text")
    private String readText;

    @SerializedName("id")
    private String id;

    @SerializedName("indo_text")
    private String indoText;

    @SerializedName("sura_id")
    private String suraId;

    public void setKategoriID(Object kategoriID) {
        this.kategoriID = kategoriID;
    }

    public Object getKategoriID() {
        return kategoriID;
    }

    public void setVerseID(String verseID) {
        this.verseID = verseID;
    }

    public String getVerseID() {
        return verseID;
    }

    public void setAyahText(String ayahText) {
        this.ayahText = ayahText;
    }

    public String getAyahText() {
        return ayahText;
    }

    public void setReadText(String readText) {
        this.readText = readText;
    }

    public String getReadText() {
        return readText;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setIndoText(String indoText) {
        this.indoText = indoText;
    }

    public String getIndoText() {
        return indoText;
    }

    public void setSuraId(String suraId) {
        this.suraId = suraId;
    }

    public String getSuraId() {
        return suraId;
    }
}