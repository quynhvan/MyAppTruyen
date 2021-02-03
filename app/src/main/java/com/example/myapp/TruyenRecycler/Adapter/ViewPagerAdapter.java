package com.example.myapp.TruyenRecycler.Adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private final ArrayList<Fragment> lstFragment = new ArrayList<>();
    private final List<String> lstTitle = new ArrayList<>();
    int tabCounts;
    // constructor
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lstFragment.get(position);
//        switch (position) {
//            case 0:
//                return new FragmentTruyenYeuThich();
//            case 1:
//                return new FragmentTruyenAudio();
//            case 2:
//                return new FragmentTruyenYeuThich();
//            default:
//                return null;
//        }
    }

    @Override
    public int getCount() {
        return lstFragment.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {

        String title = "";
        switch (position) {
            case 0:
                title = "Cổ tích";
                break;
            case 1:
                title = "Audio";
                break;
            case 2:
                title = "Yêu thích";
                break;
        }
        return title;
    }
    public void addFragment(Fragment f){
        lstFragment.add(f);
    }
}
