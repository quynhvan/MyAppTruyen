package com.example.myapp.Retrofit.pratice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.R;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;

public class AdapterApi extends RecyclerView.Adapter<AdapterApi.MyViewHolder>{
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Owner> listOwner;
    private OnClickItemListener onClickItemListner;

    public AdapterApi(Context context, ArrayList<Owner> listOwner) {
        this.context = context;
        this.listOwner = listOwner;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.call_api,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Owner owner = listOwner.get(position);
        Glide.with(context).load(owner.getProfileImage()).into(holder.ivAnh);
        holder.tvTitle.setText(owner.getDisplayName());
    }

    @Override
    public int getItemCount() {
        return listOwner.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivAnh;
        private TextView tvTitle;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivAnh = itemView.findViewById(R.id.iv_anh);
            tvTitle = itemView.findViewById(R.id.tv_api);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItemListner.onItemClickApi(getAdapterPosition());
                }
            });
        }
    }
    public void setOnClickItemListener(OnClickItemListener onClickItemListner){
        this.onClickItemListner = onClickItemListner;
    }
    public interface OnClickItemListener{
        void onItemClickApi(int position);
    }
}
