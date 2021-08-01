package com.example.aplikasipencarianayatal_quran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.Model.DetailCariSurahItem;
import com.example.aplikasipencarianayatal_quran.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SearchSurahChildAdapter extends RecyclerView.Adapter<SearchSurahChildAdapter.SearchChildViewHolder> {
    List<DetailCariSurahItem> detailCariSurahItems;
    Context context;

    public SearchSurahChildAdapter(Context context, List<DetailCariSurahItem> detail) {
        this.detailCariSurahItems = detail;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public SearchChildViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_child_search, parent, false);
        return new SearchChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SearchSurahChildAdapter.SearchChildViewHolder holder, int position) {
        holder.nomorSurah.setText(detailCariSurahItems.get(position).getVerseID());
        holder.ayat.setText(detailCariSurahItems.get(position).getAyahText());
        holder.terjemahan.setText(detailCariSurahItems.get(position).getIndoText());

    }

    @Override
    public int getItemCount() {
        return detailCariSurahItems.size();
    }

    public class SearchChildViewHolder extends RecyclerView.ViewHolder {
        TextView nomorSurah, ayat, terjemahan;

        public SearchChildViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            nomorSurah = itemView.findViewById(R.id.txtNomorSearch);
            ayat = itemView.findViewById(R.id.txtAyatTextSearch);
            terjemahan = itemView.findViewById(R.id.txtArtiAyatSearch);
        }
    }
}
