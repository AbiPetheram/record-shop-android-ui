package com.example.record_shop_android_ui.ui.updatealbum;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.example.record_shop_android_ui.model.Album;
import com.example.record_shop_android_ui.ui.mainactivity.MainActivity;
import com.example.record_shop_android_ui.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumClickHandler {
    private Album album;
    private MainActivityViewModel viewModel;
    private Long id;
    private Context context;

    public UpdateAlbumClickHandler(Album album, MainActivityViewModel viewModel, Context context) {
        this.album = album;
        this.viewModel = viewModel;
        this.context = context;
    }

    public void onUpdateButtonClicked(View view){
        if(album.getAlbumName() == null || album.getArtistName() == null || album.getGenre() == null
                || album.getReleaseYear() == null || album.getStock() == null){
            Toast.makeText(context, "Fields cannot be empty", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(context, MainActivity.class);

            Album newAlbum = new Album(
                    album.getId(),
                    album.getAlbumName(),
                    album.getArtistName(),
                    Integer.parseInt(album.getReleaseYear()),
                    album.getGenre(),
                    Integer.parseInt(album.getStock())
            );
            viewModel.updateAlbum(newAlbum.getId(), newAlbum);
            context.startActivity(intent);
        }
    }

    public void onDeleteButtonClicked(View view){
        new AlertDialog.Builder(context)
                .setTitle("Delete album")
                .setMessage("Are you sure you want to delete this album?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(context, MainActivity.class);
                        viewModel.deleteAlbum(album.getId());
                        context.startActivity(intent);
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    public void onBackButtonClicked(View view){
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

}
