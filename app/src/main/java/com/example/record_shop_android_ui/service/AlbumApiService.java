package com.example.record_shop_android_ui.service;

import com.example.record_shop_android_ui.model.Album;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlbumApiService {
    @GET("api/v1/album")
    Call<List<Album>> getAllAlbums();

    @POST("api/v1/album")
    Call<Album> addAlbum(@Body Album album);

    @PUT("api/v1/album/{id}")
    Call<Album> updateAlbum(@Path("id") Long id, @Body Album album);

    @DELETE("api/v1/album/{id}")
    Call<ResponseBody> deleteAlbum(@Path("id") Long id);
}
