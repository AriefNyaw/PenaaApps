package com.example.aplikasipencarianayatal_quran.Model;

import com.google.gson.annotations.SerializedName;

public class DataDoaItem {

    boolean expandable;

    @SerializedName("doa_id")
    private String doaId;

    @SerializedName("doa_text")
    private String doaText;

    @SerializedName("latin_text")
    private String latinText;

    @SerializedName("terjemahan")
    private String terjemahan;

    @SerializedName("nama_doa")
    private String namaDoa;

    public void setDoaId(String doaId) {
        this.doaId = doaId;
    }

    public String getDoaId() {
        return doaId;
    }

    public void setDoaText(String doaText) {
        this.doaText = doaText;
    }

    public String getDoaText() {
        return doaText;
    }

    public void setLatinText(String latinText) {
        this.latinText = latinText;
    }

    public String getLatinText() {
        return latinText;
    }

    public void setTerjemahan(String terjemahan) {
        this.terjemahan = terjemahan;
    }

    public String getTerjemahan() {
        return terjemahan;
    }

    public void setNamaDoa(String namaDoa) {
        this.namaDoa = namaDoa;
    }

    public String getNamaDoa() {
        return namaDoa;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }
}