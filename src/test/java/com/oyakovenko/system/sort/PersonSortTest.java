package com.oyakovenko.system.sort;

import com.oyakovenko.system.model.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class PersonSortTest {

    ArrayList<Person> personArrayList;

    @BeforeEach
    void setUp() {
        personArrayList = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            int height = (int) (Math.random() * (Person.MAX_HEIGHT - Person.MIN_HEIGHT) + Person.MIN_HEIGHT);
            int weight = (int) (Math.random() * (Person.MAX_WEIGHT - Person.MIN_WEIGHT) + Person.MIN_WEIGHT);
            int age = (int) (Math.random() * (Person.MAX_AGE - Person.MIN_AGE) + Person.MIN_AGE);

            personArrayList.add(new Person(height, weight, age));
        }
    }

    @Test
    void sortByAge() {
        Person[] people = personArrayList.toArray(new Person[0]);

        Person[] people2 = personArrayList.toArray(new Person[0]);

        PersonSort.sortByAge(people);

        Arrays.sort(people2, Comparator.comparingInt(Person::getAge));

        Assertions.assertArrayEquals(people, people2);
    }

    @Test
    void sortByHeight() {
        Person[] people = personArrayList.toArray(new Person[0]);

        Person[] people2 = personArrayList.toArray(new Person[0]);

        PersonSort.sortByHeight(people);

        Arrays.sort(people2, Comparator.comparingInt(Person::getHeight));

        Assertions.assertArrayEquals(people, people2);
    }

    @Test
    void sortByWeight() {
        Person[] people = personArrayList.toArray(new Person[0]);

        Person[] people2 = personArrayList.toArray(new Person[0]);

        PersonSort.sortByWeight(people);

        Arrays.sort(people2, Comparator.comparingInt(Person::getWeight));

        Assertions.assertArrayEquals(people, people2);
    }

    @Test
    void getCount() {
        personArrayList = new ArrayList<>();

        personArrayList.add(new Person(180, 45, 24));
        personArrayList.add(new Person(167, 70, 54));
        personArrayList.add(new Person(180, 45, 32));
        personArrayList.add(new Person(140, 55, 22));
        personArrayList.add(new Person(200, 55, 19));
        personArrayList.add(new Person(180, 70, 57));
        personArrayList.add(new Person(180, 89, 95));
        personArrayList.add(new Person(180, 45, 44));
        personArrayList.add(new Person(180, 70, 67));
        personArrayList.add(new Person(155, 68, 73));
        personArrayList.add(new Person(180, 100, 45));

        Person[] people = personArrayList.toArray(new Person[0]);

        Assertions.assertEquals(4, PersonSort.getCount(people));
    }
}
