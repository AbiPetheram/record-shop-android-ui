package com.example.record_shop_android_ui.service;

import com.example.record_shop_android_ui.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AlbumApiService {
    @GET("api/v1/album")
    Call<List<Album>> getAllAlbums();

    @POST("api/v1/album")
    Call<Album> addAlbum(@Body Album album);
}
