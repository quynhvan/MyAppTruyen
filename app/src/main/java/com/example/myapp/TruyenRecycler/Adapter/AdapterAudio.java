package com.example.myapp.TruyenRecycler.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.model.TruyenAudio;

import java.util.ArrayList;

public class AdapterAudio extends RecyclerView.Adapter<AdapterAudio.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<TruyenAudio> listTruyen;
    private OnItemClickListenerAudio onItemClickListenerAudio;

    public AdapterAudio(Context context, ArrayList<TruyenAudio> listTruyen, OnItemClickListenerAudio onItemClickListenerAudio) {
        this.context = context;
        this.listTruyen = listTruyen;
        inflater = LayoutInflater.from(context);
        this.onItemClickListenerAudio = onItemClickListenerAudio;
    }

    @NonNull
    @Override
    public AdapterAudio.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.truyen_audio,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAudio.MyViewHolder holder, int position) {
        TruyenAudio truyenAudio = listTruyen.get(position);
        holder.ivAnh.setImageResource(truyenAudio.getIdImage());
        holder.tvTitle.setText(truyenAudio.getTitle());
    }

    @Override
    public int getItemCount() {
        return listTruyen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAnh;
        private TextView tvTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAnh = itemView.findViewById(R.id.iv_anh_audio);
            tvTitle = itemView.findViewById(R.id.tv_title);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListenerAudio.OnItemClickAudio(getAdapterPosition());
                }
            });

        }
    }
    public void setOnItemClickListenerAudio(OnItemClickListenerAudio onItemClickListenerAudio){
        this.onItemClickListenerAudio = onItemClickListenerAudio;
    }
    public interface OnItemClickListenerAudio{
        void OnItemClickAudio(int position);
    }

}
