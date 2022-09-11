package com.oyakovenko.system;

import com.oyakovenko.system.model.Person;
import com.oyakovenko.system.sort.PersonSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> personArrayList = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            int height = (int) (Math.random() * (Person.MAX_HEIGHT - Person.MIN_HEIGHT) + Person.MIN_HEIGHT);
            int weight = (int) (Math.random() * (Person.MAX_WEIGHT - Person.MIN_WEIGHT) + Person.MIN_WEIGHT);
            int age = (int) (Math.random() * (Person.MAX_AGE - Person.MIN_AGE) + Person.MIN_AGE);

            personArrayList.add(new Person(height, weight, age));
        }

        Person[] people = personArrayList.toArray(new Person[0]);
        Person[] people2 = personArrayList.toArray(new Person[0]);

        long timeTemp;

        timeTemp = System.currentTimeMillis();
        PersonSort.sortByAge(people);
        System.out.println("Counting sort time: " + (System.currentTimeMillis() - timeTemp));

        timeTemp = System.currentTimeMillis();
        Arrays.sort(people2, Comparator.comparingInt(Person::getAge));
        System.out.println("Arrays sort time: " + (System.currentTimeMillis() - timeTemp));

        System.out.println("The sorted arrays match: " + Arrays.equals(people, people2));
    }
}
