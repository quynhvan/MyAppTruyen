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
import com.example.myapp.TruyenRecycler.model.Truyen;

import java.util.ArrayList;

public class AdapterTruyen extends RecyclerView.Adapter<AdapterTruyen.MyViewHolder> {
    private ArrayList<Truyen> listTruyen ;
    private Context context;
    private LayoutInflater inflater;
    private OnItemClickListenerTruyen onItemClickListenerTruyen;

    public AdapterTruyen( Context context, ArrayList<Truyen> listTruyen, OnItemClickListenerTruyen onItemClickListenerTruyen) {
        this.listTruyen = listTruyen;
        this.context = context;
        this.onItemClickListenerTruyen = onItemClickListenerTruyen;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_truyen,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Truyen truyen = listTruyen.get(position);
        holder.ivAnh.setImageResource(truyen.getIdImage());
        holder.tvTitle.setText(truyen.getTitle());
        holder.tvContent.setText(truyen.getContent());
    }

    @Override
    public int getItemCount() {
        return listTruyen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivAnh;
        private TextView tvTitle;
        private TextView tvContent;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAnh = itemView.findViewById(R.id.iv_anh);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListenerTruyen.onItemClickTruyen(getAdapterPosition());
                }
            });

        }
    }
    public void setOnItemClickListenerTruyen(OnItemClickListenerTruyen onItemClickListenerTruyen){
        this.onItemClickListenerTruyen = onItemClickListenerTruyen;
    }
    public interface OnItemClickListenerTruyen{
        void onItemClickTruyen(int position);
    }
}
