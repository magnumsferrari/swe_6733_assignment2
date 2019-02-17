package com.Zoo;

public class Animal {

    int age;
    double weighInPound;
    String gender;

    public Animal(int age, double weighInPound, String gender) {
        this.age = age;
        this.weighInPound = weighInPound;
        this.gender = gender;
    }


    public void eating() {
        System.out.println("eating........");
    }

    public void sleeping() {
        System.out.println("sleeping.........");
    }
}
