package com.example.record_shop_android_ui.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.record_shop_android_ui.R;
import com.example.record_shop_android_ui.databinding.AlbumLayoutBinding;
import com.example.record_shop_android_ui.model.Album;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {
    List<Album> albumList;
    Context context;
    private final RecyclerViewInterface recyclerViewInterface;

    public AlbumAdapter(Context context, List<Album> albumList, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.albumList = albumList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AlbumLayoutBinding albumLayoutBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_layout,
                parent,
                false);
        return new AlbumViewHolder(albumLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.albumLayoutBinding.setAlbum(albumList.get(position));
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder{
        AlbumLayoutBinding albumLayoutBinding;

        public AlbumViewHolder(AlbumLayoutBinding albumLayoutBinding, RecyclerViewInterface recyclerViewInterface) {
            super(albumLayoutBinding.getRoot());
            this.albumLayoutBinding = albumLayoutBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
