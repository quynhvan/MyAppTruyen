package com.example.myapp.interfaces;

// nếu không muốn override phương thức fly() từ Animal thì phải là class abstract
public abstract class Cat implements Animal{

    @Override
    public void move() {
        System.out.println("Run as fast as possible");
    }

    @Override
    public void eat() {
        System.out.println("Cat likes mouse");

    }
}
