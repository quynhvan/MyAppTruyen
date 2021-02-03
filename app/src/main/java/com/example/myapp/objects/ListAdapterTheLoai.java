package com.example.myapp.objects;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.model.TheLoai;

import java.util.ArrayList;
public class ListAdapterTheLoai extends BaseAdapter {
    private Context context;
    private Fragment fragment;
    private ArrayList<TheLoai> listItems = new ArrayList<>();
    private LayoutInflater inflater;

    public ListAdapterTheLoai(Context context, ArrayList<TheLoai> listItems) {
        this.context = context;
        this.listItems = listItems;

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
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        final TheLoai theLoai = listItems.get(position);
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null)
        {
             view = inflater.inflate(R.layout.activity_the_loai,viewGroup,false);

             ImageView ivAnh = view.findViewById(R.id.iv_anh);
             TextView tvTitle = view.findViewById(R.id.tv_the_loai);
             TextView tvSize = view.findViewById(R.id.tv_size);

             ivAnh.setImageResource(theLoai.getIdImage());
             tvTitle.setText(theLoai.getTitle());
             tvSize.setText(theLoai.getDsTruyen().size()+"");
        }

        return view;
    }
}

