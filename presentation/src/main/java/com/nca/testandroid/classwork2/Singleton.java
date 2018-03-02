package com.nca.testandroid.classwork2;

public class Singleton {

    private static Singleton instance = new Singleton();
    public String text;

    public static Singleton getInstance(){
        return instance;
    }
}