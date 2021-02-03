package com.example.myapp.TruyenRecycler.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class TheLoai implements Parcelable {
    private int IdImage;
    private String title;
    private ArrayList<Truyen> dsTruyen = new ArrayList<>();

    public TheLoai() {
    }

    public TheLoai(int idImage, String title, ArrayList<Truyen> dsTruyen) {
        IdImage = idImage;
        this.title = title;
        this.dsTruyen = dsTruyen;
    }

    protected TheLoai(Parcel in) {
        IdImage = in.readInt();
        title = in.readString();
        dsTruyen = in.createTypedArrayList(Truyen.CREATOR);
    }

    public static final Creator<TheLoai> CREATOR = new Creator<TheLoai>() {
        @Override
        public TheLoai createFromParcel(Parcel in) {
            return new TheLoai(in);
        }

        @Override
        public TheLoai[] newArray(int size) {
            return new TheLoai[size];
        }
    };

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

    public ArrayList<Truyen> getDsTruyen() {
        return dsTruyen;
    }

    public void setDsTruyen(ArrayList<Truyen> dsTruyen) {
        this.dsTruyen = dsTruyen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(IdImage);
        parcel.writeString(title);
        parcel.writeTypedList(dsTruyen);
    }
}
