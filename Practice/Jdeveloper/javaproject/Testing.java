package javaproject;

public class Testing {
    public Testing() {
        super();
    
    Animal a = new Dog();
    Dog d = (Dog)new Animal();
    }
    
    public static void main(String[] args){
        Testing t = new Testing();
    }
}

class Animal{
    
}

class Dog extends Animal{
    
}

class Cat extends Animal{
    
}