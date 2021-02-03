package com.example.myapp.RecycleView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;

import java.util.ArrayList;
//viewholder là nơi ánh xạ

class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {
    @NonNull
    // đối tượng layoutInflate  dùng để tạo view
    private LayoutInflater inflater;
    private Context context;
    private ArrayList<Song> listSong;
    //tạo interface
    private OnItemClickListener onItemClickListener;

    public AdapterRecycler(Context context, ArrayList<Song> listSong) {
        this.context = context;
        this.listSong = listSong;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recycleview, parent, false);
        return new MyViewHolder(view);
    }

    // nơi đổ dữ liệu lên các view
    //holder nắm dữ các đối tượng dữ liệu
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // trả về đối tương
        Song song = listSong.get(position);
        holder.ivThumbnail.setImageResource(song.getIdImage());
        holder.tvTitle.setText(song.getTitle());
        holder.tvContent.setText(song.getContent());

    }

    //trả về số lượng trong danh sách
    @Override
    public int getItemCount() {
        return listSong.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // thực hiện ánh xạ view trong viewholder - no tương ứng với việc ánh xạ view trong phương thức
        //getview của listview
        private ImageView ivThumbnail;
        private TextView tvTitle, tvContent;

        //mới khởi tạo chưa tạo view
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //ITEM VIEW LÀ tương ứng giống với view trong adapter của listview
            ivThumbnail = itemView.findViewById(R.id.iv_anh);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvContent = itemView.findViewById(R.id.tv_content);

            // gián tiếp thông qua itemView để định nghĩa click cho đối tượng
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
    //bộ khung cho tất cả đối tương
    // không biết interface dùng để làm gì , dùng lúc nào nên để gián tiếp trong itemView để định nghĩa hộ
    public interface OnItemClickListener {
        void onItemClick(int position);
    }
}
