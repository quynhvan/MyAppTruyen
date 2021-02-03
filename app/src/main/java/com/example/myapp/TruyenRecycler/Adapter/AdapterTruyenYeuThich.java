package com.example.myapp.TruyenRecycler.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.model.Truyen;
import com.example.myapp.TruyenRecycler.model.TruyenAudio;

import java.util.ArrayList;

public class AdapterTruyenYeuThich extends RecyclerView.Adapter<AdapterTruyenYeuThich.MyViewHolder> {
    private Context context;
    private ArrayList<Truyen> listTruyen;
    private ArrayList<TruyenAudio> listAudio;
    private LayoutInflater inflater;

    public AdapterTruyenYeuThich(Context context, ArrayList<Truyen> listTruyen) {
        this.context = context;
        this.listTruyen = listTruyen;
//        this.listAudio = listAudio;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterTruyenYeuThich.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_list_item_truyen_yeu_thich,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterTruyenYeuThich.MyViewHolder holder, int position) {
        Truyen truyen = listTruyen.get(position);
        holder.tvTitle.setText(truyen.getTitle());
        holder.tvDescription.setText(truyen.getContent());
        holder.ivThumbnail.setImageResource(truyen.getIdImage());
//        holder.tvCategory.setText(truyen.getCategory());

//        TruyenAudio truyenAudio = listAudio.get(position);
//        holder.tvTitle.setText(truyenAudio.getTitle());
//        holder.tvCategory.setText(truyenAudio.getCategory());
    }

    @Override
    public int getItemCount() {
        return listTruyen.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle, tvDescription, tvCategory;
        public ImageView ivThumbnail;
        public RelativeLayout viewBackground, viewForeground;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            ivThumbnail = itemView.findViewById(R.id.iv_thumbnail);
            tvCategory = itemView.findViewById(R.id.tv_category);
            viewBackground = itemView.findViewById(R.id.view_background);
            viewForeground = itemView.findViewById(R.id.view_foreground);
        }
    }
    public void removeItem(int position){
        listTruyen.remove(position);
        notifyItemRemoved(position);
    }
    public void restoreItem(Truyen truyen, int position){
        listTruyen.add(position, truyen);
//        listAudio.add(position,audio);
        notifyItemInserted(position);
    }
}
