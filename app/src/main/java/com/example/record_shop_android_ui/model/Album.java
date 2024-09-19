package com.example.record_shop_android_ui.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.record_shop_android_ui.BR;

public class Album extends BaseObservable {
    private Long id;
    private String albumName;
    private String artistName;
    private Long releaseYear;
    private String genre;
    private Long stock;

    public Album(Long id, String albumName, String artistName, Long releaseYear, String genre, Long stock) {
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
    public String getReleaseYear() {
        return String.valueOf(releaseYear);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    @Bindable
    public String getStock() {
        return String.valueOf(stock);
    }

    public void setId(String id) {
        try{
            this.id = Long.parseLong(id);
        } catch(NumberFormatException e){
            this.id = null;
        }
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

    public void setReleaseYear(String releaseYear) {
        try{
            this.releaseYear = Long.parseLong(releaseYear);
        } catch(NumberFormatException e){
            this.releaseYear = null;
        }
        notifyPropertyChanged(BR.id);
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.id);
    }

    public void setStock(String stock) {
        try{
            this.stock = Long.parseLong(stock);
        } catch(NumberFormatException e){
            this.stock = null;
        }
        notifyPropertyChanged(BR.id);
    }
}
