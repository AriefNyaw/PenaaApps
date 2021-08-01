package com.example.aplikasipencarianayatal_quran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.Model.DataAlQuranItem;
import com.example.aplikasipencarianayatal_quran.R;

import java.util.List;

public class DetailSurahAdapter extends RecyclerView.Adapter<DetailSurahAdapter.DetailSurahViewHolder> {
    List<DataAlQuranItem> detailSurah;
    Context context;

    public DetailSurahAdapter(Context context, List<DataAlQuranItem> Detailsurah) {
        this.context = context;
        detailSurah = Detailsurah;
    }

    @NonNull
    @Override
    public DetailSurahAdapter.DetailSurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //menghubungkan dengan layout yang ditargetkan
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_alquran, parent, false);
        return new DetailSurahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailSurahAdapter.DetailSurahViewHolder holder, int position) {
        //data yang akan ditampilkan pada layout target
        holder.txtNomerAyat.setText(detailSurah.get(position).getVerseID());
        holder.txtAyahText.setText(detailSurah.get(position).getAyahText());
        holder.txtLatin.setText(detailSurah.get(position).getReadText());
        holder.txtArtiAyat.setText(detailSurah.get(position).getIndoText());

    }

    @Override
    public int getItemCount() {
        return detailSurah.size();
    }

    public class DetailSurahViewHolder extends RecyclerView.ViewHolder {
        //        deklarasi variable
        TextView txtNomerAyat, txtAyahText, txtLatin, txtArtiAyat;

        public DetailSurahViewHolder(@NonNull View itemView) {
            super(itemView);
//            inisialisasi variable
            txtNomerAyat = itemView.findViewById(R.id.txtNomor);
            txtAyahText = itemView.findViewById(R.id.txtAyatText);
            txtLatin = itemView.findViewById(R.id.txtLatin);
            txtArtiAyat = itemView.findViewById(R.id.txtArtiAyat);
        }
    }
}