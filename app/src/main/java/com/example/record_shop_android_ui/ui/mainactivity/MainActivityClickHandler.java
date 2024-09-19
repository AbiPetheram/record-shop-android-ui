package com.example.record_shop_android_ui.ui.mainactivity;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.record_shop_android_ui.ui.addalbum.AddNewAlbumActivity;

public class MainActivityClickHandler {
    Context context;

    public MainActivityClickHandler(Context context) {
        this.context = context;
    }

    public void onClickAddAlbum(View view){
        Intent intent = new Intent(context, AddNewAlbumActivity.class);
        context.startActivity(intent);
    }
}
