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
import com.example.myapp.TruyenRecycler.model.TheLoai;

import java.util.ArrayList;

public class AdapterTheLoai extends RecyclerView.Adapter<AdapterTheLoai.MyViewHolder>  {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<TheLoai> listTheLoai;
    private OnItemClickTheLoai onItemClickTheLoai;


    public AdapterTheLoai(Context context, ArrayList<TheLoai> listTheLoai, OnItemClickTheLoai onItemClickTheLoai) {
        this.context = context;
        this.listTheLoai = listTheLoai;
        inflater = LayoutInflater.from(context);
        this.onItemClickTheLoai = onItemClickTheLoai;
    }
    @NonNull
    @Override
    // tạo đối tượng ViewHolder , trong đó chứa View hiển thị dữ liệu
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Nạp layout cho View
        View view = inflater.inflate(R.layout.the_loai,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    // Chuyển dữ liệu phần tử vào ViewHolder
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        TheLoai theLoai = listTheLoai.get(position);
        holder.ivAnh.setImageResource(theLoai.getIdImage());
        holder.tvTitle.setText(theLoai.getTitle());
        holder.tvSize.setText(theLoai.getDsTruyen().size()+"");
    }

    @Override
    public int getItemCount() {
        return listTheLoai.size();
    }

    // Lớp nắm giữ cấu trúc View
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAnh;
        private TextView tvTitle;
        private TextView tvSize;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAnh = itemView.findViewById(R.id.iv_anh);
            tvTitle = itemView.findViewById(R.id.tv_the_loai);
            tvSize = itemView.findViewById(R.id.tv_size);
            context = itemView.getContext();
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickTheLoai.onClickTheLoai(getAdapterPosition());
                }
            });
        }
    }
    public interface OnItemClickTheLoai{
        void onClickTheLoai(int position);
    }
}


