package com.example.aplikasipencarianayatal_quran.Model;

import com.google.gson.annotations.SerializedName;

public class DetailCariSurahItem {

    @SerializedName("verse_id")
    private String verseID;

    @SerializedName("indo_text")
    private String indoText;

    @SerializedName("ayah_text")
    private String ayahText;

    public void setVerseID(String verseID) {
        this.verseID = verseID;
    }

    public String getVerseID() {
        return verseID;
    }

    public void setIndoText(String indoText) {
        this.indoText = indoText;
    }

    public String getIndoText() {
        return indoText;
    }

    public String getAyahText() {
        return ayahText;
    }

    public void setAyahText(String ayahText) {
        this.ayahText = ayahText;
    }
}