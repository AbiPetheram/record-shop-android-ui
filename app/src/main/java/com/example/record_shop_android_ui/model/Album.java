package com.example.record_shop_android_ui.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.record_shop_android_ui.BR;

public class Album extends BaseObservable {
    private long id;
    private String albumName;
    private String artistName;
    private long releaseYear;
    private String genre;
    private long stock;

    public Album(long id, String albumName, String artistName, long releaseYear, String genre, long stock) {
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
    public long getId() {
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
    public String getReleaseYear() {
        return String.valueOf(releaseYear);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    @Bindable
    public long getStock() {
        return stock;
    }

    public void setId(long id) {
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

    public void setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
        notifyPropertyChanged(BR.id);
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.id);
    }

    public void setStock(long stock) {
        this.stock = stock;
        notifyPropertyChanged(BR.id);
    }
}
