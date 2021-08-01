package com.example.aplikasipencarianayatal_quran.Model;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class DataPencarianSurahItem {

    boolean expandable;

    @SerializedName("total")
    private String total;

    @SerializedName("detail cari surah")
    private List<DetailCariSurahItem> detailCariSurah;

    @SerializedName("nama_surah")
    private String namaSurah;

    @SerializedName("sura_id")
    private String suraId;

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal() {
        return total;
    }

    public void setDetailCariSurah(List<DetailCariSurahItem> detailCariSurah) {
        this.detailCariSurah = detailCariSurah;
    }

    public List<DetailCariSurahItem> getDetailCariSurah() {
        return detailCariSurah;
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

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }
}