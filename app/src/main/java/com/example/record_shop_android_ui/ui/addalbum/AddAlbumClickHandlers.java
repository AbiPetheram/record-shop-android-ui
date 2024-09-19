package com.example.record_shop_android_ui.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.record_shop_android_ui.model.Album;
import com.example.record_shop_android_ui.ui.mainactivity.MainActivity;
import com.example.record_shop_android_ui.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandlers {
    Album album;
    Context context;
    MainActivityViewModel viewModel;

    public AddAlbumClickHandlers(Album album, Context context, MainActivityViewModel viewModel) {
        this.album = album;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void submitButton(View view){
        if(album.getAlbumName() == null || album.getArtistName() == null || album.getGenre() == null
                || album.getReleaseYear() == null || album.getStock() == null){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);

            Album newAlbum = new Album(
                    album.getId(),
                    album.getAlbumName(),
                    album.getArtistName(),
                    album.getReleaseYear(),
                    album.getGenre(),
                    album.getStock()
            );
            viewModel.addAlbum(newAlbum);
        }
    }
}
