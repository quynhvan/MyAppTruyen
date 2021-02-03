package com.example.myapp.Json;

public class Error {
    private String status;
    private String detail;
    private String pointer;
    private String title;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        this.pointer = pointer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Error(String status, String detail, String pointer, String title) {
        this.status = status;
        this.detail = detail;
        this.pointer = pointer;
        this.title = title;
    }
}

//    private Source source;

