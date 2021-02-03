package com.example.myapp.TruyenRecycler.model;

import android.os.Parcel;
import android.os.Parcelable;

import kotlin.jvm.internal.PropertyReference0Impl;

public class Truyen implements Parcelable {
    private int IdImage;
    private String title;
    private int idContent;
    private String Category;
    public Truyen(int idImage, String title, int idContent) {
        IdImage = idImage;
        this.title = title;
        this.idContent = idContent;
    }
    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    protected Truyen(Parcel in) {
        IdImage = in.readInt();
        title = in.readString();
        idContent = in.readInt();
        Category = in.readString();

    }

    public int getIdImage() {
        return IdImage;
    }

    public void setIdImage(int idImage) {
        IdImage = idImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getContent() {
        return idContent;
    }

    public void setContent(int content) {
        this.idContent = idContent;
    }

    public static Creator<Truyen> getCREATOR() {
        return CREATOR;
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
        parcel.writeInt(IdImage);
        parcel.writeString(title);
        parcel.writeInt(idContent);
        parcel.writeString(Category);

    }
}
