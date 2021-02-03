package com.example.myapp.TruyenRecycler.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapp.Constants;
import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.model.Truyen;
import com.example.myapp.TruyenRecycler.model.TruyenDetail;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener;

public class ActivityTruyenDetail extends AppCompatActivity {
    private Truyen truyenDetail;
    FloatingActionButton fab_add, fab_share, fab_love;
//    Animation fabOpen, fabClose, fabRotateClock, fabRotateAntiClock;
    boolean isOpen = false;
    boolean isLove = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trang_truyen_chi_tiet);
        initData();
        initView();
    }
    private void initData() {
        Intent intent = getIntent();
        truyenDetail = intent.getParcelableExtra(Constants.KEY_TRUYEN_DETAIL);
    }
    public void initView() {
        ImageView ivAnh = findViewById(R.id.iv_truyen);
        TextView tvTitle = findViewById(R.id.tv_title);
        TextView tvContent = findViewById(R.id.tv_content);
//        fab_add = (FloatingActionButton) findViewById(R.id.btn_add);
//        fab_share = findViewById(R.id.btn_share);
//        fab_love = findViewById(R.id.btn_circle_love);
//
//        fabRotateClock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_closewise);
//        fabRotateAntiClock = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_anticlockwise);
//
        ivAnh.setImageResource(truyenDetail.getIdImage());
        tvTitle.setText(truyenDetail.getTitle());
        tvContent.setText(truyenDetail.getContent());
//        fab_add.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fabAdd();
//            }
//        });
//
//        fab_share.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(ActivityTruyenDetail.this, "You Click on Share", Toast.LENGTH_SHORT).show();
//            }
//        });
//        fab_love.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(isLove){
//                    fab_love.setImageResource(R.drawable.ic_love_selectedpng);
//                    Toast.makeText(ActivityTruyenDetail.this, "Đã thêm vào danh sách truyện yêu thích", Toast.LENGTH_SHORT).show();
//                    isLove= false;
//                }
//                else {
//                    fab_love.setImageResource(R.drawable.ic_love_white);
//                    Toast.makeText(ActivityTruyenDetail.this, "Đã loại bỏ khỏi danh sách truyện yêu thích", Toast.LENGTH_SHORT).show();
//                    isLove= true;
//                }
//
//
//            }
//        });
    }

//    public void fabAdd() {
//        if (isOpen) {
////            fab_love.startAnimation(fabClose);
////            fab_share.startAnimation(fabClose);
//            fab_share.hide();
//            fab_love.hide();
//            fab_add.startAnimation(fabRotateAntiClock);
//            fab_share.setClickable(false);
//            fab_love.setClickable(false);
//
//            isOpen = false;
//        } else {
////            fab_love.startAnimation(fabOpen);
////            fab_share.startAnimation(fabOpen);
//            fab_love.show();
//            fab_share.show();
//
//            fab_add.startAnimation(fabRotateClock);
//            fab_share.setClickable(true);
//            fab_love.setClickable(true);
//
//            isOpen = true;
//        }
//    }
//    public void fabShare() {
//        Toast.makeText(this, "You Click on Share", Toast.LENGTH_SHORT).show();
//    }
//
//    public void fabLove() {
//        Toast.makeText(this, "You Click on Favourite", Toast.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public void onClick(View v) {
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btn_add:
//                fabAdd();
//                break;
//            case R.id.btn_circle_love:
//                fabLove();
//                break;
//            case R.id.btn_share:
//                fabShare();
//                break;
//        }
//    }
}
