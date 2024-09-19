package com.example.record_shop_android_ui.ui.addalbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.record_shop_android_ui.R;
import com.example.record_shop_android_ui.databinding.ActivityAddNewAlbumBinding;
import com.example.record_shop_android_ui.model.Album;
import com.example.record_shop_android_ui.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {
    private Album album;
    private AddAlbumClickHandlers clickHandlers;
    private ActivityAddNewAlbumBinding binding;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_album);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        album = new Album();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);
        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        clickHandlers = new AddAlbumClickHandlers(album, this, viewModel);
        binding.setAlbum(album);
        binding.setClickHandler(clickHandlers);

    }
}