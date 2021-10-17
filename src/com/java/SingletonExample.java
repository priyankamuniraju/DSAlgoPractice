package com.java;

public class SingletonExample {

    // private constructor
    private SingletonExample(){
    }

    private static class HolderClass {
        static final SingletonExample instance = new SingletonExample();
    }

    public static SingletonExample getInstance(){
        return HolderClass.instance;
    }
}
