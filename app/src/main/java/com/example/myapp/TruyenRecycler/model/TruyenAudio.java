package com.example.myapp.TruyenRecycler.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TruyenAudio implements Parcelable {
    private int idImage;
    private int idAudio;
    private String title;
    private boolean isLike;
    private String duration;
    private String Category;

    public TruyenAudio(int idImage, int idAudio, String title, boolean isLike) {
        this.idImage = idImage;
        this.idAudio = idAudio;
        this.title = title;
        this.isLike = isLike;
    }

    protected TruyenAudio(Parcel in) {
        idImage = in.readInt();
        idAudio = in.readInt();
        title = in.readString();
        Category = in.readString();
        isLike = in.readByte() != 0;
    }

    public static final Creator<TruyenAudio> CREATOR = new Creator<TruyenAudio>() {
        @Override
        public TruyenAudio createFromParcel(Parcel in) {
            return new TruyenAudio(in);
        }

        @Override
        public TruyenAudio[] newArray(int size) {
            return new TruyenAudio[size];
        }
    };

    public int getIdImage() {
        return idImage;
    }

    public void setIdImage(int idImage) {
        this.idImage = idImage;
    }

    public int getIdAudio() {
        return idAudio;
    }

    public void setIdAudio(int idAudio) {
        this.idAudio = idAudio;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getIsLike() {
        return isLike;
    }

    public void setLike(boolean like) {
        isLike = like;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(idImage);
        parcel.writeInt(idAudio);
        parcel.writeString(title);
        parcel.writeString(Category);
        parcel.writeByte((byte) (isLike ? 1 : 0));
    }
}
