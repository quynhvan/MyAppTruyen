package com.example.myapp.audio.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Truyen implements Parcelable {
    private int idImage;
    private String title;


    public Truyen(int idImage, String title) {
        this.idImage = idImage;
        this.title = title;

    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }




    public static Creator<Truyen> getCREATOR() {
        return CREATOR;
    }

    protected Truyen(Parcel in) {
        idImage = in.readInt();
        title = in.readString();

    }

    public static final Creator<Truyen> CREATOR = new Creator<Truyen>() {
        @Override
        public Truyen createFromParcel(Parcel in) {
            return new Truyen(in);
        }

        @Override
        public Truyen[] newArray(int size) {
            return new Truyen[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idImage);
        parcel.writeString(title);

    }
}
