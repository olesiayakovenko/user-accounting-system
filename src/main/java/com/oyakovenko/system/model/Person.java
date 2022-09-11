package com.oyakovenko.system.model;

public class Person {
    public static final int MAX_HEIGHT = 200;
    public static final int MIN_HEIGHT = 0;
    public static final int MAX_WEIGHT = 150;
    public static final int MIN_WEIGHT = 0;
    public static final int MAX_AGE = 100;
    public static final int MIN_AGE = 18;

    private int height;
    private int weight;
    private int age;

    public Person(int height, int weight, int age) {
        if (height >= MIN_HEIGHT && height <= MAX_HEIGHT &&
                weight >= MIN_WEIGHT && weight <= MAX_WEIGHT &&
                age >= MIN_AGE && age <= MAX_AGE) {
            this.height = height;
            this.weight = weight;
            this.age = age;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        if (height >= MIN_HEIGHT && height <= MAX_HEIGHT) {
            this.height = height;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (weight >= MIN_WEIGHT && weight <= MAX_WEIGHT) {
            this.weight = weight;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= MIN_AGE && age <= MAX_AGE) {
            this.age = age;
        } else {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}
