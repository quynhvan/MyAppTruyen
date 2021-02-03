package com.example.myapp.TruyenRecycler.Activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.myapp.R;
import com.example.myapp.TruyenRecycler.Adapter.AdapterMenu;
import com.example.myapp.TruyenRecycler.Fragments.FragmentShare;
import com.example.myapp.TruyenRecycler.Fragments.FragmentTruyenAudio;
import com.example.myapp.TruyenRecycler.Fragments.FragmentTruyenCoTich;
import com.example.myapp.TruyenRecycler.Fragments.FragmentTruyenYeuThich;
import com.example.myapp.TruyenRecycler.Adapter.ViewPagerAdapter;
import com.example.myapp.TruyenRecycler.model.ItemMenu;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main extends AppCompatActivity implements TabLayout.BaseOnTabSelectedListener, TabLayout.OnTabSelectedListener, NavigationView.OnNavigationItemSelectedListener {
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter viewPagerAdapter;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ArrayList<ItemMenu> listItemMenu = new ArrayList<>();
    private AdapterMenu adapterMenu;
    private ConstraintLayout wrapContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        initView();
        actionToolBar();
        this.addPages();

        FragmentManager manager = getSupportFragmentManager();
        viewPagerAdapter = new ViewPagerAdapter(manager);

        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

    // function tạo sự kiện khi click vào
    private void actionToolBar() {
        // hàm hỗ trợ toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // gán cho icon
        toolbar.setNavigationIcon(R.drawable.ic_menu);
        // tạo sự kiện click vào icon hiện ra menu
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    public void initView() {
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.layout_drawer);
        navigationView = findViewById(R.id.navigation);

        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.viewPager, new FragmentShare()).commit();
        navigationView.setCheckedItem(R.id.nav_share);


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }

    private void addPages() {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentTruyenCoTich());
        viewPagerAdapter.addFragment(new FragmentTruyenAudio());
//        viewPagerAdapter.addFragment(new FragmentTruyenYeuThich());
        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        tabLayout = findViewById(R.id.tabLayout);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_trangchu:
                break;

        }
        return true;
    }
}
