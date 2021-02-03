package com.example.myapp.Json;

public class ColorObject {
    private String color;
    private String value;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ColorObject(String color, String value) {
        this.color = color;
        this.value = value;
    }
}
