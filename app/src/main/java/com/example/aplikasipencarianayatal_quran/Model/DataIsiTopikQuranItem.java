package com.example.aplikasipencarianayatal_quran.Model;

import com.google.gson.annotations.SerializedName;

public class DataIsiTopikQuranItem {

    @SerializedName("nama_tema")
    private String namaTema;

    @SerializedName("namasub_tema")
    private String namasubTema;

    @SerializedName("kategori_id")
    private String kategoriID;

    @SerializedName("verse_id")
    private String verseID;

    @SerializedName("ayah_text")
    private String ayahText;

    @SerializedName("read_text")
    private String readText;

    @SerializedName("indo_text")
    private String indoText;

    @SerializedName("nama_surah")
    private String namaSurah;

    public void setNamaTema(String namaTema) {
        this.namaTema = namaTema;
    }

    public String getNamaTema() {
        return namaTema;
    }

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

    public void setIndoText(String indoText) {
        this.indoText = indoText;
    }

    public String getIndoText() {
        return indoText;
    }

    public void setNamaSurah(String namaSurah) {
        this.namaSurah = namaSurah;
    }

    public String getNamaSurah() {
        return namaSurah;
    }
}