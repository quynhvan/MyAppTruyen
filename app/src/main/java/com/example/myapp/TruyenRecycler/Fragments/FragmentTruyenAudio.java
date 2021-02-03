package com.example.myapp.TruyenRecycler.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapp.Constants;
import com.example.myapp.R;

import com.example.myapp.TruyenRecycler.model.TruyenAudio;
import com.example.myapp.TruyenRecycler.Activity.ActivityTruyenAudioDetail;
import com.example.myapp.TruyenRecycler.Adapter.AdapterAudio;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 **/
public class FragmentTruyenAudio extends Fragment  {
    private AdapterAudio adapterAudio;
    public static ArrayList<TruyenAudio> dsTruyenAudio = new ArrayList<>();
    private RecyclerView recyclerView;
    private int REQUEST_CODE = 100;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.recyclerview_truyen_audio, container, false);
        recyclerView = view.findViewById(R.id.re_audio);
        initDSTruyenAudio();
        initShow();
        return view;
    }
    private void initShow(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
    public void initDSTruyenAudio() {
        adapterAudio = new AdapterAudio(getContext(), dsTruyenAudio, new AdapterAudio.OnItemClickListenerAudio() {
            @Override
            public void OnItemClickAudio( int position) {
                TruyenAudio truyen = dsTruyenAudio.get(position);
                Intent intent = new Intent(getContext(), ActivityTruyenAudioDetail.class);
                intent.putExtra(Constants.KEY_POSITION_TRUYEN_AUDIO,position);
//                intent.putParcelableArrayListExtra(Constants.KEY_LIST_PAGE_AUDIO,dsTruyen);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        recyclerView.setAdapter(adapterAudio);

        dsTruyenAudio.add(new TruyenAudio(R.drawable.audio_ai_mua_hanh_toi, R.raw.ai_mua_hanh_toi,"Ai mua hành tôi",false));
        dsTruyenAudio.add(new TruyenAudio(R.drawable.audio_an_khe_tra_vang, R.raw.an_khe_tra_vang,"Ăn khế trả vàng",false));
        dsTruyenAudio.add(new TruyenAudio(R.drawable.audio_ba_chua_tuyet, R.raw.ba_chua_tuyet,"Bà chúa tuyết",false));
        dsTruyenAudio.add(new TruyenAudio(R.drawable.audio_co_be_ban_diem, R.raw.co_be_ban_diem,"Cô bé bán diêm",false));
        dsTruyenAudio.add(new TruyenAudio(R.drawable.audio_co_be_lo_lem,R.raw.co_be_lo_lem, "Cô bé lọ lem",false));
        dsTruyenAudio.add(new TruyenAudio(R.drawable.audio_co_be_ti_hon2, R.raw.co_be_ti_hon,"Cô bé tí hon",false));
        dsTruyenAudio.add(new TruyenAudio(R.drawable.audio_coc_kien_troi,R.raw.coc_kien_troi, "Cóc kiện trời",false));
        dsTruyenAudio.add(new TruyenAudio(R.drawable.audio_nguoi_con_hieu_thao1,R.raw.nguoi_con_hieu_thao, "Người con hiếu thảo",false));
        dsTruyenAudio.add(new TruyenAudio(R.drawable.audio_so_dua, R.raw.so_dua,"Sọ dừa",false));
        adapterAudio.notifyDataSetChanged();
    }
}
