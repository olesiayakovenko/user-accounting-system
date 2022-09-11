package com.oyakovenko.system.sort;

import com.oyakovenko.system.model.Person;

import java.util.Arrays;

public class PersonSort {

    // 4. If k could be equal to 1, the linear complexity would be O(n)
    public static void sortByAge(Person[] persons) { // O(n+k)
        int n = persons.length;

        Person[] result = new Person[n];
        int[] count = new int[Person.MAX_AGE + 1];

        for (Person person : persons) { // O(n)
            count[person.getAge()]++;
        }

        for (int i = 1; i <= Person.MAX_AGE; i++) { // O(k)
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) { // O(n)
            result[--count[persons[i].getAge()]] = persons[i];
        }

        System.arraycopy(result, 0, persons, 0, n);
    }

    public static void sortByHeight(Person[] persons) { // O(n+k)
        int n = persons.length;

        Person[] result = new Person[n];
        int[] count = new int[Person.MAX_HEIGHT + 1];

        for (Person person : persons) { // O(n)
            count[person.getHeight()]++;
        }

        for (int i = 1; i <= Person.MAX_HEIGHT; i++) { // O(k)
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) { // O(n)
            result[--count[persons[i].getHeight()]] = persons[i];
        }

        System.arraycopy(result, 0, persons, 0, n);
    }

    public static void sortByWeight(Person[] persons) { // O(n+k)
        int n = persons.length;

        Person[] result = new Person[n];
        int[] count = new int[Person.MAX_WEIGHT + 1];

        for (Person person : persons) { // O(n)
            count[person.getWeight()]++;
        }

        for (int i = 1; i <= Person.MAX_WEIGHT; i++) { // O(k)
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) { // O(n)
            result[--count[persons[i].getWeight()]] = persons[i];
        }

        System.arraycopy(result, 0, persons, 0, n);
    }

    public static int getCount(Person[] persons) { // O(n+k)
        Person[] copy = Arrays.copyOf(persons, persons.length);
        sortByWeight(copy); // O(n+k)

        int counter = 0;

        for (int i = 0; i < copy.length - 1; i++) { // O(n)
            int currentWeight = copy[i].getWeight();
            int nextWeight = copy[i + 1].getWeight();

            int currentHeight = copy[i].getHeight();
            int nextHeight = copy[i + 1].getHeight();

            if (currentWeight == nextWeight && currentHeight != nextHeight) {
                counter++;

                if (i == 0 || currentWeight != copy[i - 1].getWeight()) {
                    counter++;
                }
            }
        }

        return counter;
    }
}
