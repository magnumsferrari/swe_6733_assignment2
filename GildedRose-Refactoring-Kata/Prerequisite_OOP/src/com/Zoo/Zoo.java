package com.Zoo;

public class Zoo {
    public static void main(String[] args) {
        Animal animall = new Animal(34,22.00, "female");
        Animal animal2 = new Animal(22,55.00, "male");
        Animal animal3 = new Animal(14, 33.00,"femaile");

        animall.eating();
        animal2.sleeping();

        Bird bird = new Bird();
        bird.fly();

        Fish fish = new Fish();
        fish.swimming();

    }
}
