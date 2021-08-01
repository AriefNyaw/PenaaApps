package com.example.aplikasipencarianayatal_quran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.Model.DataIsiTopikQuranItem;
import com.example.aplikasipencarianayatal_quran.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DetailIsiTopikQuranAdapter extends RecyclerView.Adapter<DetailIsiTopikQuranAdapter.DetailIsiKViewHolder> {
    List<DataIsiTopikQuranItem> kategoriAyatItems;
    Context context;

    public DetailIsiTopikQuranAdapter(Context context, List<DataIsiTopikQuranItem> kategoriAyatItems) {
        this.kategoriAyatItems = kategoriAyatItems;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public DetailIsiKViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_isi_topik_quran, parent, false);
        return new DetailIsiKViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull DetailIsiTopikQuranAdapter.DetailIsiKViewHolder holder, int position) {
        holder.namaSurah.setText(kategoriAyatItems.get(position).getNamaSurah());
        holder.nomorAyat.setText(kategoriAyatItems.get(position).getVerseID());
        holder.ayatText.setText(kategoriAyatItems.get(position).getAyahText());
        holder.latinText.setText(kategoriAyatItems.get(position).getReadText());
        holder.terjemahan.setText(kategoriAyatItems.get(position).getIndoText());

    }

    @Override
    public int getItemCount() {
        return kategoriAyatItems.size();
    }

    public class DetailIsiKViewHolder extends RecyclerView.ViewHolder {
        TextView namaSurah, nomorAyat, ayatText, latinText, terjemahan;

        public DetailIsiKViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            namaSurah = itemView.findViewById(R.id.txtNamaSurahK);
            nomorAyat = itemView.findViewById(R.id.txtNomorAK);
            ayatText = itemView.findViewById(R.id.txtAyatTextK);
            latinText = itemView.findViewById(R.id.txtLatinK);
            terjemahan = itemView.findViewById(R.id.txtArtiAyatK);
        }
    }
}
