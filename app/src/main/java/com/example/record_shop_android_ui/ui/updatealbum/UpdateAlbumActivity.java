package com.example.record_shop_android_ui.ui.updatealbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.record_shop_android_ui.R;
import com.example.record_shop_android_ui.databinding.ActivityUpdateAlbumBinding;
import com.example.record_shop_android_ui.model.Album;
import com.example.record_shop_android_ui.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {
    private Album album;
    private ActivityUpdateAlbumBinding binding;
    private UpdateAlbumClickHandler clickHandler;
    private final String ALBUM_KEY = "album";
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_update_album);

        album = getIntent().getParcelableExtra(ALBUM_KEY);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_album);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        clickHandler = new UpdateAlbumClickHandler(album, viewModel, this);
        binding.setAlbum(album);
        binding.setClickHandler(clickHandler);
    }
}