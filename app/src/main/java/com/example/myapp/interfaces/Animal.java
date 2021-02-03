package com.example.myapp.interfaces;

import java.io.Serializable;

// mục đích : đạt được tính trừu tượng hoàn toàn
// đa kế thừa trong interface
// class bình thường không đa kế thừa được
//
public interface Animal extends Comparable, Serializable {
     void move();
     void eat();
     void fly();
}
