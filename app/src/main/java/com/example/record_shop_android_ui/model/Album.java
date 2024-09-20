package com.example.record_shop_android_ui.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;

import com.example.record_shop_android_ui.BR;

public class Album extends BaseObservable implements Parcelable {
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

    protected Album(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readLong();
        }
        albumName = in.readString();
        artistName = in.readString();
        if (in.readByte() == 0) {
            releaseYear = null;
        } else {
            releaseYear = in.readInt();
        }
        genre = in.readString();
        if (in.readByte() == 0) {
            stock = null;
        } else {
            stock = in.readInt();
        }
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

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
        if(releaseYear==null){
            return null;
        }
        return String.valueOf(releaseYear);
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    @Bindable
    public String getStock() {
        if(stock==null){
            return null;
        }
        return String.valueOf(stock);
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

    public void setReleaseYear(String releaseYear) {

        try{
            this.releaseYear = Integer.parseInt(releaseYear);
        } catch (NumberFormatException e){
            this.releaseYear = null;
        }
        notifyPropertyChanged(BR.id);
    }

    public void setGenre(String genre) {
        this.genre = genre.toUpperCase();
        notifyPropertyChanged(BR.id);
    }

    public void setStock(String stock) {
        try{
            this.stock = Integer.parseInt(stock);
        } catch (NumberFormatException e){
            this.stock = null;
        }
        notifyPropertyChanged(BR.id);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        if (id == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(id);
        }
        parcel.writeString(albumName);
        parcel.writeString(artistName);
        if (releaseYear == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(releaseYear);
        }
        parcel.writeString(genre);
        if (stock == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(stock);
        }
    }
}
