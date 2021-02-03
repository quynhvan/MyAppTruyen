package com.example.myapp.TruyenRecycler;

import android.content.Context;
import android.graphics.drawable.Drawable;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MydividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int[] ART = new int[]{
            android.R.attr.listDivider

    };
    public static final int Horizontal_List = LinearLayoutManager.HORIZONTAL;
    public static final int Vertical_List = LinearLayoutManager.VERTICAL;

    private Drawable myDivider;
    private int myOrientation;
    private Context context;
    private int margin;

    // constructor

    public MydividerItemDecoration(Drawable myDivider, int myOrientation, Context context, int margin) {
        this.myDivider = myDivider;
        this.myOrientation = myOrientation;
        this.context = context;
        this.margin = margin;
    }
}
