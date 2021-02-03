package com.example.myapp.Json;

public class error2 {
    private String status;
    private String detail;
    private String title;
    private String pointer;

    public error2(String status, String detail, String title, String pointer) {
        this.status = status;
        this.detail = detail;
        this.title = title;
        this.pointer = pointer;
    }

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPointer() {
        return pointer;
    }

    public void setPointer(String pointer) {
        this.pointer = pointer;
    }
}
