package com.example.myapp.RecycleView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Song {
    private String Title;
    private String Content;
    private int IdImage;

    public Song(String title, String content, int idImage) {
        Title = title;
        Content = content;
        IdImage = idImage;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public int getIdImage() {
        return IdImage;
    }

    public void setIdImage(int idImage) {
        IdImage = idImage;
    }
}
