package com.example.aplikasipencarianayatal_quran.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplikasipencarianayatal_quran.Model.Message;
import com.example.aplikasipencarianayatal_quran.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PesanAdapter extends RecyclerView.Adapter<PesanAdapter.PesanViewHolder> {
    List<Message> messageList;
    Context context;

    public PesanAdapter(Context context, List<Message> messageList) {
        this.messageList = messageList;
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public PesanViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_detail_dialogflow, parent, false);
        return new PesanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull PesanAdapter.PesanViewHolder holder, int position) {
        String message = messageList.get(position).getMessage();
        boolean IsReceived = messageList.get(position).getIsReceived();

        if (IsReceived) {
            holder.chatReceive.setVisibility(View.VISIBLE);
            holder.chatSend.setVisibility(View.GONE);
            holder.chatReceive.setText(message);
        } else {
            holder.chatSend.setVisibility(View.VISIBLE);
            holder.chatReceive.setVisibility(View.GONE);
            holder.chatSend.setText(message);
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    public class PesanViewHolder extends RecyclerView.ViewHolder {
        TextView chatSend, chatReceive;

        public PesanViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            chatSend = itemView.findViewById(R.id.message_send);
            chatReceive = itemView.findViewById(R.id.message_receive);
        }
    }
}
