package com.example.myapp.TruyenRecycler.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.Constants;
import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.Adapter.AdapterTruyen;
import com.example.myapp.TruyenRecycler.model.Truyen;
import com.example.myapp.TruyenRecycler.model.TruyenDetail;

import java.util.ArrayList;

public class ActivityTruyen extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterTruyen adapterTruyen;
    private ArrayList<Truyen> dsTruyen = new ArrayList<>();
    private String title;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_truyen);
        initData();
        initView();
        initShow();
    }
    public void initShow() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapterTruyen = new AdapterTruyen(ActivityTruyen.this, dsTruyen, new AdapterTruyen.OnItemClickListenerTruyen() {
            @Override
            public void onItemClickTruyen(int position) {
                Truyen truyen = dsTruyen.get(position);
                Intent intent = new Intent(ActivityTruyen.this, ActivityTruyenDetail.class);
                intent.putExtra(Constants.KEY_TRUYEN_DETAIL,truyen);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapterTruyen);
    }

    public void initView() {
        recyclerView = findViewById(R.id.re_truyen);
    }

    public void initData() {
        Intent intent = getIntent();
        dsTruyen = intent.getParcelableArrayListExtra(Constants.KEY_DS_TRUYEN);
    }
}


