package com.example.record_shop_android_ui.model;

public class Album {
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

    public long getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public long getReleaseYear() {
        return releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public long getStock() {
        return stock;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public void setReleaseYear(long releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }
}
