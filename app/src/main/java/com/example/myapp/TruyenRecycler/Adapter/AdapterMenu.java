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
import com.example.myapp.TruyenRecycler.model.ItemMenu;

import java.util.ArrayList;

public class AdapterMenu extends RecyclerView.Adapter<AdapterMenu.MyViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<ItemMenu> listItemMenu;

    public AdapterMenu(Context context, ArrayList<ItemMenu> listItemMenu) {
        this.context = context;
        this.listItemMenu = listItemMenu;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_menu,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        ItemMenu item = listItemMenu.get(position);
        holder.tvItem.setText(item.getTenItem());
        holder.ivItem.setImageResource(item.getIcon());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView ivItem;
        TextView tvItem;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
             ivItem = itemView.findViewById(R.id.tv_item);
             tvItem = itemView.findViewById(R.id.iv_menu);

        }
    }
}
