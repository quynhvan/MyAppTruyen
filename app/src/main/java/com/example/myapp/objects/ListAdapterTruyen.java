package com.example.myapp.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.model.Truyen;

import java.util.ArrayList;

public class ListAdapterTruyen extends BaseAdapter{
    private Context context;
    private ArrayList<Truyen> listItems = new ArrayList<>();
    private LayoutInflater inflater;

    public ListAdapterTruyen(Context context,ArrayList<Truyen> listItems){
        this.context = context;
        this.listItems = listItems;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position ;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        Truyen dsTruyen = listItems.get(position);
        if(view == null){
            view = inflater.inflate(R.layout.activity_truyen,viewGroup,false);

            ImageView ivAnh = view.findViewById(R.id.iv_anh);
            TextView tvTitle = view.findViewById(R.id.tv_title);
            TextView tvContent = view.findViewById(R.id.tv_content);

            ivAnh.setImageResource(dsTruyen.getIdImage());
            tvTitle.setText(dsTruyen.getTitle());
            tvContent.setText(dsTruyen.getContent());
        }
        return view;
    }
}

