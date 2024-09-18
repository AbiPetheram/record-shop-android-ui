package com.example.record_shop_android_ui.service;

import android.app.Application;

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
}
