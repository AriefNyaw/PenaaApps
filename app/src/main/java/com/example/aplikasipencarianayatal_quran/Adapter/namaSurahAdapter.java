package com.example.aplikasipencarianayatal_quran.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.Activity.AlquranActivity;
import com.example.aplikasipencarianayatal_quran.Model.DataNamaSurahItem;
import com.example.aplikasipencarianayatal_quran.R;

import java.util.List;

public class namaSurahAdapter extends RecyclerView.Adapter<namaSurahAdapter.SurahViewHolder> {
    List<DataNamaSurahItem> ListSurah;
    Context context;

    public namaSurahAdapter(Context context, List<DataNamaSurahItem> listSurah) {
        this.context = context;
        ListSurah = listSurah;
    }

    @NonNull
    @Override
    public namaSurahAdapter.SurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // menghubungkan dengan layout yang ditargetkan
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_nama_surah, parent, false);
        return new SurahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull namaSurahAdapter.SurahViewHolder holder, int position) {
        // data yang akan tampil di activity target
        holder.txtNomorSurah.setText(ListSurah.get(position).getSuraId());
        holder.txtNamaSurah.setText(ListSurah.get(position).getNamaSurah());
        holder.txtKotaSurah.setText(ListSurah.get(position).getKotaSurah());
        holder.txtJmlhAyat.setText(ListSurah.get(position).getJmlhAyat());
        holder.txtAyatText.setText(ListSurah.get(position).getAyatText());

        holder.cvSurah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), AlquranActivity.class);
                //passing data ke target detail surah activity
                intent.putExtra("idSura", ListSurah.get(position).getSuraId());
                intent.putExtra("namaSurah", ListSurah.get(position).getNamaSurah());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ListSurah.size();
    }

    public class SurahViewHolder extends RecyclerView.ViewHolder {
        //        deklarasi variabel
        TextView txtNomorSurah, txtNamaSurah, txtKotaSurah, txtJmlhAyat, txtAyatText;
        CardView cvSurah;

        public SurahViewHolder(@NonNull View itemView) {
            super(itemView);
//            inisialisasi variabel dengan Id layout
            txtNomorSurah = itemView.findViewById(R.id.txtNomorAyat);
            txtNamaSurah = itemView.findViewById(R.id.txtNamaSurah);
            txtKotaSurah = itemView.findViewById(R.id.txtKota);
            txtJmlhAyat = itemView.findViewById(R.id.txtJmlhAyat);
            txtAyatText = itemView.findViewById(R.id.txtAyatText);
            cvSurah = itemView.findViewById(R.id.cvSurah);
        }
    }

}
