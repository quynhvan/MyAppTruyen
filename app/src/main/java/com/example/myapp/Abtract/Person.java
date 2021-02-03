package com.example.myapp.Abtract;

public abstract class Person {
    // chỉ muốn khai báo hàm lương để các class con của person override lại hàm tính lươn
    // trong hàm abtract không có nội dung
    // bất cứ class con extend từ Person đều phải override hàm lương
    //hàm abtract chỉ tồn tại bên trong class abtract
    // một abtract class có thể kế thừa từ abtract class
    public abstract double luong();
}
