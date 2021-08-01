package com.example.aplikasipencarianayatal_quran.Model;

import com.google.gson.annotations.SerializedName;

public class DataNamaSurahItem {

    @SerializedName("kota_surah")
    private String kotaSurah;

    @SerializedName("arti_ayat")
    private String artiAyat;

    @SerializedName("ayat_text")
    private String ayatText;

    @SerializedName("jmlh_ayat")
    private String jmlhAyat;

    @SerializedName("nama_surah")
    private String namaSurah;

    @SerializedName("sura_id")
    private String suraId;

    public void setKotaSurah(String kotaSurah) {
        this.kotaSurah = kotaSurah;
    }

    public String getKotaSurah() {
        return kotaSurah;
    }

    public void setArtiAyat(String artiAyat) {
        this.artiAyat = artiAyat;
    }

    public String getArtiAyat() {
        return artiAyat;
    }

    public void setAyatText(String ayatText) {
        this.ayatText = ayatText;
    }

    public String getAyatText() {
        return ayatText;
    }

    public void setJmlhAyat(String jmlhAyat) {
        this.jmlhAyat = jmlhAyat;
    }

    public String getJmlhAyat() {
        return jmlhAyat;
    }

    public void setNamaSurah(String namaSurah) {
        this.namaSurah = namaSurah;
    }

    public String getNamaSurah() {
        return namaSurah;
    }

    public void setSuraId(String suraId) {
        this.suraId = suraId;
    }

    public String getSuraId() {
        return suraId;
    }
}