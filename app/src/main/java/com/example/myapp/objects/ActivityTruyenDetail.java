//package com.example.myapp.objects;
//
//import android.os.Bundle;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.myapp.Constants;
//import com.example.myapp.R;
//import com.example.myapp.TruyenRecycler.model.Truyen;
//
//public class ActivityTruyenDetail extends AppCompatActivity {
//    private Truyen truyenDetail;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.trang_truyen_chi_tiet);
//        initData();
//        initView();
//    }
//    public void initData(){
//        truyenDetail =  getIntent().getParcelableExtra(Constants.KEY_TRUYEN_DETAIL);
//    }
//    public void initView(){
//        TextView tvContent = findViewById(R.id.tv_content);
//        TextView tvTitle = findViewById(R.id.tv_title);
//        ImageView ivThumbnail = findViewById(R.id.iv_truyen);
//
//        tvContent.setText(truyenDetail.getContent());
//        tvTitle.setText(truyenDetail.getTitle());
//        ivThumbnail.setImageResource(truyenDetail.getIdImage());
//    }
//}
