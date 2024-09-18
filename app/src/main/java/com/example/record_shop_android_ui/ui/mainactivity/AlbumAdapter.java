package com.example.record_shop_android_ui.ui.mainactivity;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.record_shop_android_ui.databinding.AlbumLayoutBinding;
import com.example.record_shop_android_ui.model.Album;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    public static class AlbumViewHolder extends RecyclerView.ViewHolder{
        AlbumLayoutBinding albumLayoutBinding;

        public AlbumViewHolder(AlbumLayoutBinding albumLayoutBinding) {
            super(albumLayoutBinding.getRoot());
            this.albumLayoutBinding = albumLayoutBinding;
        }
    }

}
