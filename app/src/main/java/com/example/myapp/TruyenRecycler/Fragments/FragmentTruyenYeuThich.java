package com.example.myapp.TruyenRecycler.Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.Adapter.AdapterTruyenYeuThich;
import com.example.myapp.TruyenRecycler.CallBacks.MyItemTouchHelperCallBack;
import com.example.myapp.TruyenRecycler.Helper.CallBackItemTouch;
import com.example.myapp.TruyenRecycler.model.Truyen;
import com.example.myapp.TruyenRecycler.model.TruyenAudio;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;


public class FragmentTruyenYeuThich extends Fragment implements CallBackItemTouch{
    private ArrayList<Truyen> listTruyen = new ArrayList<>();
    private ArrayList<TruyenAudio> listAudio = new ArrayList<>();
    private RecyclerView recyclerView;
    private AdapterTruyenYeuThich adapterTruyenYeuThich;
    private ConstraintLayout layout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_yeu_thich, container,false);
        recyclerView = view.findViewById(R.id.re_truyen_yeu_thich);
        layout = view.findViewById(R.id.layout_main_activity);
        initData();
        initViews();

        return view;
    }

    public void initData() {
        listTruyen.add(new Truyen(R.drawable.ngungon01, "Đàn kiến đền ơn", R.string.dan_kien_tra_on));
        listTruyen.add(new Truyen(R.drawable.ngungon01, "Đàn kiến đền ơn", R.string.dan_kien_tra_on));
        listTruyen.add(new Truyen(R.drawable.ngungon02, "Thầy tu rởm",R.string.thay_tu_rom));
        listTruyen.add(new Truyen(R.drawable.ngungon03, "Tình bạn của rái cá", R.string.tinh_ban_cua_rai_ca));
        listTruyen.add(new Truyen(R.drawable.ngungon04, "Vẹt và châu chấu", R.string.vet_va_chau_chau));
        listTruyen.add(new Truyen(R.drawable.ngungon05, "Chim sơn ca", R.string.chim_son_ca));
        listTruyen.add(new Truyen(R.drawable.ngungon06, "Heo rừng và thỏ", R.string.heo_rung_va_tho));
    }
    public void initViews(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapterTruyenYeuThich = new AdapterTruyenYeuThich(getContext(),listTruyen);
        recyclerView.setAdapter(adapterTruyenYeuThich);
        ItemTouchHelper.Callback callback = new MyItemTouchHelperCallBack(this);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void itemTouchOnMode(int oldPosition, int newPosition) {
        listTruyen.add(newPosition, listTruyen.remove(oldPosition));
        adapterTruyenYeuThich.notifyItemMoved(oldPosition,newPosition);
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int adapterPosition) {
    String title = listTruyen.get(viewHolder.getAdapterPosition()).getTitle();

    // backup del item
    final Truyen deletedItem = listTruyen.get(viewHolder.getAdapterPosition());
    final int deletedIndex = viewHolder.getAdapterPosition();
    // remover item del recycler
    adapterTruyenYeuThich.removeItem(viewHolder.getAdapterPosition());
    Snackbar snackbar = Snackbar.make(layout,title+"=> Đã bị xóa khỏi danh sách yêu thích",Snackbar.LENGTH_SHORT);
    snackbar.setAction("CANCEL/UNDO", new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            adapterTruyenYeuThich.restoreItem(deletedItem,deletedIndex);
        }
    });
    snackbar.setActionTextColor(Color.YELLOW);
    snackbar.show();
    }


}