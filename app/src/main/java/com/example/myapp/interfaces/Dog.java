package com.example.myapp.interfaces;

import java.io.Serializable;

// lớp dog chỉ kế thừa từ một lớp , nhưng có thế implement nhiều lớp
public abstract class Dog implements Animal, Serializable {
    @Override
    public void move() {
        System.out.println("Dog move faster cat");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats meat");
    }
}
