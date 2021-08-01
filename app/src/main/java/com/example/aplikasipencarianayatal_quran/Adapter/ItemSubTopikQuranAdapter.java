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

import com.example.aplikasipencarianayatal_quran.Activity.IsiTopikQuranActivity;
import com.example.aplikasipencarianayatal_quran.Model.DataSubTopikQuranItem;
import com.example.aplikasipencarianayatal_quran.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemSubTopikQuranAdapter extends RecyclerView.Adapter<ItemSubTopikQuranAdapter.itemKategoriViewHolder> {
    List<DataSubTopikQuranItem> itemList;
    Context context;

    public ItemSubTopikQuranAdapter(Context context, List<DataSubTopikQuranItem> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ItemSubTopikQuranAdapter.itemKategoriViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_item_topik_quran, parent, false);
        return new itemKategoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemSubTopikQuranAdapter.itemKategoriViewHolder holder, int position) {
        holder.namaSub.setText(itemList.get(position).getNamasubTema());
        holder.cvSubTema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), IsiTopikQuranActivity.class);
                intent.putExtra("KategoriId", itemList.get(position).getKategoriID());
                intent.putExtra("namaSub", itemList.get(position).getNamasubTema());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class itemKategoriViewHolder extends RecyclerView.ViewHolder {
        TextView namaSub;
        CardView cvSubTema;

        public itemKategoriViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            namaSub = itemView.findViewById(R.id.txtsubTema);
            cvSubTema = itemView.findViewById(R.id.cvSubTema);
        }
    }
}