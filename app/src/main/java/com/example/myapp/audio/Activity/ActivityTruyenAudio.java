//package com.example.myapp.audio.Activity;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.GridView;
//
//import com.example.myapp.Constants;
//import com.example.myapp.R;
//import com.example.myapp.audio.Adapter.AudioAdapter;
//import com.example.myapp.TruyenRecycler.model.TruyenAudio;
//
//import java.util.ArrayList;
//
//public class ActivityTruyenAudio extends AppCompatActivity {
//    static ArrayList<TruyenAudio> dsTruyen = new ArrayList<>();
//    private GridView gridView;
//    private AudioAdapter audioAdapter;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.gridview_audio);
//        initShow();
//        initDSTruyenAudi();
//        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(ActivityTruyenAudio.this, TruyenAudioProcess.class);
//                intent.putExtra(Constants.KEY_POSITION_TRUYEN_AUDIO,position);
////                intent.putParcelableArrayListExtra(Constants.KEY_LIST_PAGE_AUDIO,dsTruyen);
//                startActivity(intent);
//            }
//        });
//    }
//    private void initShow(){
//        gridView = findViewById(R.id.gv_audio);
//    }
//    public void initDSTruyenAudi() {
//        audioAdapter = new AudioAdapter(ActivityTruyenAudio.this,dsTruyen);
//        gridView.setAdapter(audioAdapter);
//
//        dsTruyen.add(new TruyenAudio(R.drawable.audio_ai_mua_hanh_toi, R.raw.ai_mua_hanh_toi,"Ai mua hành tôi",false));
//        dsTruyen.add(new TruyenAudio(R.drawable.audio_an_khe_tra_vang, R.raw.an_khe_tra_vang,"Ăn khế trả vàng",false));
//        dsTruyen.add(new TruyenAudio(R.drawable.audio_ba_chua_tuyet, R.raw.ba_chua_tuyet,"Bà chúa tuyết",false));
//        dsTruyen.add(new TruyenAudio(R.drawable.audio_co_be_ban_diem, R.raw.co_be_ban_diem,"Cô bé bán diêm",false));
//        dsTruyen.add(new TruyenAudio(R.drawable.audio_co_be_lo_lem,R.raw.co_be_lo_lem, "Cô bé lọ lem",false));
//        dsTruyen.add(new TruyenAudio(R.drawable.audio_co_be_ti_hon2, R.raw.co_be_ti_hon,"Cô bé tí hon",false));
//        dsTruyen.add(new TruyenAudio(R.drawable.audio_coc_kien_troi,R.raw.coc_kien_troi, "Cóc kiện trời",false));
//        dsTruyen.add(new TruyenAudio(R.drawable.audio_nguoi_con_hieu_thao1,R.raw.nguoi_con_hieu_thao, "Người con hiếu thảo",false));
//        dsTruyen.add(new TruyenAudio(R.drawable.audio_so_dua, R.raw.so_dua,"Sọ dừa",false));
//        audioAdapter.notifyDataSetChanged();
//    }
//}
