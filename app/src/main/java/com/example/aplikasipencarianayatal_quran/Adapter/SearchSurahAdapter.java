package com.example.aplikasipencarianayatal_quran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.Model.DataPencarianSurahItem;
import com.example.aplikasipencarianayatal_quran.R;

import java.util.List;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class SearchSurahAdapter extends RecyclerView.Adapter<SearchSurahAdapter.SearchSurahViewHolder> {
    List<DataPencarianSurahItem> searchItem;
    Context context;

    public SearchSurahAdapter(Context context, List<DataPencarianSurahItem> SearchItem) {
        this.searchItem = SearchItem;
        this.context = context;
    }

    @NonNull
    @Override
    public SearchSurahViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_search, parent, false);
        return new SearchSurahViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchSurahViewHolder holder, int position) {
        DataPencarianSurahItem search = searchItem.get(position);
        holder.namasurahsearch.setText(search.getNamaSurah());
        holder.jlmhhasilsearch.setText(search.getTotal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search.setExpandable(!search.isExpandable());
                notifyItemChanged(position);

                SearchSurahChildAdapter childAdapter = new SearchSurahChildAdapter(context, search.getDetailCariSurah());
                holder.RvChild.setLayoutManager(new LinearLayoutManager(context));
                holder.RvChild.setAdapter(childAdapter);

            }
        });

        boolean isExpandable = searchItem.get(position).isExpandable();
        holder.RelativeLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return searchItem.size();
    }

    public class SearchSurahViewHolder extends RecyclerView.ViewHolder {
        TextView namasurahsearch, jlmhhasilsearch, nomorsearch, artiayatsearch;
        ImageView arrowIcon;
        RecyclerView RvChild;
        RelativeLayout RelativeLayout;
        LinearLayout LinearLayout;

        public SearchSurahViewHolder(@NonNull View itemView) {
            super(itemView);
            arrowIcon = itemView.findViewById(R.id.iconArrow);
            RvChild = itemView.findViewById(R.id.Rvchild);
            namasurahsearch = itemView.findViewById(R.id.txtNamaSurahSearch);
            jlmhhasilsearch = itemView.findViewById(R.id.txtjumlhhasil);
            nomorsearch = itemView.findViewById(R.id.txtNomorSearch);
            artiayatsearch = itemView.findViewById(R.id.txtArtiAyatSearch);
            RelativeLayout = itemView.findViewById(R.id.expandable_Layout_Ayat);
            LinearLayout = itemView.findViewById(R.id.LinearLayoutSearch);
        }
    }
}
