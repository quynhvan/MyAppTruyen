package com.example.myapp.TruyenRecycler.Helper;

import androidx.recyclerview.widget.RecyclerView;

public interface CallBackItemTouch {
    void itemTouchOnMode(int oldPosition, int newPosition);
    void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);

    void onSwiped(RecyclerView.ViewHolder viewHolder, int adapterPosition);
}
