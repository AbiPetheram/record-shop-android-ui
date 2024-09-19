package com.example.record_shop_android_ui.service;

import android.app.Application;
import android.provider.MediaStore;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.record_shop_android_ui.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {
    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    public AlbumRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Album>> getMutableLiveData(){
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAllAlbums();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> liveAlbumList = response.body();
                mutableLiveData.setValue(liveAlbumList);
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {

            }
        });
        return mutableLiveData;
    }

    public void addAlbum(Album album){
        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.addAlbum(album);
        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {
                Toast.makeText(application.getApplicationContext(),
                        response.body().getAlbumName() + " added to database",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {
                Toast.makeText(application.getApplicationContext(),
                        "Unable to add album to database",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
