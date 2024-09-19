package com.example.record_shop_android_ui.model;

import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import com.example.record_shop_android_ui.BR;

public class Album extends BaseObservable {
    private Long id;
    private String albumName;
    private String artistName;
    private Integer releaseYear;
    private String genre;
    private Integer stock;

    public Album(Long id, String albumName, String artistName, Integer releaseYear, String genre, Integer stock) {
        this.id = id;
        this.albumName = albumName;
        this.artistName = artistName;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.stock = stock;
    }

    public Album() {
    }

    @Bindable
    public Long getId() {
        return id;
    }

    @Bindable
    public String getAlbumName() {
        return albumName;
    }

    @Bindable
    public String getArtistName() {
        return artistName;
    }

    @Bindable
    public Integer getReleaseYear() {
        return releaseYear;
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    @Bindable
    public Integer getStock() {
        return stock;
    }

    public void setId(Long id){
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
        notifyPropertyChanged(BR.id);
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
        notifyPropertyChanged(BR.id);
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.id);
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.id);
    }

    public void setStock(Integer stock) {
        this.stock = stock;
        notifyPropertyChanged(BR.id);
    }
}
