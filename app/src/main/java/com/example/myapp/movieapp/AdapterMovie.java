package com.example.myapp.movieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapp.R;

import java.util.ArrayList;

public class AdapterMovie extends RecyclerView.Adapter<AdapterMovie.MyViewHolder> {
    private static final String BASE_IMAGE_URL = "https://image.tmdb.org/t/p/w500";
    private Context context;
    private ArrayList<Movie> listMovie;
    private LayoutInflater inflater;
    private OnClickItemMovie onClickItemMovie;

    public AdapterMovie(Context context, ArrayList<Movie> listMovie,OnClickItemMovie onClickItemMovie) {
        this.context = context;
        this.listMovie = listMovie;
        this.onClickItemMovie = onClickItemMovie;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public AdapterMovie.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragment_movie,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterMovie.MyViewHolder holder, int position) {
        Movie movie = listMovie.get(position);
        Glide.with(context).load(BASE_IMAGE_URL + movie.getBackdropPath()).into(holder.ivMovie);
        holder.tvTitle.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return listMovie.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivMovie;
        private TextView tvTitle;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivMovie = itemView.findViewById(R.id.iv_movie);
            tvTitle = itemView.findViewById(R.id.tv_movie);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickItemMovie.onClickItemMovie(getAdapterPosition());
                }
            });
        }
    }

    public interface OnClickItemMovie{
        void onClickItemMovie(int position);
    }
}
