package com.example.record_shop_android_ui.ui.updatealbum;

import android.content.Context;

import com.example.record_shop_android_ui.model.Album;
import com.example.record_shop_android_ui.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumClickHandlers {
    private Album album;
    private MainActivityViewModel viewModel;
    private Long id;
    private Context context;

    public UpdateAlbumClickHandlers(Album album, MainActivityViewModel viewModel, Context context) {
        this.album = album;
        this.viewModel = viewModel;
        this.context = context;
    }


}
