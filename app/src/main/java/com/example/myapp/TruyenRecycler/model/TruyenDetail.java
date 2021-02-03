package com.example.myapp.TruyenRecycler.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TruyenDetail  implements Parcelable {
    private String title;
    private int idImage;
    private String content;


    public TruyenDetail(int idImage, String title, String content) {
        this.title = title;
        this.idImage = idImage;
        this.content = content;
    }

    protected TruyenDetail(Parcel in) {
        title = in.readString();
        idImage = in.readInt();
        content = in.readString();
    }

    public TruyenDetail() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static Creator<TruyenDetail> getCREATOR() {
        return CREATOR;
    }

    public static final Creator<TruyenDetail> CREATOR = new Creator<TruyenDetail>() {
        @Override
        public TruyenDetail createFromParcel(Parcel in) {
            return new TruyenDetail(in);
        }

        @Override
        public TruyenDetail[] newArray(int size) {
            return new TruyenDetail[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(title);
        dest.writeString(content);
        dest.writeInt(idImage);
    }
}
