package com.curd.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkerClass {

    void hello(){
        System.out.println("hello");
    }

    public static void main(String[] args) {
        AnimalFactory af = new AnimalFactory();

        Animal animal = af.getInstance("dog");
        animal.eat();
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("#hello");
        list.add("3hello");
        list.add("Hello");

        Collections.sort(list);
        System.out.println(list);
    }
}
