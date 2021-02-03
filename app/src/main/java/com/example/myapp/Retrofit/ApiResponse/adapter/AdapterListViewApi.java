//package com.example.myapp.Retrofit.ApiResponse.adapter;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import com.bumptech.glide.Glide;
//import com.example.myapp.R;
//import com.example.myapp.Retrofit.ApiResponse.model.Owner;
//
//
//import java.util.ArrayList;
//
//public class AdapterListViewApi extends BaseAdapter {
//    private Context context;
//    private ArrayList<Owner> listOwners = new ArrayList<>();
//    private LayoutInflater inflater;
//
//    public AdapterListViewApi(Context context, ArrayList<Owner> listOwners) {
//        this.context = context;
//        this.listOwners = listOwners;
//        inflater = LayoutInflater.from(context);
//    }
//
//    public AdapterListViewApi(CallApiActivity context, ArrayList<Owner> listOwers) {
//    }
//
//    @Override
//    public int getCount() {
//        return listOwners.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return listOwners.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View view, ViewGroup parent) {
//        Owner owner = listOwners.get(position);
//        if(view == null){
//            view = inflater.inflate(R.layout.call_api, parent, false);
//            ImageView ivCallApi = view.findViewById(R.id.iv_anh);
//            TextView tvCallApi = view.findViewById(R.id.tv_api);
//
//            Glide.with(context).load(owner.getProfileImage()).into(ivCallApi);
//            tvCallApi.setText(owner.getDisplayName());
//
//        }
//        return view;
//    }
//}
