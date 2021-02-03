package com.example.myapp.RecycleView;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {
    private AdapterRecycler adapterRecycler;
    private RecyclerView re;
    private ArrayList<Song> listSong = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_list);
        initView();
        initHienThi();
        initData();
        initEvent();
    }

    private void initHienThi() {
        // recyclerview cần xác định rõ layout manager
        // nó sẽ quy định kiểu hiện thị la list theo chiều dọc hay chiều ngang
        //layout manager quy định chiều hiển thị

        // mặc định như dòng dưới là theo chiều dọc
         LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);

        // này là chiều ngang
        // LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);

        // dạng lưới giống gridview, spanCount là số cột
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);

        re.setLayoutManager(linearLayoutManager);
    }

    private void initView() {
        //anh xa view
        re = findViewById(R.id.re_song);
    }

    private void initData() {
        //khởi tạo adapter
        adapterRecycler = new AdapterRecycler(RecyclerActivity.this, listSong);
        re.setAdapter(adapterRecycler);

        //tạo dữ liệu

        listSong.add(new Song("Nu than ai cap", "content1", R.drawable.hyla07));
        listSong.add(new Song("Nu than ai cap 2", "content1", R.drawable.hylap01));
        listSong.add(new Song("Nu than ai cap 3", "content1", R.drawable.hylap02));
        listSong.add(new Song("Nu than ai cap 4", "content1", R.drawable.hylap03));
        listSong.add(new Song("Nu than ai cap 5", "content1", R.drawable.hylap04));
        listSong.add(new Song("Nu than ai cap 6", "content1", R.drawable.hylap05));
        listSong.add(new Song("Nu than ai cap 7", "content1", R.drawable.hylap06));
        listSong.add(new Song("Nu than ai cap 8", "content1", R.drawable.hyla07));
        listSong.add(new Song("Nu than ai cap 9", "content1", R.drawable.hylap08));
        listSong.add(new Song("Nu than ai cap 10", "content1", R.drawable.hylap09));
        listSong.add(new Song("Nu than ai cap 11", "content1", R.drawable.hylap10));
        listSong.add(new Song("Nu than ai cap 12", "content1", R.drawable.hyla07));

        adapterRecycler.notifyDataSetChanged();
    }

    private void initEvent() {
        adapterRecycler.setOnItemClickListener(new AdapterRecycler.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(RecyclerActivity.this, "Click!" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
