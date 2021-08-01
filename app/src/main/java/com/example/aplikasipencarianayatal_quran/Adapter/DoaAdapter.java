package com.example.aplikasipencarianayatal_quran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.Model.DataDoaItem;
import com.example.aplikasipencarianayatal_quran.R;

import java.util.List;

public class DoaAdapter extends RecyclerView.Adapter<DoaAdapter.DetailDoaViewHolder> {
    List<DataDoaItem> Doa;
    Context context;

    public DoaAdapter(Context context, List<DataDoaItem> doa) {
        this.context = context;
        Doa = doa;
    }

    @NonNull
    @Override
    public DetailDoaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_doa, parent, false);
        return new DetailDoaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailDoaViewHolder holder, int position) {
        DataDoaItem doa = Doa.get(position);
        holder.namaDoa.setText(doa.getNamaDoa());
        holder.ayahDoa.setText(doa.getDoaText());
        holder.latinDoa.setText(doa.getLatinText());
        holder.terjemahan.setText(doa.getTerjemahan());

        boolean isExpandable = Doa.get(position).isExpandable();
        holder.RelativeLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return Doa.size();
    }

    public class DetailDoaViewHolder extends RecyclerView.ViewHolder {
        TextView namaDoa, ayahDoa, latinDoa, terjemahan;
        android.widget.RelativeLayout RelativeLayout;
        android.widget.LinearLayout LinearLayout;

        public DetailDoaViewHolder(@NonNull View itemView) {
            super(itemView);
            namaDoa = itemView.findViewById(R.id.txtNamaDoa);
            ayahDoa = itemView.findViewById(R.id.txtDoa);
            latinDoa = itemView.findViewById(R.id.txtLatinDoa);
            terjemahan = itemView.findViewById(R.id.txtArtiDoa);
            RelativeLayout = itemView.findViewById(R.id.expandable_Layout_Doa);
            LinearLayout = itemView.findViewById(R.id.LinearLayoutView);

            LinearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DataDoaItem doa = Doa.get(getAdapterPosition());
                    doa.setExpandable(!doa.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
