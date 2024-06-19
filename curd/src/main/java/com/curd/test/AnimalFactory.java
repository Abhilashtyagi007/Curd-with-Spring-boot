package com.curd.test;

public class AnimalFactory {

    public Animal getInstance(String animal){
        if(animal.equals("dog")){
            return new Dog();
        }else if(animal.equals("tiget")){
            return new Tiger();
        }
        return null;
    }
}
