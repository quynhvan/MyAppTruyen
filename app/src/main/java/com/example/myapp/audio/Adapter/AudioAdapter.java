package com.example.myapp.audio.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.model.TruyenAudio;

import java.util.ArrayList;

public class AudioAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflater;
    private ArrayList<TruyenAudio> listTruyen;
    private int idTruyen;

    public AudioAdapter(Context context,ArrayList<TruyenAudio> listTruyen) {
        this.context = context;
        this.listTruyen = listTruyen;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return listTruyen.size();
    }

    @Override
    public Object getItem(int position) {
        return listTruyen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        TruyenAudio truyen = listTruyen.get(position);
        if(view == null){
            view = inflater.inflate(R.layout.truyen_audio,parent,false);
            ImageView ivAnh = view.findViewById(R.id.iv_anh_audio);
            TextView tvTitle = view.findViewById(R.id.tv_title);

            ivAnh.setImageResource(truyen.getIdImage());
            tvTitle.setText(truyen.getTitle());
        }
        return view;
    }
}