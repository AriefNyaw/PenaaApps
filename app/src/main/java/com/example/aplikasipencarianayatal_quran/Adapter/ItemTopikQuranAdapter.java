package com.example.aplikasipencarianayatal_quran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.Model.DataTopikQuranItem;
import com.example.aplikasipencarianayatal_quran.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemTopikQuranAdapter extends RecyclerView.Adapter<ItemTopikQuranAdapter.ListKategoriViewHolder> {
    List<DataTopikQuranItem> dataTopikQuranItems;
    Context context;

    public ItemTopikQuranAdapter(Context context, List<DataTopikQuranItem> dataTopikQuranItems) {
        this.dataTopikQuranItems = dataTopikQuranItems;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public ListKategoriViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_topik_quran, parent, false);
        return new ListKategoriViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ItemTopikQuranAdapter.ListKategoriViewHolder holder, int position) {
        holder.namaTema.setText(dataTopikQuranItems.get(position).getNamaTema());

        ItemSubTopikQuranAdapter ItemSubTopikQuranAdapter = new ItemSubTopikQuranAdapter(context, dataTopikQuranItems.get(position).getDataSubTopikQuran());
        holder.rvChildK.setLayoutManager(new LinearLayoutManager(context));
        holder.rvChildK.setAdapter(ItemSubTopikQuranAdapter);
    }

    @Override
    public int getItemCount() {
        return dataTopikQuranItems.size();
    }

    public class ListKategoriViewHolder extends RecyclerView.ViewHolder {
        TextView namaTema;
        RecyclerView rvChildK;

        public ListKategoriViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            namaTema = itemView.findViewById(R.id.txtTema);
            rvChildK = itemView.findViewById(R.id.RvchildKategori);


        }
    }
}
