//package com.example.myapp.TruyenRecycler.Navigation;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.widget.Toolbar;
//import androidx.drawerlayout.widget.DrawerLayout;
//
//import android.os.Bundle;
//import android.widget.GridView;
//
//import com.example.myapp.R;
//import com.google.android.material.navigation.NavigationView;
//
//public class NavigationDrawer extends AppCompatActivity {
//    Toolbar toolbar;
//    DrawerLayout drawerLayout;
//    NavigationView navigationView;
//    GridView gridViewMenu;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_navigation_drawer);
//        initView();
//    }
//    public void initView(){
//        toolbar = findViewById(R.id.toolbar);
//        drawerLayout = findViewById(R.id.layout_drawer);
//        gridViewMenu = findViewById(R.id.gv_menu);
//        navigationView = findViewById(R.id.navigation);
//    }
//}